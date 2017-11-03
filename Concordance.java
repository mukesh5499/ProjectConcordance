import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Integer;

public class Concordance {

public static void main(String args[]) {
	
	HashMap<String, Integer> words = new HashMap<String, Integer>();
	
	String line = "";
	BufferedReader file;
	// Read from the Sample TEXT document
	try {
		file = new BufferedReader(new FileReader("Sample.txt"));
		String word;
		Integer I;
		// Reading lines
		while((line = file.readLine()) != null){
			// Matching words alone in the sample text file; eliminated delimiters 		
			Pattern pattern = Pattern.compile("\\w+");
			Matcher matcher = pattern.matcher(line);
			//Loop through the word in the line
			while (matcher.find()) {
				//Change the words to lower case
				word = (matcher.group().toLowerCase());
				// Word exists in the HashMap; increment the counter
			    if(words.containsKey(word)) {
			    	I = words.get(word);
			    	words.put(word, I.intValue()+1);
			    }
			    // Add the new word to the HashMap
			    else
			    	words.put(word, new Integer(1));
			}
		}
		// Sort the HashMap
			TreeMap<String, Integer> sortedWords = new TreeMap<String, Integer>();
			sortedWords.putAll(words);
			
			//Print the sorted words
			for (Map.Entry entry : sortedWords.entrySet()) {
			    System.out.println(entry.getKey() + ", " + entry.getValue());
			}
	// File not Found and IO Exception are caught here 
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	
}
