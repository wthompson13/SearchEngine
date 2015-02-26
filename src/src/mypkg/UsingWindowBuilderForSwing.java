package src.mypkg;


import javax.swing.*;
//empty border needed for "absolute" layout. This should be changed if anyone can get layouts inside layouts to work. I could not due to unrecognized errors. 
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import java.awt.font.*;
/*
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
*/

public class UsingWindowBuilderForSwing extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField userInputTextField;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsingWindowBuilderForSwing frame = new UsingWindowBuilderForSwing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UsingWindowBuilderForSwing() {
		//Due to emptyBorder layout, disabling resizing keeps graphical appeal over user preference. 
		setResizable(false);
		//Declare local variables
		int indexedFilesCount = 0;
		
		//Create JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Create Radio Button 1
		JRadioButton searchAllButton = new JRadioButton("Search for All Terms");
		searchAllButton.setBackground(UIManager.getColor("CheckBox.background"));
		searchAllButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		searchAllButton.setSelected(true);
		searchAllButton.setBounds(36, 81, 180, 23);
		contentPane.add(searchAllButton);
		
		//Create Radio Button 2
		JRadioButton searchAnyButton = new JRadioButton("Search for ANY terms");
		searchAnyButton.setBackground(UIManager.getColor("CheckBox.background"));
		searchAnyButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		searchAnyButton.setBounds(36, 107, 180, 23);
		contentPane.add(searchAnyButton);
		
		//Create Radio Button 3
		JRadioButton searchEXACTbutton = new JRadioButton("Search for EXACT phrase");
		searchEXACTbutton.setBackground(UIManager.getColor("CheckBox.background"));
		searchEXACTbutton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		searchEXACTbutton.setBounds(36, 133, 180, 23);
		contentPane.add(searchEXACTbutton);
		
		 //Group Radio Buttons
		 ButtonGroup group = new ButtonGroup();
		 group.add(searchAllButton);
		 group.add(searchAnyButton);
		 group.add(searchEXACTbutton);
		 
		 //Show text in front of user search textbox
		 JLabel lblSearchTerm = new JLabel("Search Term:");
		 lblSearchTerm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 lblSearchTerm.setBounds(36, 58, 92, 23);
		 contentPane.add(lblSearchTerm);
		 
		 //Show "indexed Files" + variable indexedFilesCount to show imported file count
		 JLabel lblIndexedFileCount = new JLabel("Indexed Files: " + indexedFilesCount);
		 lblIndexedFileCount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 lblIndexedFileCount.setBounds(222, 156, 187, 23);
		 contentPane.add(lblIndexedFileCount);

		 //create search textField for the user to type search terms into
		 userInputTextField = new JTextField();
		 userInputTextField.setBounds(125, 61, 402, 20);
		 contentPane.add(userInputTextField);
		 userInputTextField.setColumns(10);
		 
		 //Create "Search" button
		 JButton btnSearch = new JButton("Search");
		 btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 btnSearch.setBounds(222, 92, 105, 53);
		 contentPane.add(btnSearch);
	
		 //Create "File Select" button
		 JButton btnFileSelect = new JButton("File Select");
		 btnFileSelect.setAction(action);
		 btnFileSelect.setBounds(337, 93, 92, 53);
		 contentPane.add(btnFileSelect);
		 
		 //Open IndexMaintenanceFrame.java on click
		 btnFileSelect.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
		 		IndexMaintenanceFrame s = new IndexMaintenanceFrame();
		 		s.setVisible(true);
		 	}
		 });
		 
		 
		 //Create "About" button
		 JButton btnAbout = new JButton("About");
		 btnAbout.setFont(new Font("Tahoma", Font.PLAIN, 10));
		 btnAbout.setBounds(439, 93, 88, 53);
		 contentPane.add(btnAbout);
		 
	
		 //Draw panel with a light background for top section and Title label
		 JPanel panel = new JPanel();
		 panel.setBackground(UIManager.getColor("CheckBox.background"));
		 panel.setBounds(0, 0, 583, 179);
		 contentPane.add(panel);

		//Draw Title
		 JLabel lblSimpleSearch = new JLabel("Simple Search");
		 lblSimpleSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		 panel.add(lblSimpleSearch);
		 //Create search result display area. Cannot be edited by user.
		 JTextArea textArea = new JTextArea();
		 textArea.setEditable(false);
		 textArea.setBounds(10, 185, 563, 266);
		 contentPane.add(textArea);
		 
		 //Add content to pane
		 
		
		
		
		
		
		
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Import");
			putValue(SHORT_DESCRIPTION, "Click to open form to import files.");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
