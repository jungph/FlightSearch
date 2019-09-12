package src;

import java.util.ArrayList;

public class FlightMap {
	public ArrayList<Edge> edges;
	public FlightMap() {
		edges = new ArrayList<Edge>();
	}
	public void addEdge(Edge e) {
		edges.add(e);
	}
	public boolean pathExistsHelper(char orig, char dest, int totalWeight, ArrayList<Edge> remEdges) {
		for (int i =0; i < remEdges.size(); i++) {
			if (remEdges.get(i).orig == orig) {
				if (remEdges.get(i).dest == dest) {
					totalWeight += remEdges.get(i).weight;
					return true;
				} else {
					Edge currentEdge = remEdges.get(i);
					int currentWeight = currentEdge.weight;
					totalWeight += currentWeight;
					char nextOrig = currentEdge.dest;
					
					remEdges.remove(i);
					if (pathExistsHelper(nextOrig, dest, currentWeight,remEdges)) {
						return true;
					} else {
						totalWeight -= currentWeight;
						remEdges.add(i, currentEdge);
					}
				}
			}
		}
		return false;
	}
	public boolean pathExists(char orig, char dest, int totalWeight) {
		ArrayList<Edge> remainingEdges = edges;
		return pathExistsHelper(orig, dest, totalWeight, remainingEdges);
	}
}
