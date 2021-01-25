package LinkedList;

public class RemoveLinkedListElements {

	/*
	 * https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1207/
	 * Remove all elements from a linked list of integers that have value val.
	 * 
	 * Example:
	 * Input:  1->2->6->3->4->5->6, val = 6
	 * Output: 1->2->3->4->5
	 * 
	 */
	
	public static void main(String[] args) {

	}

	public ListNode removeElements(ListNode head, int val) {

		while (head != null && head.val == val) {
			head = head.next;
		}

		if (head == null)
			return head;

		ListNode current = head;

		while (current.next != null) {

			if (current.next.val == val) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		return head;
	}

}
