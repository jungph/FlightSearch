package src;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestEdge {
	@Test
	public void testConstructor1() {
		Edge e = new Edge('P', 'W', 200);
		assertEquals(e.orig, 'P');
	}
	@Test
	public void testConstructor2() {
		Edge e = new Edge('P', 'W', 200);
		assertEquals(e.dest, 'W');
	}
	@Test
	public void testConstructor3() {
		Edge e = new Edge('P', 'W', 200);
		assertEquals(e.weight, 200);
	}
}
