package src;
import java.util.ArrayList;
/**
 * This class implements a simple recursive map search that will return paths from an origin city to a destination.
 * FlightMap is called and used as local variable by SearchMap class.
 * @author Philip Jung
 * @version 1.0
 */
public class FlightMap {
	private int actualCost;
	private ArrayList<Character> actualPath;
	private ArrayList<Edge> edges;
	
	/** Returns the list of edges in FlightMap. Used for JUnit test file to examine edges
	 * @return edges is the list of all unidirectional edges extrapolated from text file
	 */
	public ArrayList<Edge> getEdges() {
		return edges;
	}
	/**
	 * Returns a list of characters that represents a single path from one city to another through adjacent cities
	 * @return getEdges, an ArrayList of characters
	 */
	public ArrayList<Character> getActualPath() {
		return actualPath;
	}
	/**
	 * Default constructor
	 * initializes local variables actualPath and edges
	 */
	public FlightMap() {
		actualCost = 0;
		actualPath = new ArrayList<Character>();
		edges = new ArrayList<Edge>();
	}
	/**
	 * getActualCost
	 * actualCost is a local variable that is set by the path-finder solution pathExistsHelper
	 * this function simply returns this value
	 * @return actual cost of path from origin to destination
	 */
	public int getActualCost() {
		return actualCost;
	}
	/**
	 * addEdge adds an Edge class to FlightMap's ArrayList of Edge class called edges
	 * @param e Edge
	 * 	 
	 */
	public void addEdge(Edge e) {
		edges.add(e);
	}
	/**
	 * pathExistsHelper is an exhaustive-recursive path finding solution
	 * 	Called by the Class's pathExists function, this function will try every single iteration
	 *  If a path is found, the local variables are set and a True is returned
	 * @param  orig is the origin city, on the first iteration this is SearchMap's origin city
	 * 			but as the function is recursive, each subsequent orig may be different
	 * @param  dest is always the destination city. if the function finds a path, through
	 * 			the list of existing edges to this destination city, the function returns true
	 * @param  totalWeight is the summation of costs being calculated. It will add costs when adding edges
	 * 			and deduct those edges if it finds that the path visited a wrong city
	 * @param  path is a list of characters that stores the current path from orig to dest
	 * @param remEdges begins as a shallow copy of all edges. As edges are visited, it is removed from this list
	 * 			this prevents the path finder from using the same edge multiple times
	 * @return boolean true if a path was found, and false if a path was not found
 * @see pathExists
	 */
	private boolean pathExistsHelper(char orig, char dest, int totalWeight, ArrayList<Character> path, ArrayList<Edge> remEdges) {
		for (int i =0; i < remEdges.size(); i++) {
			if (remEdges.get(i).getOrig() == orig) {
				if (remEdges.get(i).getDest() == dest) {
					path.add(dest);
					totalWeight += remEdges.get(i).getWeight();
					
					// set class variables before returning true
					actualCost = totalWeight;
					actualPath = path;
					return true;
				} else if (!path.contains(remEdges.get(i).getDest()))
				{
					Edge currentEdge = remEdges.get(i);
					int currentWeight = currentEdge.getWeight();
					totalWeight += currentWeight;
					char nextOrig = currentEdge.getDest();
					path.add(nextOrig);
					remEdges.remove(i);
					if (pathExistsHelper(nextOrig, dest, totalWeight, path,remEdges)) {
						return true;
					} else {
						path.remove(actualPath.size() - 1);
						totalWeight -= currentEdge.getWeight();
						remEdges.add(i, currentEdge);
					}
				}
			}
		}
		return false;
	}
	/**
	 * pathExists will be called to determine if there is path from orig to dest
	 * 	it resets each local variable and calls pathExistsHelper to perform the search
	 * @param  orig is the origin city, on the first iteration this is SearchMap's origin city
	 * 			but as the function is recursive, each subsequent orig may be different
	 * @param  dest is always the destination city. if the function finds a path, through
	 * 			the list of existing edges to this destination city, the function returns true
	 * @return boolean true if a path was found, and false if a path was not found. these are just
	 * 			returning what pathExistsHelper is returning
	 * @see pathExistsHelper
	 */
	public boolean pathExists(char orig, char dest) {
		actualCost = 0;
		actualPath = new ArrayList<Character>();
		actualPath.add(orig);
		ArrayList<Edge> remainingEdges = new ArrayList<Edge>(edges);
		return pathExistsHelper(orig, dest, actualCost, actualPath, remainingEdges);
	}
}
