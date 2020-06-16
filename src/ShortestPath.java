import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ShortestPath {

	private HashMap<String,Node> nodes;
	
	public ShortestPath() {
		nodes = new HashMap<>();
	}
	
	public String nodesInShortestPath(String start, String end) {
		// question 5
		
		Node s = nodes.get(start);
		Node e = nodes.get(end);
		
		return ("[]");
	}
	
	public int shortestPath(String start, String end) {
		// question 4
		
		Node s = nodes.get(start);
		Node e = nodes.get(end);
		
		PriorityQueue queue = new PriorityQueue();
		queue.add(0, s);

		s.setShortestDistance(0);

		while (!queue.toString().equals("(empty)")){
			Node currentNode = queue.getNextHighestPriorityNode();
			if (currentNode == e){
				return e.getShortestDistance();
			}
			else {
				for(Edge e : currentNode);

			}
		}

		s.setAsStartNode();
		queue.add(0, s);
		
		return 0;
	}
	
	public void readInNodes(String file) {
		try {
			File f = new File(file);
			BufferedReader br = new BufferedReader(new FileReader(f));
			String s = "";
			while((s=br.readLine()) !=null) {
				String[] info = s.split(" ");
				if(!nodes.containsKey(info[0])) {
					nodes.put(info[0], new Node(info[0]));
				}
				if(!nodes.containsKey(info[1])) {
					nodes.put(info[1], new Node(info[1]));
				}
				Node n1 = nodes.get(info[0]);
				Node n2 = nodes.get(info[1]);
				int i = Integer.valueOf(info[2]);
				Edge e = new Edge(i,n1,n2);
				nodes.get(info[0]).addEdge(e);
				Edge e2 = new Edge(i,n2,n1);
				nodes.get(info[1]).addEdge(e2);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printGraph() {
		System.out.println("Graph");
		for(String k : nodes.keySet()) {
			System.out.println(nodes.get(k));
		}
	}
}
