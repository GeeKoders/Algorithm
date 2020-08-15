package Stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class CloneGraph {

	/*
	 * https://leetcode.com/explore/learn/card/queue-stack/232/practical-application
	 * -stack/1392/
	 * 
	 * Given a reference of a node in a connected undirected graph. Return a
	 * deep copy (clone) of the graph. Each node in the graph contains a val
	 * (int) and a list (List[Node]) of its neighbors.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Node cloneGraph(Node node) {

		if (node == null)
			return null;

		Stack<Node> stack = new Stack<Node>();
		Map<Node, Node> visited = new HashMap<Node, Node>();
		stack.push(node);
		visited.put(node, new Node(node.val));

		while (!stack.isEmpty()) {

			Node top = stack.pop();

			for (Node neighbor : top.neighbors) {

				if (!visited.containsKey(neighbor)) {
					stack.push(neighbor);
					visited.put(neighbor, new Node(neighbor.val));
				}

				visited.get(top).neighbors.add(visited.get(neighbor));

			}

		}

		return visited.get(node);
	}

	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

}
