package Tag.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ClosestBinarySearchTreeValue {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}

	}

	/*
	 * 270. Closest Binary Search Tree Value (Easy)
	 * 
	 * https://leetcode.com/problems/closest-binary-search-tree-value/
	 * 
	 * https://leetcode.com/problems/closest-binary-search-tree-value/solution/
	 * 
	 * Memory Limit Exceeded
	 * 
	 */
	public int closestValue(TreeNode root, double target) {

		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(root);

		int res = root.val;
		double diff = Double.MAX_VALUE;

		while (!queue.isEmpty()) {

			int n = queue.size();

			TreeNode cur = queue.poll();

			if (Math.abs(cur.val - target) < diff) {
				diff = Math.abs(cur.val - target);
				res = cur.val;
			}

			for (int i = 0; i < n; i++) {

				if (cur.left != null) {
					queue.add(cur.left);
				}

				if (cur.right != null) {
					queue.add(cur.right);
				}

			}

		}
		return res;

	}
}
