package src;


class Edge {
	private char orig;
	private char dest;
	private int weight;
	
	Edge(char o, char d, int w) {
		orig = o;
		dest = d;
		weight = w;
	}
	public char getOrig() {
		return orig;
	}
	public char getDest() {
		return dest;
	}
	public int getWeight() {
		return weight;
	}
	
}
