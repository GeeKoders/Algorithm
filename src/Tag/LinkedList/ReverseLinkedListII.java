package Tag.LinkedList;

public class ReverseLinkedListII {

	class ListNode {

		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	/*
	 * 92. Reverse Linked List II (Medium)
	 * 
	 * https://leetcode.com/problems/reverse-linked-list-ii/
	 * 
	 * https://leetcode.com/problems/reverse-linked-list-ii/solution/
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
	 * Memory Usage: 36.7 MB, less than 51.69% of Java online submissions for Reverse Linked List II.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(1)
	 * 
	 */
	public ListNode reverseBetween(ListNode head, int left, int right) {
		if (head == null)
			return head;

		// Move the two pointers until they reach the proper starting point
		// in the list.
		ListNode cur = head, prev = null;
		while (left > 1) {

			prev = cur;
			cur = cur.next;
			left--;
			right--;

		}

		// The two pointers that will fix the final connections.
		ListNode con = prev, tail = cur;
		ListNode third = null;
		while (right > 0) {
			third = cur.next;
			cur.next = prev;
			prev = cur;
			cur = third;
			right--;
		}

		// Adjust the final connections as explained in the algorithm
		if (con != null) {
			con.next = prev;
		} else {
			head = prev;
		}

		tail.next = cur;

		return head;

	}
}
