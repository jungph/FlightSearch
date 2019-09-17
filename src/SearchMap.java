package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SearchMap {
	
	// Entry point for program - Main
	public static void main(String[] args) {
		SearchMap t = new SearchMap();
		t.readFileContents("input_files/Testinput.txt");
		t.writeSearchResults("output_files/Testoutput.txt");
	}
	// Used to keep track of the origin city 
	public char originCity;
	// Object FlightMap is used to find search paths from origin city to each destination
	public FlightMap flights;
	// A list of chars that will be used to store each unique city found in input file
	public ArrayList<Character> cities;
	/**
	 * Default constructor
	 * initializes local variables flights and cities
	 * @param : none
	 * @return: none
	 * @post : flights == null;
	 * @post : cities == null;
	 */
	public SearchMap() {	
		this.flights = new FlightMap();
		this.cities = new ArrayList<Character>();
	}
	/**
	 * Parameterized constructor
	 * initializes local variables flights and cities and calls readFileContents using
	 * the file name given in argument.
	 * @param : fileName is the name (sometimes this includes relative file path location)
	 * 			of the text file containing flight information
	 * @return: none
	 * @post : flights == null;
	 * @post : cities == null;
	 */
	public SearchMap(String fileName) {
		this.flights = new FlightMap();
		this.cities = new ArrayList<Character>();
		this.readFileContents(fileName);
	}
	/**
	 * By reading the contents of the file, this function will store the origin city (first char of the input text file)
	 * 	and call setEdges function each time an edge is found in the input text file
	 * @param: fileName will have the fileName of the text file that has the cities information
	 * 			also expects relative file path if not already given
	 * @return nothing
	 * @throws FileNotFoundException if file cannot be found
	 * @throws IOException if there is an IO error (standard exception with file IO)
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
	/**
	 * writeSearchResults uses the object's FlightMap object to find paths from origin city to every other city
	 *  It then writes these results, and formats it, and stores it in an output text file
	 * @param: fileName is the file name for output text file (this includes relative path if user
	 * 			wants to store somewhere else.
	 * @post: Output text file will have a listing of Destination, Path from Origin City, and Cost for each path
	 * @return nothing
	 * @throws IOException if there is an IO error (standard exception with file IO)
	 */
	public void writeSearchResults(String fileName) {
		PrintWriter writer = null;
		try {
			String arg1 = "Destination";
			String arg2 = "Flight Route from " + originCity;
			String arg3 = "Total Cost";
			int lengthOfLongestPath = cities.size() * 3 + 10;
			
			writer = new PrintWriter(fileName, "UTF-8");
			writer.println(String.format("%-20s %-"+lengthOfLongestPath +"s %s", arg1, arg2, arg3));
			for (int i = 0; i < cities.size(); i++) {
				if (flights.pathExists(originCity, cities.get(i))) {
					arg1 = Character.toString(cities.get(i));
					arg2 = "";
					for (int j = 0; j < flights.actualPath.size() - 1; j++) {
						arg2 += Character.toString(flights.actualPath.get(j)) + ", ";
					}
					arg2 += Character.toString(flights.actualPath.get(flights.actualPath.size() - 1));
					arg3 = "$" + Integer.toString(flights.actualCost);
					writer.println(String.format("%-20s %-" +lengthOfLongestPath + "s %s", arg1, arg2, arg3));
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			writer.close();
		}
	}
	
	/**
	 * setEdges will make Edge objects and store each edge to the local flights object
	 * @param: a String line where each line consists of a new line read from input text file
	 * @post: an Edge object is created and added to flights object's list by calling its method addEdge
	 * @return nothing
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
	
	
	/**
	 * Returns the origin city
	 * @param: nothing
	 * @post: nothing
	 * @return: the local variable originCity
	 * @throws IOException if there is an IO error (standard exception with file IO)
	 */
	public char getOriginCity() {
		return this.originCity;
	}

	
}
