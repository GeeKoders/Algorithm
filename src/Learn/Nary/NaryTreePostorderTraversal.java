package Nary;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NaryTreePostorderTraversal {
	
	class Node{
		
		public int val ;
		public List<Node> children ;
		
		public Node(int val){
			this.val = val ;
		}
		
	}
	
	
	/*
	 * https://leetcode.com/explore/learn/card/n-ary-tree/130/traversal/926/
	 * 
	 * solution: https://leetcode.com/problems/n-ary-tree-postorder-traversal/solution/
	 * 
	 * youtube: https://youtu.be/P0b9x7AH1AU
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
		Runtime: 2 ms (Your runtime beats 47.72 % of java submissions.)
		Memory Usage: 39.7 MB
	 * 
	 */
	public List<Integer> postorder(Node root){
		
		LinkedList<Integer> list = new LinkedList<>() ;
		Deque<Node> queue = new LinkedList<>() ;
		
		if(root == null) return list ;
		
		queue.add(root) ;
		
		while(!queue.isEmpty()){
			
			Node node = queue.removeLast() ;
			list.addFirst(node.val);
			
			for(Node child: node.children){
				queue.add(child) ;
			}
		}
		
		return list ;
		
		
	}
	
	//approach 2
	
	
	/*
	 * 37 / 37 test cases passed.
	   Status: Accepted
	   Runtime: 2 ms (Your runtime beats 47.72 % of java submissions.)
	   Memory Usage: 39.7 MB
	 * 
	 * 
	 */
	public List<Integer> postorder2(Node root){
		
		LinkedList<Integer> list = new LinkedList<>() ;
		Stack<Node> stack = new Stack<>() ;
		
		if(root == null) return list ;
		
		stack.push(root) ;
		
		while(!stack.isEmpty()){
			
			Node node = stack.pop();
			list.addFirst(node.val);
			
			for(Node child: node.children){
				stack.add(child) ;
			}
		}
		
		return list ;
		
	}
	
	//approach 3
	
	/*
	 * 37 / 37 test cases passed.
	   Status: Accepted
       Runtime: 0 ms (Your runtime beats 100.00 % of java submissions.)
       Memory Usage: 40.1 MB
	 * 
	 * 
	 * 
	 */
	
	public List<Integer> postorder3(Node root){
		
		LinkedList<Integer> list = new LinkedList<>() ;
		
		return helper(root, list) ;
		
	}
	
	private List<Integer> helper(Node root, List<Integer> list){
		
		if(root == null) return list ;
		
		for(Node child: root.children){
			helper(child, list) ;
		}
		
		list.add(root.val) ;
		return list ;
	}
	
}
