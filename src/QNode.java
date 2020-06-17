import java.util.ArrayList;

public class QNode{
	private int priority;
	private QNode next;
	private QNode previous;
	private Node node;
	
	public QNode(int priority, Node n) {
		this.priority = priority;
		this.node = n;
		next = null;
		previous = null;
	}

	public void setNode(Node x){
		this.node = x;
	}

	public void setPriority(int x){
		this.priority = x;
	}


	public Node getNode() {
		return node;
	}


	public Node getFirstNode(){
		QNode o = this;

		while(o.previous!= null) {
			o = o.previous;
		}
		while(o.node.hasBeenVisited()){
			o = o.next;
		}
		return o.node;
	}

	public Node getLastNode(){
		QNode o = this;
		while(o.next != null){
			o = o.next;
		}
		while(o.node.hasBeenVisited()){
			o = o.previous;
		}
		return o.node;


	}
	
	public void addQNode(QNode n) {


		int v = n.priority;
		int root = getPriority();

		if (root <= v && getNext() == null) {
					setNext(n);
					n.previous = this;
					n.next = null;
		}

		else if (root <= v){

			QNode o = this;
			QNode prev = this;

			while (v >= o.priority && o.next != null){
				prev = o;
				o = o.next;
			}

			if(o.next == null && v > o.priority) {
				o.next = n;
				n.next = null;
				n.previous = o;
			}

			else {
				o.previous = n;
				n.next = o;
				prev.next =n;

			}
		}
//
		else if(root > v && getPrevious() == null ) {
			setPrevious(n);
			n.next = this;
			n.previous = null;
		}

		else if (root > v){

			QNode o = this;
			QNode next = this;

			while (v <= o.priority && o.previous != null){
				next = o;
				o = o.previous;
			}

			if(o.previous == null && v < o.priority) {
				o.previous = n;
				n.previous = null;
				n.next = o;
			}

			else {
				o.next = n;
				n.previous = o;
				next.previous =n;

			}
		}


	}

	
	public int getPriority() {
		return priority;
	}
	
	public void setPrevious(QNode p) {
		previous = p;
	}
	
	public QNode getPrevious() {
		return previous;
	}
	
	public void setNext(QNode n) {
		next = n;
	}
	
	public QNode getNext() {
		return next;
	}
	
	public String toString() {
		String s = node.getLabel() + " (" + priority + ") : ";
		if (next!=null) {
			s += next.toString();
		}
		return s;
	}

	public String toStringPrev() {
		String s = node.getLabel() + " (" + priority + ") : ";
		if (previous!=null) {
			s += previous.toStringPrev();
		}
		return s;
	}
	
}

