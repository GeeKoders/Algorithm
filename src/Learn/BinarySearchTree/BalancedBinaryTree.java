package Learn.BinarySearchTree;

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
	 * 110. Balanced Binary Tree
	 * 
	 * https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/143/appendix-height-balanced-bst/1027/
	 * 
	 * solution: https://leetcode.com/problems/balanced-binary-tree/solution/
	 * 
	 * Runtime: 1 ms, faster than 45.90% of Java online submissions for Balanced Binary Tree.
	 * Memory Usage: 38.8 MB, less than 88.13% of Java online submissions for Balanced Binary Tree.
	 * 
	 * Time complexity: O(NlogN) Please reference the solution.
	 * Space complexity: O(N)
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
