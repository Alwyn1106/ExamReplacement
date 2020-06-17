public class EdgeList {
	
	private Edge[] edges;
	private int currentLocation;

	
	public EdgeList(int initialLength) {
		edges = new Edge[initialLength];
		currentLocation = 0;
	}

	
	public int length() {
		return currentLocation;
	}
	
	public Edge get(int index) {
		if(index >= edges.length) {
			return null;
		}
		return edges[index];
	}
	public Edge[] getArrofEdges(){
		Edge[] toReturn = new Edge[currentLocation];

		for(int i=0; i<edges.length;i++) {
			if (edges[i] != null) {
				toReturn[i] = edges[i];
			}
		}

		return toReturn;
	}

	public void setCurrentLocation(int x){
		currentLocation = x;
	}
	public void add(Edge e) {

		//static int count = 1;
		int length = edges.length;
		int ind = 0;
		boolean incneeded = true;

		for (ind = 0 ; ind < length ; ind++){
			if(edges[ind] == null) {
				edges[ind] = e;
				Edge toUpdate = edges[ind];
				currentLocation++;
				incneeded = false;
				break;
			}
		}
		if(incneeded){
			increaseSizeOfArray();
			edges[ind] = e;
			currentLocation++;

		}

	}

	private void increaseSizeOfArray() {
		int newSize = edges.length*2;
		Edge[] temp = copyArray(edges);
		edges = new Edge[newSize];
		for(int i=0; i<temp.length; i++) {
			edges[i] = temp[i];
		}
	}

	private Edge[] copyArray(Edge[] es) {
		Edge[] e = new Edge[es.length];
		for(int i=0; i<es.length; i++) {
			e[i] = es[i];
		}
		return e;
	}
	
	public String toString() {
		String s = "(";
		for(int i=0; i<edges.length;i++) {
			if(edges[i] != null) {
				s += "["+edges[i].getEndNode().getLabel();
				s += ","+ edges[i].getDistance()+"] ";
			}
		}
		return (s+")");
	}
	
}
