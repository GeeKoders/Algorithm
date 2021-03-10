package Tag.Tree;

import java.util.Stack;

public class RecoverBinarySearchTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}
	/*
	 * 99. Recover Binary Search Tree (Hard)
	 * 
	 * https://leetcode.com/problems/recover-binary-search-tree/
	 * 
	 * solution: https://leetcode.com/problems/recover-binary-search-tree/solution/
	 * 
	 * Runtime: 3 ms, faster than 39.42% of Java online submissions for Recover Binary Search Tree.
	 * Memory Usage: 39.1 MB, less than 84.73% of Java online submissions for Recover Binary Search Tree.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 */
	public void recoverTree(TreeNode root) {

		Stack<TreeNode> stack = new Stack<>();

		TreeNode x = null, y = null, pre = null;

		while (root != null || !stack.isEmpty()) {

			while (root != null) {
				stack.add(root);
				root = root.left;
			}

			root = stack.pop();

			if (pre != null && root.val < pre.val) {
				y = root;
				if (x == null)
					x = pre;
				else
					break;
			}

			pre = root;
			root = root.right;

		}

		swap(x, y);

	}

	private void swap(TreeNode x, TreeNode y) {
		int tmp = x.val;
		x.val = y.val;
		y.val = tmp;
	}
}
