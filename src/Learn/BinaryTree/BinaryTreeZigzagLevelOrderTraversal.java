package Learn.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	/*
	 * 103. Binary Tree Zigzag Level Order Traversal (Medium)
	 * 
	 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
	 * 
	 * solution: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/solution/
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
	 * Memory Usage: 38.9 MB, less than 77.28% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(H)
	 * 
	 * 
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		if (root == null) {
			return new ArrayList<List<Integer>>();
		}
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		dfs(root, 0, results);
		return results;

	}

	private void dfs(TreeNode root, int level, List<List<Integer>> results) {

		if (level == results.size()) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(root.val);
			results.add(list);
		} else {
			if (level % 2 == 0)
				results.get(level).add(root.val);
			else
				results.get(level).add(0, root.val);
		}

		if (root.left != null)
			dfs(root.left, level + 1, results);
		if (root.right != null)
			dfs(root.right, level + 1, results);

	}
}
