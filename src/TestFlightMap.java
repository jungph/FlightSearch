package src;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestFlightMap {
	@Test
	public void testAddEdges() {
		FlightMap f = new FlightMap();
		Edge e = new Edge('P', 'W', 200);
		f.addEdge(e);
		assertTrue(f.edges.size() > 0);
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
		
		assertTrue(f.pathExists('P', 'R', 0));
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
		
		assertTrue(f.pathExists('P', 'T', 0));
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
		
		assertTrue(f.pathExists('W', 'F', 0));
	}
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
		assertTrue(f.pathExists('P', 'Y', 0));
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
		
		assertTrue(!f.pathExists('P', 'F', 0));
	}
	@Test
	public void pathNotExists2() {
		FlightMap f = new FlightMap();
		Edge e = new Edge('P', 'W', 200);
		f.addEdge(e);
		
		assertTrue(!f.pathExists('X', 'F', 0));
	}
}
