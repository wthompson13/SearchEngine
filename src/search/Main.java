// Git collaborative COP-2805 (Java II) project.
// Alex Peterson, William Thompson, and David Blocher

package search;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.FlowLayout;

public class Main{

   private JFrame frame;
   private JTextField textField;
   private JRadioButton andRadioButton;
   private JRadioButton orRadioButton;
   private JPopupMenu searchTypeMenu;
   private JButton btnSearchType;
   private JRadioButton phraseRadioButton;
   private JButton searchButton;
   private ButtonGroup group;
   private JPanel centerPanel;
   private JTextArea textArea;
   private JPanel topPanel;
   private JPanel bottomPanel;
   private JButton btnViewFiles;
   
   enum SearchType {
      AND_SEARCH, OR_SEARCH, PHRASE_SEARCH
   }
   
   private SearchType searchType = SearchType.AND_SEARCH;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Main window = new Main();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
    */
   public Main() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    * @wbp.parser.entryPoint
    */
   private void initialize() {
      frame = new JFrame();
      frame.setTitle("File Search Engine");
      frame.setResizable(false);
      frame.setBounds(100, 100, 800, 600);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(new BorderLayout(0, 0));
      
      // creating file removal dialog
      RemoveFileDialog removeDialog = new RemoveFileDialog();
      
      JPanel northPanel = new JPanel();
      frame.getContentPane().add(northPanel, BorderLayout.NORTH);
      
      group = new ButtonGroup();
      northPanel.setLayout(new BorderLayout(0, 0));
      
      topPanel = new JPanel();
      northPanel.add(topPanel, BorderLayout.NORTH);
      topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
      
      // Search Type button pop-up menu
      searchTypeMenu = new JPopupMenu();
      topPanel.add(searchTypeMenu);
      
      andRadioButton = new JRadioButton("Must have all terms", true);
      andRadioButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            searchType = SearchType.AND_SEARCH;
            searchTypeMenu.setVisible(false);
         }
      });
      searchTypeMenu.add(andRadioButton);
      
      orRadioButton = new JRadioButton("May have any terms");
      orRadioButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            searchType = SearchType.OR_SEARCH;
            searchTypeMenu.setVisible(false);
         }
      });
      searchTypeMenu.add(orRadioButton);
      
      phraseRadioButton = new JRadioButton("Exact phrase");
      phraseRadioButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            searchType = SearchType.PHRASE_SEARCH;
            searchTypeMenu.setVisible(false);
         }
      });
      searchTypeMenu.add(phraseRadioButton);
      
      group.add(andRadioButton);
      group.add(orRadioButton);
      group.add(phraseRadioButton);
      
      textField = new JTextField();
      topPanel.add(textField);
      textField.setColumns(50);
      
      searchButton = new JButton("Search");
      searchButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            // call search function here
            // for now shows search type
            textArea.setText(searchType.toString());
         }
      });
      topPanel.add(searchButton);
      
      btnSearchType = new JButton("Search Type");
      topPanel.add(btnSearchType);
      
      bottomPanel = new JPanel();
      northPanel.add(bottomPanel, BorderLayout.SOUTH);
      bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
      
      JButton btnAddFile = new JButton("Add File");
      btnAddFile.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(null);
            
            if(result == JFileChooser.APPROVE_OPTION) {
               // code to get file goes here
            }
         }
      });
      bottomPanel.add(btnAddFile);
      
      JButton btnRemoveFile = new JButton("Remove File");
      btnRemoveFile.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            removeDialog.setVisible(true);
         }
      });
      bottomPanel.add(btnRemoveFile);
      
      btnViewFiles = new JButton("List Files");
      btnViewFiles.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            // put code to get file names here
            // code below is just for show
            textArea.setText("C:\\SomeFolder\\SomeFile.txt\nC:\\SomeOtherFolder\\AnotherFile.txt");
         }
      });
      bottomPanel.add(btnViewFiles);
      btnSearchType.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            Point p = btnSearchType.getLocationOnScreen();
            p.translate(0, btnSearchType.getHeight());
            searchTypeMenu.setLocation(p);
            searchTypeMenu.setVisible(!searchTypeMenu.isVisible());
         }
      });
      
      centerPanel = new JPanel();
      frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
      centerPanel.setLayout(null);
      
      textArea = new JTextArea();
      textArea.setEditable(false);
      textArea.setBounds(5, 0, 784, 538);
      textArea.setBackground(Color.WHITE);
      centerPanel.add(textArea);
   }
   
   public class RemoveFileDialog extends JDialog {

      private final JPanel contentPanel = new JPanel();

      /**
       * Create the dialog.
       */
      public RemoveFileDialog() {
         setBounds(100, 100, 450, 300);
         getContentPane().setLayout(new BorderLayout());
         contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
         getContentPane().add(contentPanel, BorderLayout.CENTER);
         contentPanel.setLayout(new BorderLayout(0, 0));
         this.setVisible(false);
         {
            // some filler to show something int the list
            String[] files = {"File 1", "File 2", "File 3"};
            
            JList<String> list = new <String>JList(files);
 
            list.setSize(100, 100);
            contentPanel.add(list);
         }
         {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
               JButton removeButton = new JButton("Remove");
               removeButton.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent arg0) {
                     // code to remove selected files from index goes here
                  }
               });
               removeButton.setActionCommand("Remove");
               buttonPane.add(removeButton);
               getRootPane().setDefaultButton(removeButton);
            }
            {
               JButton cancelButton = new JButton("Cancel");
               cancelButton.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent arg0) {
                     setVisible(false);
                  }
               });
               cancelButton.setActionCommand("Cancel");
               buttonPane.add(cancelButton);
            }
         }
      }

   }
}

    