package Tag.LinkedList;

public class PlusOneLinkedList {

	class ListNode {

		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}

		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

	}
	
	/*
	 * 369. Plus One Linked List (Medium)
	 * 
	 * https://leetcode.com/problems/plus-one-linked-list/
	 * 
	 * solution: https://leetcode.com/problems/plus-one-linked-list/solution/
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One Linked List.
	 * Memory Usage: 36.5 MB, less than 84.07% of Java online submissions for Plus One Linked List.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(1)
	 * 
	 */
	public ListNode plusOne(ListNode head) {

		// sentinel head
		ListNode dummy = new ListNode(0, head);
		ListNode notNine = dummy;

		// find the rightmost not-nine digit
		while (head != null) {
			if (head.val != 9) {
				notNine = head;
			}
			head = head.next;
		}

		// increase this rightmost not-nine digit by 1
		notNine.val++;
		notNine = notNine.next;

		// set all the following nines to zeros
		while (notNine != null) {
			notNine.val = 0;
			notNine = notNine.next;
		}

		return dummy.val != 0 ? dummy : dummy.next;

	}
}
