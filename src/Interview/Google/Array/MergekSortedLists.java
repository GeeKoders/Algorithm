package Interview.Google.Array;

import java.util.PriorityQueue;

public class MergekSortedLists {

	
	/*
	 * 23. Merge k Sorted Lists (Hard)
	 * 
	 * https://leetcode.com/problems/merge-k-sorted-lists/
	 * 
	 * solution: https://leetcode.com/problems/merge-k-sorted-lists/solution/
	 * 
	 * reference:
	 * 
	 * https://www.youtube.com/watch?v=zLcNwcR6yO4&ab_channel=KevinNaughtonJr.
	 * 
	 * Your runtime beats 47.73 % of java submissions.
	 * Your memory usage beats 93.15 % of java submissions.
	 * 
	 * Time complexity: O(n*mlog(n*m))
	 * Space complexity: O(n*m)
	 * 
	 * where n = max # of lists and m = max # of nodes in a list
	 * 
	 * 
	 */
	public ListNode mergeKLists(ListNode[] lists) {

		PriorityQueue<Integer> heap = new PriorityQueue<>();

		for (ListNode head : lists) {
			while (head != null) {
				heap.add(head.val);
				head = head.next;
			}
		}

		ListNode dummy = new ListNode(-1);
		ListNode head = dummy;

		while (!heap.isEmpty()) {
			head.next = new ListNode(heap.remove());
			head = head.next;
		}

		return dummy.next;

	}

}
