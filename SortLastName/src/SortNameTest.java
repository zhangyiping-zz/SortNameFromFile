import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class SortNameTest {

	/*
	 * Here is just one pair of test cases. 
	 * If get more time, I shall learn how to write parameterized Junit Test in 
	 * order to run multiple pair of test cases in one Junit file. 
	 * */
	final String inputFileName = "names.txt";
	final String outputFileName = "Output.txt";
	final String actualResult = "ActualResult.txt";
	final String wrongResult = "WrongResult.txt";
	SortName sn;
	boolean flag;

	BufferedReader output;
	
	@Before
	public void createObject() throws IOException{
		flag = true;
		/*
		 * I have a question that I have never thought before here. Shall I pass 
		 * the two parameters to a method or constructor??? I think the results
		 * are the same. 
		 * */
		sn = new SortName();
		sn.sort(inputFileName, outputFileName);
		output = new BufferedReader(new FileReader(outputFileName));
	}
	
	@Test
	public void testActualResult() throws IOException {
		BufferedReader actualR = new BufferedReader(new FileReader(actualResult));
		
		CompareFiles(output, actualR);
		
		output.close();
		actualR.close();
		
		assertTrue(flag);
	}
	
	@Test
	public void testWrongResult() throws IOException{
		BufferedReader wrongR = new BufferedReader(new FileReader(wrongResult));
		
		CompareFiles(output, wrongR);
		
		output.close();
		wrongR.close();
		
		assertFalse(flag);
	}
	
	private void CompareFiles(BufferedReader output, BufferedReader compareFile)
			throws IOException {
		String line1 = null;
		String line2 = null;
		
		while(((line1 = output.readLine()) != null)&&((line2 = compareFile.readLine()) != null)){
			if(!line1.equals(line2)){
				flag = false;
				break;
			}
		}
	}

}
