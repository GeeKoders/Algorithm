package BinarySearchTree;

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
	 * solution: https://leetcode.com/problems/validate-binary-search-tree/solution/
	 * 
	 */
	 public boolean validate(TreeNode root, Integer low, Integer high) {
	        // Empty trees are valid BSTs.
	        if (root == null) {
	            return true;
	        }
	        // The current node's value must be between low and high.
	        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
	            return false;
	        }
	        // The left and right subtree must also be valid.
	        return validate(root.right, root.val, high) && validate(root.left, low, root.val);
	    }

	    public boolean isValidBST(TreeNode root) {
	        return validate(root, null, null);
	    }
	
	
}

