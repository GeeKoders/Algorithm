package Learn.LinkedList;

public class OddEvenLinkedList {

	/*
	 * 328. Odd Even Linked List (Medium)
	 * 
	 * https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1208/
	 * 
	 * solution: https://leetcode.com/problems/odd-even-linked-list/solution/
	 * 
	 * Given a singly linked list, group all odd nodes together followed by the
	 * even nodes. Please note here we are talking about the node number and not
	 * the value in the nodes.
	 * 
	 * You should try to do it in place. The program should run in O(1) space
	 * complexity and O(nodes) time complexity.
	 * 
	 * 
	 * Example 1:
	 * Input: 1->2->3->4->5->NULL
	 * Output: 1->3->5->2->4->NULL
	 * 
	 * Example 2:
	 * Input: 2->1->3->5->6->4->7->NULL
	 * Output: 2->3->6->7->1->5->4->NULL
	 * 
	 * Constraints:
	 * The relative order inside both the even and odd groups should remain as it was in the input.
	 * The first node is considered odd, the second node even and so on ...
	 * The length of the linked list is between [0, 10^4].
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Odd Even Linked List.
	 * Memory Usage: 38.2 MB, less than 97.15% of Java online submissions for Odd Even Linked List.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(1)
	 * 
	 */


	class ListNode{
		
		int val ;
		ListNode next ;
		
		public ListNode(int val){
			this.val = val ;
		}
		
	}

	public ListNode oddEvenList(ListNode head) {

		if (head == null)
			return null;

		ListNode odd = head;
		ListNode evenHead = head.next;
		ListNode even = head.next;

		while (even != null && even.next != null) {

			odd.next = even.next;
			odd = even.next;
			even.next = odd.next;
			even = odd.next;

		}
		odd.next = evenHead;

		return head;

	}

}
