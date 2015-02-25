// Git collaborative COP-2805 (Java II) project.
/*--- David Blocher's branch version ---*/

package search;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.FlowLayout;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;

public class Main {

   private JFrame frame;
   private JTextField textField;
   private JRadioButton andRadioButton;
   private JRadioButton orRadioButton;
   private JPopupMenu searchTypeMenu;
   private JButton btnSearchType;
   private JRadioButton phraseRadioButton;
   private JButton searchButton;

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
      
      JPanel panel = new JPanel();
      frame.getContentPane().add(panel, BorderLayout.NORTH);
      panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
      
      searchTypeMenu = new JPopupMenu();
      panel.add(searchTypeMenu);
      
      andRadioButton = new JRadioButton("Must have all terms");
      searchTypeMenu.add(andRadioButton);
      
      orRadioButton = new JRadioButton("May have any terms");
      searchTypeMenu.add(orRadioButton);
      
      phraseRadioButton = new JRadioButton("Exact phrase");
      searchTypeMenu.add(phraseRadioButton);
      
      textField = new JTextField();
      panel.add(textField);
      textField.setColumns(50);
      
      searchButton = new JButton("Search");
      panel.add(searchButton);
      
      btnSearchType = new JButton("Search Type");
      btnSearchType.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            Point p = btnSearchType.getLocationOnScreen();
            p.translate(0, btnSearchType.getHeight());
            searchTypeMenu.setLocation(p);
            searchTypeMenu.setVisible(!searchTypeMenu.isVisible());
         }
      });
      panel.add(btnSearchType);
   }

   private static void addPopup(Component component, final JPopupMenu popup) {
   }
}

    