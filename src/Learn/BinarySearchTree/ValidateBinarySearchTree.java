package BinarySearchTree;

import java.util.Stack;

public class ValidateBinarySearchTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/*
	 * https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/140/introduction-to-a-bst/997
	 * 
	 * solution:
	 * https://leetcode.com/problems/validate-binary-search-tree/solution/
	 * 
	 * 
	 */
	public boolean validate(TreeNode root, Integer low, Integer high) {
		// Empty trees are valid BSTs.
		if (root == null) {
			return true;
		}
		// The current node's value must be between low and high.
		if ((low != null && root.val <= low)
				|| (high != null && root.val >= high)) {
			return false;
		}
		// The left and right subtree must also be valid.
		return validate(root.right, root.val, high)
				&& validate(root.left, low, root.val);
	}

	public boolean isValidBST(TreeNode root) {
		return validate(root, null, null);
	}
	
	
	// Approach 2: Inorder Traversal
	// Time: O(N)
	// Space: O(N)
	private Integer prev ;
	
	public boolean isValidBST2(TreeNode root) {
		return inorder(root) ;
	}
	
	public boolean inorder(TreeNode root){
		if(root == null) return true ;
		if(!inorder(root.left)) return false ;
		if(prev != null && root.val <= prev) return false ;
		prev = root.val ;
		return inorder(root.right) ;
	}
	
	// Approach 3: use Stack
	// Time: O(N)
	// Space: O(N)
	public boolean isValidBST3(TreeNode root) {

		Stack<TreeNode> stack = new Stack<>() ;
		
		while(!stack.isEmpty() || root !=null){
			
			while(root != null){
				stack.push(root) ;
				root = root.left ;
			}
			
			root = stack.pop();
			// If next element in inorder traversal
            // is smaller than the previous one
            // that's not BST.
			
			if(prev != null && root.val <= prev){
				return false ;
			}
			prev = root.val ;
			root = root.right ;
		}
		return true ;
	}
	
	
}