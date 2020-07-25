package LinkedList;

public class RotateList {

	/*
	 * https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1295/
	 * 
	 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
	 * 
	 * Example 1:
	 * Input: 1->2->3->4->5->NULL, k = 2
	 * Output: 4->5->1->2->3->NULL
	 * 
	 * Explanation:
	 * rotate 1 steps to the right: 5->1->2->3->4->NULL
	 * rotate 2 steps to the right: 4->5->1->2->3->NULL
	 * 
	 * Example 2:
	 * Input: 0->1->2->NULL, k = 4
	 * Output: 2->0->1->NULL
	 * 
	 * Explanation:
	 * rotate 1 steps to the right: 2->0->1->NULL
	 * rotate 2 steps to the right: 1->2->0->NULL
	 * rotate 3 steps to the right: 0->1->2->NULL
	 * rotate 4 steps to the right: 2->0->1->NULL
	 * 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// time limit exceeded
	public ListNode rotateRight1(ListNode head, int k) {

		if (head == null)
			return null;

		ListNode current = head;
		ListNode prev = head;
		int counter = 0;

		while (current != null) {

			if (current.next == null && counter < k) {
				counter++;
				prev.next = current.next;
				current.next = head;
				head = current;
			}
			prev = current;
			current = current.next;

		}

		return head;

	}
	
	public ListNode rotateRight2(ListNode head, int k) {

		if(head == null || head.next == null) return head ;
		
		ListNode dummy = new ListNode(0) ;
		dummy.next = head ;
		
		ListNode slow = dummy ;
		ListNode fast = dummy ;
		
		int size = 0 ; //Get the total length
		
		while(fast != null){
			size++ ;
			fast = fast.next ;
		}
		
		//Get the size-k%size th node
		for(int j=size-k%size; j>0; j--){
			slow = slow.next ;
		}
		
		if(fast.next != null) fast.next = dummy.next ; // Do the rotation
		if(dummy.next != null) dummy.next = slow.next ;
		slow.next = null ;
		
		return dummy.next ;

	}

}
