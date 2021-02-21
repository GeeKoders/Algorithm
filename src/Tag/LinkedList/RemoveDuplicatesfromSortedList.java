package Tag.LinkedList;

public class RemoveDuplicatesfromSortedList {

	
	class ListNode{
		int val ;
		ListNode next ;
		public ListNode(int val){
			this.val = val ;
		}
	}
	
	/*
	 * 83. Remove Duplicates from Sorted List (Easy)
	 * 
	 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
	 * 
	 * solution: https://leetcode.com/problems/remove-duplicates-from-sorted-list/solution/
	 * 
	 * Runtime: 1 ms, faster than 24.02% of Java online submissions for Remove Duplicates from Sorted List.
	 * Memory Usage: 41.3 MB, less than 7.05% of Java online submissions for Remove Duplicates from Sorted List.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(1)
	 * 
	 */
	public ListNode deleteDuplicates(ListNode head) {

		if (head == null)
			return head;

		ListNode cur = head;
		ListNode prev = head;

		while (cur != null) {

			prev = cur;
			cur = cur.next;

			while (cur != null && prev.val == cur.val) {
				prev.next = cur.next;
				cur = cur.next;
			}

		}

		return head;
	}
	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
	 * Memory Usage: 38.3 MB, less than 77.27% of Java online submissions for Remove Duplicates from Sorted List.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(1)
	 * 
	 */
	public ListNode deleteDuplicates2(ListNode head) {
	    ListNode current = head;
	    while (current != null && current.next != null) {
	        if (current.next.val == current.val) {
	            current.next = current.next.next;
	        } else {
	            current = current.next;
	        }
	    }
	    return head;
	}
}
