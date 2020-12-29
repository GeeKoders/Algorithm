package Nary;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TraversalofNary {

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
	};
	
	/*
	 * https://leetcode.com/explore/learn/card/n-ary-tree/130/traversal/925/
	 * 
	 * solution: https://leetcode.com/problems/n-ary-tree-preorder-traversal/solution/
	 * 
	 */
	
	public static void main(String[] args) {
		
	}
	/*
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 * DFS
	 * 
	 * 
		37 / 37 test cases passed.
		Status: Accepted
		Runtime: 2 ms (Your runtime beats 45.50 % of java submissions.)
		Memory Usage: 39.4 MB
	 * 
	 * 
	 */
	public List<Integer> preorder(Node root) {

		Stack<Node> stack = new Stack<>();
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		stack.push(root);

		while (!stack.isEmpty()) {

			Node curr = stack.pop();
			res.add(curr.val);

			if (curr.children != null) {

				for (int i = curr.children.size() - 1; i >= 0; i--) {
					stack.push(curr.children.get(i));
				}
			}
		}
		return res;

	}
	/*
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 * 
		37 / 37 test cases passed.
		Status: Accepted
		Runtime: 0 ms (Your runtime beats 100.00 % of java submissions.)
		Memory Usage: 40 MB
		
		
	 * 
	 */
	
	List<Integer> res = new ArrayList<>() ;
	
	public List<Integer> preorder2(Node root) {
		
		if(root == null) return res ;
		res.add(root.val) ;
		
		for(Node node: root.children){
			preorder2(node) ;
		}
		return res ;
		
	}
}
