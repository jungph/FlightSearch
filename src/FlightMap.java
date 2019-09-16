package src;

import java.util.ArrayList;

public class FlightMap {
	public int actualCost;
	public ArrayList<Character> actualPath;
	public ArrayList<Edge> edges;
	public FlightMap() {
		actualPath = new ArrayList<Character>();
		edges = new ArrayList<Edge>();
	}
	public int getActualCost() {
		return actualCost;
	}
	public void addEdge(Edge e) {
		edges.add(e);
	}
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
	public boolean pathExists(char orig, char dest) {
		actualCost = 0;
		actualPath = new ArrayList<Character>();
		actualPath.add(orig);
		ArrayList<Edge> remainingEdges = new ArrayList<Edge>(edges);
		return pathExistsHelper(orig, dest, actualCost, actualPath, remainingEdges);
	}
}
