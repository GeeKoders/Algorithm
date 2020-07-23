package LinkedList;

public class PalindromeLinkedList {

	
	/*
	 * https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1209/
	 * 
	 * Given a singly linked list, determine if it is a palindrome.
	 * 
	 * Example 1:
	 * Input: 1->2
	 * Output: false
	 * 
	 * Example 2:
	 * Input: 1->2->2->1
	 * Output: true
	 * 
	 * Follow up:
	 * Could you do it in O(n) time and O(1) space?
	 * 
	 */
	
	public static void main(String[] args) {

	}

	public boolean isPalindrome(ListNode head) {

		ListNode fast = head, slow = head;

		// getMiddle
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		slow = reverse(slow);
		fast = head;

		while (slow != null) {

			if (fast.val != slow.val) {
				return false;
			}
			fast = fast.next;
			slow = slow.next;
		}

		return true;

	}

	public ListNode reverse(ListNode head) {

		ListNode current = head;
		ListNode prev = null;
		ListNode r = null;

		while (current != null) {

			r = current.next;
			current.next = prev;
			prev = current;
			current = r;

		}

		head = prev;

		return head;

	}

}
