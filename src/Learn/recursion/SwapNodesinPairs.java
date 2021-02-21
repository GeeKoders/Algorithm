package Learn.recursion;

public class SwapNodesinPairs {

	/*
	 * 24. Swap Nodes in Pairs (Medium)
	 * 
	 * https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-
	 * recursion/1681
	 * 
	 * solution: https://leetcode.com/problems/swap-nodes-in-pairs/solution/
	 * 
	 * Given a linked list, swap every two adjacent nodes and return its head.
	 * You may not modify the values in the list's nodes, only nodes itself may
	 * be changed.
	 * 
	 * Example: Given 1->2->3->4, you should return the list as 2->1->4->3.
	 */
	class ListNode {

		public int val;

		public ListNode next;

		public ListNode() {
		}

		public ListNode(int val) {
			this.val = val;
		}

		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	/*
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
	 * Memory Usage: 36.5 MB, less than 64.30% of Java online submissions for Swap Nodes in Pairs.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(1)
	 * 
	 */
	public ListNode swapPairs(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;

		while (prev.next != null && prev.next.next != null) {

			ListNode cur = prev.next, suc = cur.next, tmp = suc.next;

			prev.next = suc;
			suc.next = cur;
			cur.next = tmp;
			prev = cur;

		}
		return dummy.next;
	}

	// O(N) time and space due to recursion
	public ListNode swapPairs2(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode second = head.next;
		ListNode third = second.next;

		second.next = head;
		head.next = swapPairs(third);

		return second;
	}

}
