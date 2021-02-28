package Learn.BinaryTree;

public class BinaryTreeLongestConsecutiveSequence {

	class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}

	}

	int res = 0;

	public int longestConsecutive(TreeNode root) {

		int length = 0;
		if (root == null)
			return length;

		helper(root, 0, root.val);
		return res;

	}
	/*
	 * 298. Binary Tree Longest Consecutive Sequence (Medium)
	 * 
	 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
	 * 
	 * soltuion: https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/solution/
	 * 
	 * reference:
	 * 
	 * https://www.youtube.com/watch?v=W1Xklw94o5M&ab_channel=CHENGaCHENG
	 * 
	 * Runtime: 91 ms, faster than 5.15% of Java online submissions for Binary Tree Longest Consecutive Sequence.
	 * Memory Usage: 42.6 MB, less than 18.03% of Java online submissions for Binary Tree Longest Consecutive Sequence.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 * 
	 */
	private void helper(TreeNode root, int cur, int prev) {

		if (root != null) {

			if (prev + 1 == root.val) {
				cur++;
			} else {
				cur = 1;
			}

			res = Math.max(res, cur);
			System.out.println("res:" + res);

			helper(root.left, cur, root.val);
			helper(root.right, cur, root.val);

		}

	}

}
