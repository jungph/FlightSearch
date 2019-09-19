package src;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;


public class TestFlightMap {
	@Test
	public void defaultConstructor1() {
		FlightMap f = new FlightMap();
		assertTrue(f.getActualPath() != null);
	}
	@Test
	public void defaultConstructor2() {
		FlightMap f = new FlightMap();
		assertTrue(f.getEdges() != null);
	}
	@Test
	public void getActualCostTest1() {
		FlightMap f = new FlightMap();
		assertEquals(f.getActualCost(), 0);
	}
	
	@Test
	public void testAddEdges() {
		FlightMap f = new FlightMap();
		Edge e = new Edge('P', 'W', 200);
		f.addEdge(e);
		assertTrue(f.getEdges().size() > 0);
	}

	@Test
	public void pathExists1() {
		FlightMap f = new FlightMap();
		Edge e = new Edge('P', 'W', 200);
		f.addEdge(e);
		e = new Edge('P', 'Z', 25);
		f.addEdge(e);
		e = new Edge('W', 'F', 25);
		f.addEdge(e);
		e = new Edge('Z', 'R', 25);
		f.addEdge(e);	
		assertTrue(f.pathExists('P', 'R'));
	}
	
	@Test
	public void pathExists2() {
		FlightMap f = new FlightMap();
		Edge e = new Edge('P', 'W', 200);
		f.addEdge(e);
		e = new Edge('R', 'Z', 25);
		f.addEdge(e);
		e = new Edge('W', 'R', 25);
		f.addEdge(e);
		e = new Edge('Z', 'T', 25);
		f.addEdge(e);
		
		assertTrue(f.pathExists('P', 'T'));
	}
	@Test
	public void pathExists3() {
		FlightMap f = new FlightMap();
		Edge e = new Edge('W', 'T', 200);
		f.addEdge(e);
		e = new Edge('R', 'Z', 25);
		f.addEdge(e);
		e = new Edge('T', 'R', 25);
		f.addEdge(e);
		e = new Edge('Z', 'F', 25);
		f.addEdge(e);
		
		assertTrue(f.pathExists('W', 'F'));
	}
	/* pathExistsHelperTest removed because it should be private
	 * Will be testing this function through pathExistsHelper which is the public
	 * method that calls this Test
	@Test
	public void pathExistsHelperTest1() {
		FlightMap f = new FlightMap();
		Edge e = new Edge('P', 'W', 200);
		f.addEdge(e);
		e = new Edge('W', 'Q', 150);
		f.addEdge(e);
		assertTrue(f.pathExistsHelper('P', 'W', f.actualCost, f.actualPath, remainingEdges));
	}
	/* pathExistsHelperTest removed because it should be private
	 * Will be testing this function through pathExistsHelper which is the public
	 * method that calls this Test

	@Test
	public void pathExistsHelperTest2() {
		FlightMap f = new FlightMap();
		Edge e = new Edge('P', 'W', 200);
		f.addEdge(e);
		e = new Edge('W', 'Q', 150);
		f.addEdge(e);
		f.actualCost = 0;
		f.actualPath = new ArrayList<Character>();
		f.actualPath.add('P');
		ArrayList<Edge> remainingEdges = new ArrayList<Edge>(f.edges);
		assertTrue(!f.pathExistsHelper('Q', 'P', f.actualCost, f.actualPath, remainingEdges));
	}
	*/
	@Test
	public void pathExists4() {
		FlightMap f = new FlightMap();
		Edge e = new Edge('P', 'W', 200);
		f.addEdge(e);
		e = new Edge('P', 'R', 300);
		f.addEdge(e);
		e = new Edge('R', 'X', 200);
		f.addEdge(e);
		e = new Edge('Q', 'X', 375);
		f.addEdge(e);
		e = new Edge('W', 'S', 250);
		f.addEdge(e);
		e = new Edge('S', 'T', 300);
		f.addEdge(e);
		e = new Edge('T', 'W', 350);
		f.addEdge(e);
		e = new Edge('W', 'Y', 500);
		f.addEdge(e);
		e = new Edge('Y', 'Z', 450);
		f.addEdge(e);
		e = new Edge('Y', 'R', 600);
		f.addEdge(e);
		assertTrue(f.pathExists('P', 'Y'));
	}
	@Test public void pathCount1() {
		FlightMap f = new FlightMap();
		Edge e = new Edge('P', 'W', 200);
		f.addEdge(e);
		e = new Edge('P', 'R', 300);
		f.addEdge(e);
		e = new Edge('R', 'X', 200);
		f.addEdge(e);
		e = new Edge('Q', 'X', 375);
		f.addEdge(e);
		e = new Edge('W', 'S', 250);
		f.addEdge(e);
		e = new Edge('S', 'T', 300);
		f.addEdge(e);
		e = new Edge('T', 'W', 350);
		f.addEdge(e);
		e = new Edge('W', 'Y', 500);
		f.addEdge(e);
		e = new Edge('Y', 'Z', 450);
		f.addEdge(e);
		e = new Edge('Y', 'R', 600);
		f.addEdge(e);
		f.pathExists('P', 'Y');
		assertEquals(700 , f.getActualCost());
	}
	@Test public void pathCount2() {
		FlightMap f = new FlightMap();
		Edge e = new Edge('P', 'W', 200);
		f.addEdge(e);
		e = new Edge('P', 'R', 300);
		f.addEdge(e);
		e = new Edge('R', 'X', 200);
		f.addEdge(e);
		e = new Edge('Q', 'X', 375);
		f.addEdge(e);
		e = new Edge('W', 'S', 250);
		f.addEdge(e);
		e = new Edge('S', 'T', 300);
		f.addEdge(e);
		e = new Edge('T', 'W', 350);
		f.addEdge(e);
		e = new Edge('W', 'Y', 500);
		f.addEdge(e);
		e = new Edge('Y', 'Z', 450);
		f.addEdge(e);
		e = new Edge('Y', 'R', 600);
		f.addEdge(e);
		f.pathExists('P', 'R');
		assertEquals(1300 , f.getActualCost());
	}
	@Test public void pathCount3() {
		FlightMap f = new FlightMap();
		Edge e = new Edge('P', 'W', 200);
		f.addEdge(e);
		e = new Edge('P', 'R', 300);
		f.addEdge(e);
		e = new Edge('R', 'X', 200);
		f.addEdge(e);
		e = new Edge('Q', 'X', 375);
		f.addEdge(e);
		e = new Edge('W', 'S', 250);
		f.addEdge(e);
		e = new Edge('S', 'T', 300);
		f.addEdge(e);
		e = new Edge('T', 'W', 350);
		f.addEdge(e);
		e = new Edge('W', 'Y', 500);
		f.addEdge(e);
		e = new Edge('Y', 'Z', 450);
		f.addEdge(e);
		e = new Edge('Y', 'R', 600);
		f.addEdge(e);
		f.pathExists('T', 'Y');
		assertEquals(850 , f.getActualCost());
	}
	@Test
	public void pathNotExists1() {
		FlightMap f = new FlightMap();
		Edge e = new Edge('P', 'W', 200);
		f.addEdge(e);
		e = new Edge('R', 'Z', 25);
		f.addEdge(e);
		e = new Edge('W', 'R', 25);
		f.addEdge(e);
		e = new Edge('F', 'R', 25);
		f.addEdge(e);
		
		assertTrue(!f.pathExists('P', 'F'));
	}
	@Test
	public void pathNotExists2() {
		FlightMap f = new FlightMap();
		Edge e = new Edge('P', 'W', 200);
		f.addEdge(e);
		
		assertTrue(!f.pathExists('X', 'F'));
	}
	@Test
	public void pathNotExists3() {
		FlightMap f = new FlightMap();
		Edge e = new Edge('P', 'W', 200);
		f.addEdge(e);
		e = new Edge('P', 'R', 300);
		f.addEdge(e);
		e = new Edge('R', 'X', 200);
		f.addEdge(e);
		e = new Edge('Q', 'X', 375);
		f.addEdge(e);
		e = new Edge('W', 'S', 250);
		f.addEdge(e);
		e = new Edge('S', 'T', 300);
		f.addEdge(e);
		e = new Edge('T', 'W', 350);
		f.addEdge(e);
		e = new Edge('W', 'Y', 500);
		f.addEdge(e);
		e = new Edge('Y', 'Z', 450);
		f.addEdge(e);
		e = new Edge('Y', 'R', 600);
		f.addEdge(e);
		f.pathExists('T', 'Y');
		assertTrue(!f.pathExists('P','Q'));
	}
	@Test
	public void pathNotExists4() {
		FlightMap f = new FlightMap();
		Edge e = new Edge('P', 'W', 200);
		f.addEdge(e);
		e = new Edge('P', 'R', 300);
		f.addEdge(e);
		e = new Edge('R', 'X', 200);
		f.addEdge(e);
		e = new Edge('Q', 'X', 375);
		f.addEdge(e);
		e = new Edge('W', 'S', 250);
		f.addEdge(e);
		e = new Edge('S', 'T', 300);
		f.addEdge(e);
		e = new Edge('T', 'W', 350);
		f.addEdge(e);
		e = new Edge('W', 'Y', 500);
		f.addEdge(e);
		e = new Edge('Y', 'Z', 450);
		f.addEdge(e);
		e = new Edge('Y', 'R', 600);
		f.addEdge(e);
		f.pathExists('T', 'Y');
		assertTrue(!f.pathExists('T','Q'));
	}
	@Test
	public void pathNotExists5() {
		FlightMap f = new FlightMap();
		Edge e = new Edge('P', 'W', 200);
		f.addEdge(e);
		e = new Edge('P', 'R', 300);
		f.addEdge(e);
		e = new Edge('R', 'X', 200);
		f.addEdge(e);
		e = new Edge('Q', 'X', 375);
		f.addEdge(e);
		e = new Edge('W', 'S', 250);
		f.addEdge(e);
		e = new Edge('S', 'T', 300);
		f.addEdge(e);
		e = new Edge('T', 'W', 350);
		f.addEdge(e);
		e = new Edge('W', 'Y', 500);
		f.addEdge(e);
		e = new Edge('Y', 'Z', 450);
		f.addEdge(e);
		e = new Edge('Y', 'R', 600);
		f.addEdge(e);
		f.pathExists('T', 'Y');
		assertTrue(!f.pathExists('R','Q'));
	}
}
