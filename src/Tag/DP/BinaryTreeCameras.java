package Tag.DP;

public class BinaryTreeCameras {
	
	class TreeNode{
		int val ; 
		TreeNode left ;
		TreeNode right ;
		public TreeNode(int val){
			this.val = val ;
		}
	}
	
	
	
	/*
	 * 968. Binary Tree Cameras (Hard)
	 * 
	 * https://leetcode.com/problems/binary-tree-cameras/
	 * 
	 * solution: https://leetcode.com/problems/binary-tree-cameras/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=mo2M_BuaUL8&ab_channel=happygirlzt
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Cameras.
	 * Memory Usage: 38.7 MB, less than 49.95% of Java online submissions for Binary Tree Cameras.
	 * 
	 */
	
	// 0: cannot be covered
	// 1: put a camera here
	// 2: no camera, can be covered (is null)

	int total = 0;

	public int minCameraCover(TreeNode root) {

		if (helper(root) == 0) {
			total += 1;
		}

		return total;

	}

	private int helper(TreeNode root) {

		if (root == null)
			return 2;
		int left = helper(root.left);
		int right = helper(root.right);

		if (left == 0 || right == 0) {
			total += 1;
			return 1;
		}

		if (left == 2 && right == 2) {
			return 0;
		} else
			return 2;

	}
}
