public class PriorityQueue {
	private QNode root;
	
	public PriorityQueue() {
		root = null;
	}
	
	public void add(int priority, Node n) {
		if(root == null){
			root= new QNode(priority, n);
		}
		else {
			root.addQNode(new QNode(priority, n));
		}

	}

	public Node getLowestPriorityNode() {
		if(root == null){
			return null;
		}
		else {
			return root.getFirstNode();
		}
	}

	public Node getNextHighestPriorityNode() {
		if(root == null){
			return null;
		}
		else {

			return root.getLastNode();


		}
	}
	
	public boolean hasNext() {
		return (root!=null);
	}
	
	public String toString() {
		if(root == null) {
			return "(empty)";
		}
		return root.toString();
	}
}