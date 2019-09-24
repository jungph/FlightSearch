package src;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TestSearchMap {
	@Test
	public void getCitiesTest1() {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("Testinput.txt", "UTF-8");
			writer.println("P");
			writer.println("P W 200");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}finally {
			writer.close();
		}
		SearchMap s = new SearchMap("Testinput.txt");
		assertEquals(s.getCities().size(), 2);
		File file = new File("Testinput.txt");
		file.delete();
	}
	@Test
	public void getFlightsTest1() {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("Testinput.txt", "UTF-8");
			writer.println("P");
			writer.println("P W 200");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}finally {
			writer.close();
		}
		SearchMap s = new SearchMap("Testinput.txt");
		assertTrue(s.getFlights() != null);
		
		
		File file = new File("Testinput.txt");
		file.delete();
	}
	
	
	@Test
	public void defaultConstructorTest1() {
		SearchMap s = new SearchMap();
		// if cities size is not 0 (null), then s not created or it is not initialized correctly;
		assertTrue(s.getCities().size() == 0);
	}
	@Test
	public void defaultConstructorTest2() {
		SearchMap s = new SearchMap();
		// if flights is not null, then flights has been initialized correctly
		assertTrue(s.getFlights()!= null);
	}
	@Test
	public void parmConstructorTest1() {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("Testinput.txt", "UTF-8");
			writer.println("P");
			writer.println("P W 200");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}finally {
			writer.close();
		}
		
		SearchMap s = new SearchMap("Testinput.txt");
		// if flights is not null, then flights has been initialized correctly
		// reading and writing functions (called by this constructor) are tested separately
		assertTrue(s.getFlights() != null);
		File file = new File("Testinput.txt");
		file.delete();
	}
	@Test
	public void parmConstructorTest2() {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("Testinput.txt", "UTF-8");
			writer.println("P");
			writer.println("P W 200");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}finally {
			writer.close();
		}
		
		SearchMap s = new SearchMap("Testinput.txt");
		// Based on the test input file made, cities size should be 2
		assertTrue(s.getCities().size() == 2);
		File file = new File("Testinput.txt");
		file.delete();
	}
	
	
	
	@Test
	public void readFileContentsTest1() {
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("Testinput.txt", "UTF-8");
			writer.println("P");
			writer.println("P W 200");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}finally {
			writer.close();
		}
		SearchMap s = new SearchMap("Testinput.txt");
		assertEquals('P', s.getOriginCity());
		File file = new File("Testinput.txt");
		file.delete();
	}
	
	@Test
	public void writeSearchResultsTest1() {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("Testinput.txt", "UTF-8");
			writer.println("P");
			writer.println("P W 200");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}finally {
			writer.close();
		}
		SearchMap s = new SearchMap("Testinput.txt");
		s.writeSearchResults("Testoutput.txt");
		File file = new File("Testoutput.txt");
		assertTrue(file != null);
		file.delete();
		file = new File("Testinput.txt");
		file.delete();
	}
	@Test
	public void writeSearchResultsTest2() {
		//test for very long path
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("Testinput.txt", "UTF-8");
			writer.println("Z");
			writer.println("A B 200");
			writer.println("Z A 200");
			writer.println("B C 200");
			writer.println("C D 200");
			writer.println("D E 200");
			writer.println("F G 200");
			writer.println("E F 200");
			writer.println("G H 200");
			writer.println("I J 200");
			writer.println("H I 200");
			writer.println("J K 200");
			writer.println("L M 200");
			writer.println("K L 200");
			writer.println("M N 200");
			writer.println("N O 200");
			writer.println("P Q 200");
			writer.println("Q R 200");
			writer.println("O P 200");
			writer.println("S T 200");
			writer.println("R S 200");
			writer.println("T U 200");
			writer.println("W X 200");
			writer.println("U V 200");
			writer.println("V W 200");
			writer.println("X Y 200");
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}finally {
			writer.close();
		}
		SearchMap s = new SearchMap();
		s.readFileContents("Testinput.txt");
		assertTrue(s.getFlights().pathExists('Z', 'A'));
		File file = new File("Testinput.txt");
		file.delete();
		
	}
	@Test
	public void setEdgesTest1() {
		SearchMap s = new SearchMap();
		s.setEdges("P W 200");
		assertEquals('P', s.getFlights().getEdges().get(0).getOrig());
	}
	@Test
	public void setEdgesTest2() {
		SearchMap s = new SearchMap();
		s.setEdges("P W 200");
		assertEquals('W', s.getFlights().getEdges().get(0).getDest());
	}
	@Test
	public void setEdgesTest3() {
		SearchMap s = new SearchMap();
		s.setEdges("P W 200");
		assertEquals(200, s.getFlights().getEdges().get(0).getWeight());
	}
	
	@Test
	public void setEdgesTest4() {
		SearchMap s = new SearchMap();
		s.setEdges("P W 200");
		s.setEdges("W X 275");
		assertEquals('W', s.getFlights().getEdges().get(1).getOrig());
	}
	@Test
	public void setEdgesTest5() {
		SearchMap s = new SearchMap();
		s.setEdges("P W 200");
		s.setEdges("W X 275");
		assertEquals('X', s.getFlights().getEdges().get(1).getDest());
	}
	@Test
	public void setEdgesTest6() {
		SearchMap s = new SearchMap();
		s.setEdges("P W 200");
		s.setEdges("W X 275");
		assertEquals(275, s.getFlights().getEdges().get(1).getWeight());
	}
	
	
	@Test
	public void getOriginTest1() {
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("Testinput.txt", "UTF-8");
			writer.println("P");
			writer.println("P W 200");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}finally {
			writer.close();
		}
		SearchMap s = new SearchMap();
		s.readFileContents("Testinput.txt");
		assertEquals('P', s.getOriginCity());
		File file = new File("Testinput.txt");
		file.delete();
	}
	@Test
	public void getOriginTest2() {
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("Testinput.txt", "UTF-8");
			writer.println("E");
			writer.println("P W 200");
			writer.println("E X 250");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}finally {
			writer.close();
		}
		SearchMap s = new SearchMap();
		s.readFileContents("Testinput.txt");
		assertEquals('E', s.getOriginCity());
		File file = new File("Testinput.txt");
		file.delete();
	}
	@Test
	public void getOriginTest3() {
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("Testinput.txt", "UTF-8");
			writer.println("Z");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}finally {
			writer.close();
		}
		SearchMap s = new SearchMap();
		s.readFileContents("Testinput.txt");
		assertEquals('Z', s.getOriginCity());
		File file = new File("Testinput.txt");
		file.delete();
	}
	
	@Test
	public void mainTest() {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("Testinput55.txt", "UTF-8");
			writer.println("E");
			writer.println("P W 200");
			writer.println("E X 250");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}finally {
			writer.close();
		}
		
		String[] args = {"Testinput55.txt", "Testoutput55.txt"};
		SearchMap.main(args);
		File file = new File("Testoutput55.txt");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			assertEquals("Destination          Flight Route from E    Total Cost", br.readLine());
			assertEquals("X                    E, X                   $250", br.readLine());
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		file.delete();
		file = new File("Testinput55.txt");
		file.delete();
		
	}
}



















