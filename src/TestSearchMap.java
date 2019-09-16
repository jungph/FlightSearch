package src;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class TestSearchMap {
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
		SearchMap s = new SearchMap("input_files/Testinput.txt");
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
		SearchMap s = new SearchMap("input_files/Testinput.txt");
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
		SearchMap s = new SearchMap("input_files/Testinput.txt");
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
		SearchMap s = new SearchMap("input_files/Testinput.txt");
		assertEquals('Z', s.originCity);
		File file = new File("input_files/Testinput.txt");
		file.delete();
	}
}
	
	/**
	 * Test is now obsolete. Just used to test basic functions
	 * 
	 * @Test
	 * public void readFile() {
		SearchMap s = new SearchMap();
		assertEquals("abc", s.initFileContents());
	}
	 */
	
	/**
	 * 
	 */
	
	
	/** These edge tests obsolete because method was moved to FlightMap class
	 * 
	 * 
	@Test
	public void getEdgeTest2() {
		SearchMap s = new SearchMap();
		assertEquals('W', s.edges.get(0).dest);
	}
	@Test
	public void getEdgeTest3() {
		SearchMap s = new SearchMap();
		assertEquals(200, s.edges.get(0).weight);
	}
	@Test
	public void getEdgeTest4() {
		SearchMap s = new SearchMap();
		assertEquals('W', s.edges.get(1).orig);
	}
	@Test
	public void getEdgeTest5() {
		SearchMap s = new SearchMap();
		assertEquals('E', s.edges.get(1).dest);
	}
	@Test
	public void getEdgeTest6() {
		SearchMap s = new SearchMap();
		assertEquals(250, s.edges.get(1).weight);
	}
	 * 
	 */




















