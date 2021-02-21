package Learn.LinkedList;

public class RemoveLinkedListElements {

	/*
	 * 203. Remove Linked List Elements (Easy)
	 * 
	 * https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1207/
	 * 
	 * solution: https://leetcode.com/problems/remove-linked-list-elements/solution/
	 * 
	 * Remove all elements from a linked list of integers that have value val.
	 * 
	 * Example:
	 * Input:  1->2->6->3->4->5->6, val = 6
	 * Output: 1->2->3->4->5
	 * 
	 */
	class ListNode{
		
		int val ;
		ListNode next ;
		public ListNode(int val){
			this.val = val ; 
		}
		
		public ListNode(int val, ListNode next){
			this.val = val ;
			this.next = next ;
		}
		
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
	/*
	 * 
	 * Runtime: 1 ms, faster than 78.37% of Java online submissions for Remove Linked List Elements.
	 * Memory Usage: 39.3 MB, less than 99.05% of Java online submissions for Remove Linked List Elements.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(1)
	 * 
	 */
	public ListNode removeElements2(ListNode head, int val) {

		ListNode dummy = new ListNode(0, head) ;
		
		ListNode prev = dummy, cur = head ;
		
		while(cur != null){
			
			if(cur.val == val){
				prev.next = cur.next ;
			}else{
				prev = cur ;
			}
			
			cur = cur.next ;
			
		}
		
		return dummy.next ;
		
		
	}
	

}
