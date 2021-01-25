package BinaryTree;

public class MaximumDepthofBinaryTree {

	
	/*
	 * https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/535/
	 * 
	 * Given a binary tree, find its maximum depth.
	 * 
	 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
	 * 
	 * Note: A leaf is a node with no children.
	 * 
	 * Example:
	 * Given binary tree [3,9,20,null,null,15,7],
	 * 
	 * 3
   	  / \
     9  20
       /  \
      15   7
	 * 
	 * return its depth = 3.
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxDepth(TreeNode root) {
        
        if(root==null){
           return 0;
       }
       return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
       
   }

}
