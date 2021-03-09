package Tag.Tree;

import java.util.ArrayList;
import java.util.List;

public class CountCompleteTreeNodes {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}

	}

	/*
	 * 222. Count Complete Tree Nodes (Medium)
	 * 
	 * https://leetcode.com/problems/count-complete-tree-nodes/
	 * 
	 * solution: https://leetcode.com/problems/count-complete-tree-nodes/solution/
	 * 
	 * Runtime: 1 ms, faster than 14.84% of Java online submissions for Count Complete Tree Nodes.
	 * Memory Usage: 41.6 MB, less than 54.63% of Java online submissions for Count Complete Tree Nodes.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(H)
	 * 
	 */
	public int countNodes(TreeNode root) {

		if (root == null)
			return 0;

		List<Integer> list = new ArrayList<>();

		helper(root, list);
		return list.size();

	}

	private void helper(TreeNode root, List<Integer> list) {

		if (root.left != null)
			helper(root.left, list);
		list.add(root.val);
		if (root.right != null)
			helper(root.right, list);

	}
	
	public int countNodes2(TreeNode root) {
	    return root != null ? 1 + countNodes2(root.right) + countNodes2(root.left) : 0;
	}

}
