package src;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestEdge {
	@Test
	public void testConstructor1() {
		Edge e = new Edge('P','W', 200);
		assertTrue(e != null);
	}
	@Test
	public void testGetOrig1() {
		Edge e = new Edge('P', 'W', 200);
		assertEquals(e.getOrig(), 'P');
	}
	@Test
	public void testGetDest1() {
		Edge e = new Edge('P', 'W', 200);
		assertEquals(e.getDest(), 'W');
	}
	@Test
	public void testGetWeight() {
		Edge e = new Edge('P', 'W', 200);
		assertEquals(e.getWeight(), 200);
	}
}
