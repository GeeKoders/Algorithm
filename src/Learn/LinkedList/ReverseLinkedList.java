package LinkedList;

public class ReverseLinkedList {

	
	/*
	 * Reverse a singly linked list.
	 * 
	 * Example:
	 * Input: 1->2->3->4->5->NULL
	 * Output: 5->4->3->2->1->NULL
	 * 
	 * Follow up:
	 * A linked list can be reversed either iteratively or recursively. Could you implement both?
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 * 
	 * Time Complexity O(N)
	 * Space Complexity O(1)
	 * 
	 */

	public ListNode solution1(ListNode head) {

		ListNode current = head ;
        ListNode prev = null ;
        ListNode r = null ;
        
        while(current!=null){
            
            r = current.next ;
            current.next = prev;
            prev = current ;
            current = r ;
            
        }
        
        head = prev ;
        
        return head ;
	}

}

class ListNode {
	
	int val;
	
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}