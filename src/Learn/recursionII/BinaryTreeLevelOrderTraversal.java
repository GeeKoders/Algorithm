package recursionII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

	class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}

	}

	private List<List<Integer>> result = new ArrayList();
	private List<Integer> list;
	private Queue<TreeNode> queue = new LinkedList();

	
	/*
	 * 102. Binary Tree Level Order Traversal (Medium)
	 * 
	 * https://leetcode.com/explore/learn/card/recursion-ii/503/recursion-to-iteration/2784/
	 * 
	 * solution: https://leetcode.com/problems/binary-tree-level-order-traversal/solution/
	 * 
		34 / 34 test cases passed.
		Status: Accepted
		Runtime: 2 ms (Your runtime beats 11.71 % of java submissions.)
		Memory Usage: 40.4 MB
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {

		if (root == null)
			return result;

		queue.add(root);

		while (!queue.isEmpty()) {

			list = new ArrayList();
			int cnt = queue.size();

			for (int i = 0; i < cnt; i++) {

				TreeNode curr = queue.poll();

				list.add(curr.val);

				if (curr.left != null) {
					queue.add(curr.left);
				}

				if (curr.right != null) {
					queue.add(curr.right);
				}
			}

			result.add(list);
		}

		return result;
	}

}
