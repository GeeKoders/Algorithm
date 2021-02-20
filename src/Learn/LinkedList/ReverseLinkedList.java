package Learn.LinkedList;

public class ReverseLinkedList {

	
	/*
	 * 206. Reverse Linked List (Easy)
	 * 
	 * https://leetcode.com/problems/reverse-linked-list/
	 * 
	 * https://leetcode.com/problems/reverse-linked-list/solution/
	 * 
	 * Example:
	 * Input: 1->2->3->4->5->NULL
	 * Output: 5->4->3->2->1->NULL
	 * 
	 * Follow up:
	 * A linked list can be reversed either iteratively or recursively. Could you implement both?
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
	 * Memory Usage: 38.5 MB, less than 86.52% of Java online submissions for Reverse Linked List.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(1)
	 * 
	 */

	public ListNode solution1(ListNode head) {

		if(head == null) return head ;
		
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

}

