package BinarySearchTree;

public class ConvertSortedArraytoBST {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}

	}
	
	
	/*
	 * https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/143/appendix-height-balanced-bst/1015/
	 * 
	 * solution: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/solution/
	 * 
	 *  32 / 32 test cases passed.
		Status: Accepted
		Runtime: 0 ms
		Memory Usage: 38.7 MB
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 */
	public static void main(String[] args) {
		
	}

	private int[] nums;

	public TreeNode sortedArrayToBST(int[] nums) {
		this.nums = nums;

		return helper(0, nums.length - 1);
	}

	private TreeNode helper(int left, int right) {

		if (left > right)
			return null;

		int middle = left + (right - left) / 2;

		TreeNode root = new TreeNode(nums[middle]);
		root.left = helper(left, middle - 1);
		root.right = helper(middle + 1, right);

		return root;

	}

}
