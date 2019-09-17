package src;

import java.util.ArrayList;

class FlightMap {
	public int actualCost;
	public ArrayList<Character> actualPath;
	public ArrayList<Edge> edges;
	/**
	 * Default constructor
	 * initializes local variables actualPath and edges
	 * @param : none
	 * @return: none
	 * @post : actualPath == null
	 * @post : edges == null
	 */
	public FlightMap() {
		actualPath = new ArrayList<Character>();
		edges = new ArrayList<Edge>();
	}
	/**
	 * getActualCost
	 * actualCost is a local variable that is set by the path-finder solution pathExistsHelper
	 * this function simply returns this value
	 * @param : none
	 * @return: actual cost of path from origin to destination
	 */
	public int getActualCost() {
		return actualCost;
	}
	/**
	 * addEdge allows this class to add an Edge object to its list of edges
	 * @param : none
	 * @return: none
	 * @post : none
	 * @post : none
	 */
	public void addEdge(Edge e) {
		edges.add(e);
	}
	/**
	 * pathExistsHelper is an exhaustive-recursive path finding solution
	 * 	Called by the Class's pathExists function, this function will try every single iteration
	 *  If a path is found, the local variables are set and a True is returned
	 * @param : char orig is the origin city, on the first iteration this is SearchMap's origin city
	 * 			but as the function is recursive, each subsequent orig may be different
	 * @param : char dest is always the destination city. if the function finds a path, through
	 * 			the list of existing edges to this destination city, the function returns true
	 * @param : totalWeight is the summation of costs being calculated. It will add costs when adding edges
	 * 			and deduct those edges if it finds that the path visited a wrong city
	 * @param : path is a list of characters that stores the current path from orig to dest
	 * @param: remEdges begins as a shallow copy of all edges. As edges are visited, it is removed from this list
	 * 			this prevents the path finder from using the same edge multiple times
	 * @return: boolean true if a path was found, and false if a path was not found
	 * @post : actualCost is set with the summation of all the costs from origin to destination
	 * @post : actualPath is set with a list of cities that it required to go from origin to destination
	 */
	public boolean pathExistsHelper(char orig, char dest, int totalWeight, ArrayList<Character> path, ArrayList<Edge> remEdges) {
		for (int i =0; i < remEdges.size(); i++) {
			if (remEdges.get(i).orig == orig) {
				if (remEdges.get(i).dest == dest) {
					path.add(dest);
					totalWeight += remEdges.get(i).weight;
					
					// set class variables before returning true
					actualCost = totalWeight;
					actualPath = path;
					return true;
				} else if (!path.contains(remEdges.get(i).dest))
				{
					Edge currentEdge = remEdges.get(i);
					int currentWeight = currentEdge.weight;
					totalWeight += currentWeight;
					char nextOrig = currentEdge.dest;
					path.add(nextOrig);
					remEdges.remove(i);
					if (pathExistsHelper(nextOrig, dest, totalWeight, path,remEdges)) {
						return true;
					} else {
						path.remove(actualPath.size() - 1);
						totalWeight -= currentEdge.weight;
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
	 * @param : char orig is the origin city, on the first iteration this is SearchMap's origin city
	 * 			but as the function is recursive, each subsequent orig may be different
	 * @param : char dest is always the destination city. if the function finds a path, through
	 * 			the list of existing edges to this destination city, the function returns true
	 * @return: boolean true if a path was found, and false if a path was not found. these are just
	 * 			returning what pathExistsHelper is returning
	 * @post : actualCost is set with the summation of all the costs from origin to destination
	 * @post : actualPath is set with a list of cities that it required to go from origin to destination
	 */
	public boolean pathExists(char orig, char dest) {
		actualCost = 0;
		actualPath = new ArrayList<Character>();
		actualPath.add(orig);
		ArrayList<Edge> remainingEdges = new ArrayList<Edge>(edges);
		return pathExistsHelper(orig, dest, actualCost, actualPath, remainingEdges);
	}
}
