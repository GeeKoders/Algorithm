package Nary;

import java.util.LinkedList;
import java.util.List;

public class EncodeNaryTreetoBinaryTree {

	class Node{
		
		public int val ;
		
		public List<Node> children ;
		
		public Node(int val, List<Node> children){
			this.val = val ;
			this.children = children ;
		}
		
	}
	
	class TreeNode{
		
		public int val ;
		public TreeNode left ;
		public TreeNode right ;
		
		public TreeNode(int val){
			this.val = val ;
		}
		
	}
	
	/*
	 * https://leetcode.com/explore/learn/card/n-ary-tree/131/recursion/920/
	 * 
	 * solution: https://leetcode.com/problems/encode-n-ary-tree-to-binary-tree/solution/
	 * 
	 * discuss: https://leetcode.com/explore/learn/card/n-ary-tree/131/recursion/920/discuss/153061/Java-Solution-(Next-Level-greater-left-Same-Level-greater-right)
	 * 
	 * 37 / 37 test cases passed.
		Status: Accepted
		Runtime: 1 ms (Your runtime beats 100.00 % of java submissions.)
		Memory Usage: 40.8 MB
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		
	}
	// Encodes an n-ary tree to a binary tree.
	public TreeNode encode(Node root) {
		
		if(root == null) return null ;
		
		TreeNode result = new TreeNode(root.val) ;
		
		if(root.children.size() > 0){
			result.left = encode(root.children.get(0)) ;
		}
		
		TreeNode cur = result.left ;
		
		for(int i=1; i<root.children.size(); i++){
			cur.right = encode(root.children.get(i)) ;
			cur = cur.right;
		}
		
		return result ;
		
	}
	// Decodes your binary tree to an n-ary tree.
	 public Node decode(TreeNode root) {
		 
		 if(root == null) return null;
		 
		 Node result = new Node(root.val, new LinkedList<>()) ;
		 
		 TreeNode cur = root.left ;
		 while(cur != null){
			 
			 result.children.add(decode(cur)) ;
			 cur = cur.right ;
		 }
		 
		 return result ;
		 
		 
	 }
	
}
