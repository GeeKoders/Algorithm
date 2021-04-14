package Tag.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class DeleteNodesAndReturnForest {

	class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

	}
	
	/*
	 * 1110. Delete Nodes And Return Forest (Medium)
	 * 
	 * https://leetcode.com/problems/delete-nodes-and-return-forest/
	 * 
	 * reference: https://www.youtube.com/watch?v=2kjsLdDKlmA&ab_channel=happygirlzt
	 * 
	 * Runtime: 3 ms, faster than 17.11% of Java online submissions for Delete Nodes And Return Forest.
	 * Memory Usage: 39.6 MB, less than 56.09% of Java online submissions for Delete Nodes And Return Forest.
	 * 
	 */
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

		List<TreeNode> res = new LinkedList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		res.add(root);
		Set<Integer> set = new HashSet<>();

		for (int d : to_delete) {
			set.add(d);
		}

		while (!q.isEmpty()) {

			TreeNode cur = q.poll();

			if (set.contains(cur.val)) {
				res.remove(cur);
				if (cur.left != null)
					res.add(cur.left);
				if (cur.right != null)
					res.add(cur.right);
			}

			if (cur.left != null) {

				q.offer(cur.left);

				if (set.contains(cur.left.val)) {
					cur.left = null;
				}

			}

			if (cur.right != null) {

				q.offer(cur.right);

				if (set.contains(cur.right.val)) {
					cur.right = null;
				}

			}

		}

		return res;

	}

}
