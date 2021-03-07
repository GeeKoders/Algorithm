package Tag.Tree;

import java.util.LinkedList;
import java.util.List;

public class ConvertSortedListtoBinarySearchTree {

	class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}
	/*
	 * 109. Convert Sorted List to Binary Search Tree (Medium)
	 * 
	 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
	 * 
	 * solution: https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/solution/
	 * 
	 * Runtime: 141 ms, faster than 6.44% of Java online submissions for Convert Sorted List to Binary Search Tree.
	 * Memory Usage: 44.5 MB, less than 5.70% of Java online submissions for Convert Sorted List to Binary Search Tree.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 */
	private List<Integer> values = new LinkedList<>();

	public TreeNode sortedListToBST(ListNode head) {

		if (head == null)
			return null;

		int size = 0;

		while (head != null) {
			size++;
			values.add(head.val);
			head = head.next;
		}

		return helper(values, 0, size - 1);

	}

	private TreeNode helper(List<Integer> values, int left, int right) {

		if (left > right)
			return null;

		int mid = left + (right - left) / 2;

		TreeNode root = new TreeNode(values.get(mid));
		root.left = helper(values, left, mid - 1);
		root.right = helper(values, mid + 1, right);

		return root;

	}

}
