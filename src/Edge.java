package src;
/**
 * This class is the simple structure of an Edge from one city to another.
 * It contains variables to store this data and public methods to retrieve them.
 * @author Philip Jung
 * @version 1.0
 */
public class Edge {
	private char orig;
	private char dest;
	private int weight;
	/**
	 * Constructor for an Edge object
	 * @param o origin city represented by a character
	 * @param d destination city represented by a character
	 * @param w cost of travel from origin to destination represented by an integer
	 */
	Edge(char o, char d, int w) {
		orig = o;
		dest = d;
		weight = w;
	}
	/**
	 * Returns the origin city as a character
	 * @return orig, the origin city 
	 */
	public char getOrig() {
		return orig;
	}
	/**
	 * Returns the destination city as a character
	 * @return dest, the destination city
	 */
	public char getDest() {
		return dest;
	}
	/**
	 * Returns the cost from origin to destination as an integer
	 * @return weight, the cost from this Edge class's origin to destination as an integer
	 */
	public int getWeight() {
		return weight;
	}
	
}
