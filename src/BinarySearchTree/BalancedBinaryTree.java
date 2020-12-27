package BinarySearchTree;

public class BalancedBinaryTree {

	class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}

	}

	/*
	 * https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/143/appendix-height-balanced-bst/1027/
	 * 
	 * solution: https://leetcode.com/problems/balanced-binary-tree/solution/
	 * 
		228 / 228 test cases passed.
		Status: Accepted
		Runtime: 1 ms
		Memory Usage: 39.3 MB
	 * 
	 */
	public boolean isBalanced(TreeNode root) {

		if (root == null)
			return true;

		return Math.abs(height(root.left) - height(root.right)) < 2
				&& isBalanced(root.left) && isBalanced(root.right);
	}

	public int height(TreeNode root) {

		if (root == null)
			return -1;

		return Math.max(height(root.left), height(root.right)) + 1;
	}

}
