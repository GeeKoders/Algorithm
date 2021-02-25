package Learn.BinaryTree;

public class SumRoottoLeafNumbers {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	/*
	 * 129. Sum Root to Leaf Numbers (Medium)
	 * 
	 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
	 * 
	 * solution: https://leetcode.com/problems/sum-root-to-leaf-numbers/solution/
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum Root to Leaf Numbers.
	 * Memory Usage: 36.8 MB, less than 47.81% of Java online submissions for Sum Root to Leaf Numbers.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(H)
	 * 
	 */
	private int sum = 0;

	public int sumNumbers(TreeNode root) {

		if (root == null)
			return sum;

		helper(root, 0);
		return sum;
	}

	private void helper(TreeNode root, int cur) {

		if (root != null) {

			cur = cur * 10 + root.val;

			if (root.left == null && root.right == null) {

				sum += cur;

			} else {

				helper(root.left, cur);
				helper(root.right, cur);
			}
		}

	}
}
