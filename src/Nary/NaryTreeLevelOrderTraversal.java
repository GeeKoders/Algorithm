package Nary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {

	class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}

	
	/*
	 * https://leetcode.com/explore/learn/card/n-ary-tree/130/traversal/915/
	 * 
	 * solution: https://leetcode.com/problems/n-ary-tree-level-order-traversal/solution/
	 * 
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		
	}
	
	
	/*
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 * 
		37 / 37 test cases passed.
		Status: Accepted
		Runtime: 2 ms (Your runtime beats 85.62 % of java submissions.)
		Memory Usage: 39.8 MB
	 * 
	 */
	public List<List<Integer>> levelOrder(Node root) {

		List<List<Integer>> res = new LinkedList<>();

		if (root == null)
			return res;

		Queue<Node> queue = new LinkedList<>();

		queue.offer(root);

		while (!queue.isEmpty()) {
			List<Integer> level = new LinkedList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node curr = queue.poll();
				level.add(curr.val);
				for (Node child : curr.children)
					queue.offer(child);
			}
			res.add(level);
		}

		return res;
	}
	
	//approach 2 recursive
	
	/*
	 * Time complexity: O(N)
	 * Space complexity:  O(logN) average case and O(n) worst case. The space used is on the runtime stack.
	 * 
	 * 
	 * 37 / 37 test cases passed.
		Status: Accepted
		Runtime: 0 ms (Your runtime beats 100.00 % of java submissions.)
		Memory Usage: 40 MB
	 * 
	 */
	
	private List<List<Integer>> result = new ArrayList<>() ;
	
	public List<List<Integer>> levelOrder2(Node root) {
		if(root != null) traverseNode(root, 0) ;
		return result ;
	}


	private void traverseNode(Node node, int level) {

		if(result.size() <= level){
			result.add(new ArrayList<>()) ;
		}
		
		result.get(level).add(node.val) ;
		
		for(Node child: node.children){
			traverseNode(child, level + 1) ;
		}
	}

}
