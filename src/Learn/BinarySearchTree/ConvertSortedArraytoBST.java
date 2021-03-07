package Learn.BinarySearchTree;

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
	 * 108. Convert Sorted Array to Binary Search Tree (Easy)
	 * 
	 * https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/143/appendix-height-balanced-bst/1015/
	 * 
	 * solution: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/solution/
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
	 * Memory Usage: 40.7 MB, less than 16.44% of Java online submissions for Convert Sorted Array to Binary Search Tree.
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
