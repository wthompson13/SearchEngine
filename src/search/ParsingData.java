package search;

/**
 * Date: 3/19/2015
 * @author Alex Peterson
 * I'm not sure on how to parse the data
 * I looked at the example on the class website, but I'm still confused as to 
 * the word thing for the txt files. Do we pick any words to search for in the
 * txt file??
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class ParsingData {
    
	static String indexLocation = System.getProperty("user.dir") + "\\SearchIndex.txt";
    
	// Read a file and update the index
	static void addFile() {
		File file = null;
		
		// select and open file, else cancel
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
		} else {
			return;
		}
		
		// create a FileReader and read the file's contents into an array
		FileReader fileReader;
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			// add error dialog
			return;
		}
		
		char [] fileContent = new char[(int) file.length()];
		try {
			fileReader.read(fileContent, 0, (int) file.length());
		} catch (IOException e) {
			// add error dialog
			return;
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				// add error dialog
				return;
			}
		}
		
		
	}
	
	// Remove a file from the index
	static void removeFile() {
		
	}
	
	// Find out how many files are indexed
	static int getNumberOfIndexedFiles() {
		return 0; // stub
	}
	
	// First-time index file creation
	static void makeNewIndex() {
		
	}
}
