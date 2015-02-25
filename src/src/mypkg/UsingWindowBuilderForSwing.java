package src.mypkg;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JButton;

import java.awt.GridLayout;

import javax.swing.*;
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

public class UsingWindowBuilderForSwing extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField userInputTextField;

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
		 
		 JLabel lblSearchTerm = new JLabel("Search Term:");
		 lblSearchTerm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 lblSearchTerm.setBounds(36, 58, 92, 23);
		 contentPane.add(lblSearchTerm);
		 
		 JLabel lblIndexedFileCount = new JLabel("Indexed Files: " + indexedFilesCount);
		 lblIndexedFileCount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 lblIndexedFileCount.setBounds(222, 156, 187, 23);
		 contentPane.add(lblIndexedFileCount);

		 //create search textField
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
		 btnFileSelect.setBounds(337, 93, 92, 53);
		 contentPane.add(btnFileSelect);
		 
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
		 
		 JTextArea textArea = new JTextArea();
		 textArea.setEditable(false);
		 textArea.setBounds(10, 185, 563, 266);
		 contentPane.add(textArea);
		 
		 //Add content to pane
		 
		
		
		
		
		
		
		
	}
}
