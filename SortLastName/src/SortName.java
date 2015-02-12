import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * This program takes a list of names from text file and create a new text file
 * with the names ordered by last name followed by first name
 * <p>
 * Expected reader: Robert Ovens
 * @author Yiping Zhang
 * @version 1.0
 * @since 12-02-2015
 * */
public class SortName {
	
	/**
	 * Read a list of names from text file, sort last name alphabetically, save to
	 * a new text file
	 * @param inputFileName the file from which names come from
	 * @param outputFileName created file which store sorted names
	 * */
	public void sort(String inputFileName, String outputFileName) throws IOException{
		List<String> nameList = readFromFile(inputFileName);
		Collections.sort(nameList);
		writeToFile(nameList, outputFileName);
	}

	//Did not write JavaDoc for this method since it is private  
	private List<String> readFromFile(String fileName) throws FileNotFoundException,
			IOException {
		//Can check file existence before read
		//Since both of us understand Exception message I just skip this step
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String name;
		List<String> nameList = new ArrayList<String>();
			
		while ((name = br.readLine()) != null){
			nameList.add(name);
		}
		br.close();
		
		return nameList;
	}

	private void writeToFile(List<String> nameList, String outputFileName)
			throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(outputFileName);
		
		for(String name:nameList){
			pw.write(name + "\r\n");
		}
		pw.close();
	}
}
