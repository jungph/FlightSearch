import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;

public class TestSearchMap {
	
	/** First test method to read file successfully
	 * 
	 */
	@Test
	public void testreadfile() {
		SearchMap testReader = new SearchMap();
		try {
			testReader.readMap("src/input.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// test input should just have 1 in it
		assertEquals("SearchMap should initially just return abc", "abc", testReader.returnText());
	}
}
