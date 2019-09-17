package src;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class TestSearchMap {
	@Test
	public void defaultConstructorTest1() {
		SearchMap s = new SearchMap();
		// if cities size is not 0 (null), then s not created or it is not initialized correctly;
		assertTrue(s.cities.size() == 0);
	}
	@Test
	public void defaultConstructorTest2() {
		SearchMap s = new SearchMap();
		// if flights is not null, then flights has been initialized correctly
		assertTrue(s.flights != null);
	}
	@Test
	public void parmConstructorTest1() {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("input_files/Testinput.txt", "UTF-8");
			writer.println("P");
			writer.println("P W 200");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}finally {
			writer.close();
		}
		
		SearchMap s = new SearchMap("input_files/Testinput.txt");
		// if flights is not null, then flights has been initialized correctly
		// reading and writing functions (called by this constructor) are tested separately
		assertTrue(s.flights != null);
		File file = new File("input_files/Testinput.txt");
		file.delete();
	}
	@Test
	public void parmConstructorTest2() {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("input_files/Testinput.txt", "UTF-8");
			writer.println("P");
			writer.println("P W 200");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}finally {
			writer.close();
		}
		
		SearchMap s = new SearchMap("input_files/Testinput.txt");
		// Based on the test input file made, cities size should be 2
		assertTrue(s.cities.size() == 2);
		File file = new File("input_files/Testinput.txt");
		file.delete();
	}
	
	
	
	@Test
	public void readFileContentsTest1() {
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("input_files/Testinput.txt", "UTF-8");
			writer.println("P");
			writer.println("P W 200");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}finally {
			writer.close();
		}
		SearchMap s = new SearchMap();
		s.readFileContents("input_files/Testinput.txt");
		assertEquals('P', s.originCity);
		File file = new File("input_files/Testinput.txt");
		file.delete();
	}
	
	@Test
	public void writeSearchResultsTest1() {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("input_files/Testinput.txt", "UTF-8");
			writer.println("P");
			writer.println("P W 200");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}finally {
			writer.close();
		}
		SearchMap s = new SearchMap("input_files/Testinput.txt");
		s.writeSearchResults("output_files/Testoutput.txt");
		
	}
	@Test
	public void writeSearchResultsTest2() {
		//test for very long path
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("input_files/Testinput.txt", "UTF-8");
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
		s.readFileContents("input_files/Testinput.txt");
		assertTrue(s.flights.pathExists('Z', 'A'));
		
	}
	@Test
	public void setEdgesTest1() {
		SearchMap s = new SearchMap();
		s.setEdges("P W 200");
		assertEquals('P', s.flights.edges.get(0).orig);
	}
	@Test
	public void setEdgesTest2() {
		SearchMap s = new SearchMap();
		s.setEdges("P W 200");
		assertEquals('W', s.flights.edges.get(0).dest);
	}
	@Test
	public void setEdgesTest3() {
		SearchMap s = new SearchMap();
		s.setEdges("P W 200");
		assertEquals(200, s.flights.edges.get(0).weight);
	}
	
	@Test
	public void setEdgesTest4() {
		SearchMap s = new SearchMap();
		s.setEdges("P W 200");
		s.setEdges("W X 275");
		assertEquals('W', s.flights.edges.get(1).orig);
	}
	@Test
	public void setEdgesTest5() {
		SearchMap s = new SearchMap();
		s.setEdges("P W 200");
		s.setEdges("W X 275");
		assertEquals('X', s.flights.edges.get(1).dest);
	}
	@Test
	public void setEdgesTest6() {
		SearchMap s = new SearchMap();
		s.setEdges("P W 200");
		s.setEdges("W X 275");
		assertEquals(275, s.flights.edges.get(1).weight);
	}
	
	
	@Test
	public void getOriginTest1() {
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("input_files/Testinput.txt", "UTF-8");
			writer.println("P");
			writer.println("P W 200");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}finally {
			writer.close();
		}
		SearchMap s = new SearchMap();
		s.readFileContents("input_files/Testinput.txt");
		assertEquals('P', s.originCity);
		File file = new File("input_files/Testinput.txt");
		file.delete();
	}
	@Test
	public void getOriginTest2() {
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("input_files/Testinput.txt", "UTF-8");
			writer.println("E");
			writer.println("P W 200");
			writer.println("E X 250");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}finally {
			writer.close();
		}
		SearchMap s = new SearchMap();
		s.readFileContents("input_files/Testinput.txt");
		assertEquals('E', s.originCity);
		File file = new File("input_files/Testinput.txt");
		file.delete();
	}
	@Test
	public void getOriginTest3() {
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("input_files/Testinput.txt", "UTF-8");
			writer.println("Z");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}finally {
			writer.close();
		}
		SearchMap s = new SearchMap();
		s.readFileContents("input_files/Testinput.txt");
		assertEquals('Z', s.originCity);
		File file = new File("input_files/Testinput.txt");
		file.delete();
	}
}



















