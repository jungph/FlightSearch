package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SearchMap {
	public char originCity;
	public ArrayList<Edge> edges;
	
	// default constructor only for building/production
	public SearchMap() {
		this.edges = new ArrayList<Edge>();
		this.initFileContents();
	}
	
	
	// constructor with one argument -- name of input file
	public SearchMap(String[] args) {	
		this.edges = new ArrayList<Edge>();
		this.initFileContents();
	}
	
	
	// main entry point
	public static void main(String[] args) {
		SearchMap test = new SearchMap(args);
		
		
	}
	
	/**
	 * Reads the contents of input file and sets the class variables
	 * @return nothing
	 * @throws FNFE if file not found
	 * @throws IOE if error with IO
	 */
	public void initFileContents() {
		String fileName = "src/input.txt";
		File file = new File(fileName);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			if (line != null) {
				originCity = line.trim().charAt(0);
				while (line != null) {
					line = br.readLine();
					if (line == null) break;
					else {
						setEdges(line.trim());
						// then first char location is the next city
						
					}	
				}
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}
	
	/** Returns a 'trimmed' string "O D W"
	 *  where O is a char representing origin city
	 *  where D is a char representing destination city
	 *  where W is an integer representing the weight of this flight
	 * 
	 */
	public void setEdges(String line) {
		char startCity = line.charAt(0);
		line = line.substring(1).trim();
		char destCity = line.charAt(0);
		line = line.substring(1).trim();
		int weight = Integer.parseInt(line);
		Edge e = new Edge(startCity, destCity, weight);
		edges.add(e);
	}
	
	
	/** Returns the origin city
	 * 
	 * @return char representing origin city which is the first 'city' of input.txt
	 */
	public char getOriginCity() {
		return originCity;
	}

	
}
