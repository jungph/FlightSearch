package src;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestSearchMap {
	
	@Test
	public void readFile() {
		SearchMap s = new SearchMap();
		assertEquals("abc", s.fileContents());
	}
	@Test
	public void getOriginCity() {
		SearchMap s = new SearchMap();
		assertEquals('P', s.getOriginCity());
	}
}
