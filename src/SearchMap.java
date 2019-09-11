package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SearchMap {
	String fileContent;
	
	public char getOriginCity() {
		return 'P';
	}
	
	public String fileContents() {
		String fileName = "src/input.txt";
		File file = new File(fileName);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			if (line != null) {
				while (line != null) {
					fileContent = line;
					line = br.readLine();
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return fileContent;
	}
	
	public static void main(String[] args) {
		SearchMap test = new SearchMap();
		System.out.println(test.fileContents());
	}
	
	
	
	
	
}
