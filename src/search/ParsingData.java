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
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
		FileReader reader;
		try {
			reader = new FileReader(file);
		} catch (FileNotFoundException e) {
			// add error dialog
			return;
		}
		
		char [] fileContent = new char[(int) file.length()];
		try {
			reader.read(fileContent, 0, (int) file.length());
		} catch (IOException e) {
			// add error dialog
			return;
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// add error dialog
				return;
			}
		}
		
		// add each word from the char [] to an ArrayList
		ArrayList<String> wordList = new ArrayList<String>();
		String s = "";
		for (int i = 0; i < fileContent.length; i++) {
			if (fileContent[i] >= 'a' && fileContent[i] <= 'z' ||
				fileContent[i] >= 'A' && fileContent[i] <= 'Z' ||
				fileContent[i] >= '0' && fileContent[i] <= '9') {
				s += fileContent[i];
			} else if (s != "") {
				wordList.add(s.toLowerCase()); // making all words lower case in index
				s = "";
			}
		}
		
		// get index contents as an ArrayList
		ArrayList<String> index = readIndex();
		
		// write to index file
	}
	
	// Remove a file from the index
	static void removeFile() {
		
	}
	
	// get the contents of the index in ArrayList form
	static ArrayList<String> readIndex() {
		ArrayList<String> index = new ArrayList<String>();
		int ch, EOF = -1;
		String s = "";
		
		try {
			
			FileReader reader = new FileReader(indexLocation);
			
			while ( (ch = reader.read()) != EOF ) {
				if ( (char) ch != '\n' && (char) ch != '\r') {
					s += (char) ch;
				} else if (s.equals("") != true) {
					index.add(s);
					s = "";
				}
			}
			
			reader.close();
		} catch (FileNotFoundException e) {
			makeNewIndex();
			readIndex();
		} catch (IOException e) {
			// error dialog here
		}
		
		return index;
	}

	//ran if index file not found
	static void makeNewIndex() {
		File newIndex = new File("SearchIndex.txt");
		try {
			newIndex.createNewFile();
		} catch (IOException e1) {
			// error dialog here
		}
		
		FileWriter writer;
		try {
			writer = new FileWriter(indexLocation);
			writer.write("0\r\n:::\r\n");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// error dialog here
		}
	}
}
