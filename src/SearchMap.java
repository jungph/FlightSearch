package src;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 * This class reads a list of flights (called Edges) from an input text file and writes
 * a list of paths and costs to an output file
 * @author Philip Jung
 * @version 1.0
 */

public class SearchMap {
	
	// Entry point for program - Main
	/**
	 * The client class for running SearchMap.
	 * @param args Requires two String class arguments. args[0] will be the name (include file path) 
	 * of the input file that has a list of cities and costs of flights between adjacent cities.
	 * args[1] will be the name (include file path) of the output file to store paths
	 */
	public static void main(String[] args) {
		SearchMap t = new SearchMap(args[0]);
		
		// If SearchMap is constructed with a String argument
		// then it does not need to call readFileContents(String)
		// t.readFileContents(args[0]);
		
		t.writeSearchResults(args[1]);
	}
	// Used to keep track of the origin city 
	private char originCity;
	// Object FlightMap is used to find search paths from origin city to each destination
	private FlightMap flights;
	// A list of chars that will be used to store each unique city found in input file
	private ArrayList<Character> cities;
	/**
	 * Default constructor
	 * initializes local variables flights and cities
	 */
	
	/**
	 * Used by JUnit tests to get a list of cities in current SearchMap class
	 * @return cities, ArrayList of Characters representing the cities in SearchMap
	 */
	public ArrayList<Character> getCities() {
		return cities;
	}
	/**
	 * Used by JUnit tests to get existing Flight class in current SearchMap class
	 * @return flights Flight class that is initialized in current SearchMap
	 */
	public FlightMap getFlights() {
		return flights;
	}
	/**
	 * Default constructor for SearchMap(). Allocates a memory address to reference for local variables FlightMap and ArrayList of Character wrapper class
	 */
	public SearchMap() {	
		this.flights = new FlightMap();
		this.cities = new ArrayList<Character>();
	}
	/**
	 * Parameterized constructor
	 * initializes local variables flights and cities and calls readFileContents using
	 * the file name given in argument.
	 * @param  fileName is the name (sometimes this includes relative file path location)
	 * 			of the text file containing flight information
	 */
	public SearchMap(String fileName) {
		this.flights = new FlightMap();
		this.cities = new ArrayList<Character>();
		this.readFileContents(fileName);
	}
	/**
	 * By reading the contents of the file, this function will store the origin city (first char of the input text file)
	 * 	and call setEdges function each time an edge is found in the input text file
	 * @param fileName will have the fileName of the text file that has the cities information
	 * 			also expects relative file path if not already given
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
	 * @param fileName is the file name for output text file (this includes relative path if user
	 * 			wants to store somewhere else.
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
					for (int j = 0; j < flights.getActualPath().size() - 1; j++) {
						arg2 += Character.toString(flights.getActualPath().get(j)) + ", ";
					}
					arg2 += Character.toString(flights.getActualPath().get(flights.getActualPath().size() - 1));
					arg3 = "$" + Integer.toString(flights.getActualCost());
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
	 * @param line where each line consists of a new line read from input text file
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
	 * @return the local variable originCity
	 */
	public char getOriginCity() {
		return this.originCity;
	}

	
}
