package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SearchMap {
	
	// main entry point
	public static void main(String[] args) {
		SearchMap t = new SearchMap();
		t.readFileContents("input_files/Testinput.txt");
		t.writeSearchResults("output_files/Testoutput.txt");
	}
	
	public char originCity;
	public FlightMap flights;
	public ArrayList<Character> cities;
	// constructor with one argument -- name of input file
	public SearchMap() {	
		this.flights = new FlightMap();
		this.cities = new ArrayList<Character>();
	}
	public SearchMap(String fileName) {
		this.flights = new FlightMap();
		this.readFileContents(fileName);
		this.cities = new ArrayList<Character>();
	}
	/**
	 * Reads the contents of input file and sets the class variables
	 * @return nothing
	 * @throws FNFE if file not found
	 * @throws IOE if error with IO
	 */
	public void readFileContents(String fileName) {
		File file = new File(fileName);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			if (line != null) {
				this.originCity = line.trim().charAt(0);
				while (line != null) {
					line = br.readLine();
					if (line == null) break;
					else {
						setEdges(line.trim());
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
	public void writeSearchResults(String fileName) {
		PrintWriter writer = null;
		try {
			String arg1 = "Destination";
			String arg2 = "Flight Route from " + originCity;
			String arg3 = "Total Cost";
			
			writer = new PrintWriter(fileName, "UTF-8");
			writer.println(String.format("%-20s %-30s %-10s", arg1, arg2, arg3));
			for (int i = 0; i < cities.size(); i++) {
				if (flights.pathExists(originCity, cities.get(i))) {
					arg1 = Character.toString(cities.get(i));
					arg2 = "";
					for (int j = 0; j < flights.actualPath.size() - 1; j++) {
						arg2 += Character.toString(flights.actualPath.get(j)) + ", ";
					}
					arg2 += Character.toString(flights.actualPath.get(flights.actualPath.size() - 1));
					arg3 = "$" + Integer.toString(flights.actualCost);
					writer.println(String.format("%-20s %-30s %-10s", arg1, arg2, arg3));
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			writer.close();
		}
		
	}
	
	/** Receives a 'trimmed' string "O D W"
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
		if (!cities.contains(startCity)) {cities.add(startCity);}
		if (!cities.contains(destCity)) {cities.add(destCity);}
		Edge e = new Edge(startCity, destCity, weight);
		flights.addEdge(e);
	}
	
	
	/** Returns the origin city
	 * 
	 * @return char representing origin city which is the first 'city' of input.txt
	 */
	public char getOriginCity() {
		return this.originCity;
	}
	public boolean pathExists(char orig, char dest) {
		return false;
	}

	
}
