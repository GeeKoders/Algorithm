package Interview.Google.TreesandGraphs;

public class BinaryTreeMaximumPathSum {

	class TreeNode{
		
		int val ;
		
		TreeNode left ;
		TreeNode right ;
		
		public TreeNode(int val){
			this.val = val ;
		}
		
	}
	
	/*
	 * 124. Binary Tree Maximum Path Sum (Hard)
	 * 
	 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
	 * 
	 * solution: https://leetcode.com/problems/binary-tree-maximum-path-sum/
	 * 
	 * Your runtime beats 100.00 % of java submissions.
	 * Your memory usage beats 76.61 % of java submissions.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(H), where H is a tree height, to keep the recursion stack. In the average case of balanced tree, the tree height H = logN, in the worst case of skewed tree, H = N.
	 * 
	 */
	int res = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {

		max_gain(root);

		return res;

	}

	private int max_gain(TreeNode root) {

		if (root == null)
			return 0;

		int left_gain = Math.max(max_gain(root.left), 0);
		int right_gain = Math.max(max_gain(root.right), 0);

		int sum = root.val + left_gain + right_gain;

		res = Math.max(res, sum);

		return root.val + Math.max(left_gain, right_gain);

	}
}
