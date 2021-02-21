package Tag.LinkedList;

public class RemoveDuplicatesfromSortedListII {
	
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
	
	/*
	 * 82. Remove Duplicates from Sorted List II (Medium)
	 * 
	 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
	 * 
	 * solution: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/solution/
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List II.
	 * Memory Usage: 38.4 MB, less than 56.57% of Java online submissions for Remove Duplicates from Sorted List II.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(1)
	 * 
	 * 
	 */
	public ListNode deleteDuplicates(ListNode head) {

		if (head == null)
			return head;

		ListNode dummy = new ListNode(0, head);

		ListNode prev = dummy;
		ListNode cur = head;

		while (cur != null && cur.next != null) {

			if (cur.val != cur.next.val) {
				prev = cur;

			} else {
				while (cur != null && cur.next != null
						&& cur.val == cur.next.val) {
					cur = cur.next;
				}

				prev.next = cur.next;

			}

			cur = cur.next;
		}

		return dummy.next;

	}
}
