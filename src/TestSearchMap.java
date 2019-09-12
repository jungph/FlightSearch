package src;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestSearchMap {
	@Test
	public void getOriginTest() {
		SearchMap s = new SearchMap();
		assertEquals('P', s.getOriginCity());
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
	

}



















