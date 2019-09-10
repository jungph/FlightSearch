import java.io.*;

public class SearchMap {
	String text;
	
	
	public void readMap(String fileName) throws IOException {
		File file = new File(fileName);
		try {
		FileReader fileRead = new FileReader(file);
		BufferedReader br = new BufferedReader(fileRead);
		String line;
		while ((line = br.readLine()) != null) {
			text = line;
		}
		} catch (FileNotFoundException e) {
			
		}
	}
	public String returnText() {
		return text;
	}
}
