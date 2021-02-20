package Tag.LinkedList;

public class ReverseNodesinkGroup {

	class ListNode {

		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}

	}
	/*
	 * 
	 * 
	 * https://leetcode.com/problems/reverse-nodes-in-k-group/submissions/
	 * 
	 * solution: https://leetcode.com/problems/reverse-nodes-in-k-group/solution/
	 * 
	 * reference:
	 * 
	 * https://www.youtube.com/watch?v=DryIN7iL4pA&ab_channel=Cspiration%E5%AE%98%E6%96%B9%E9%A2%91%E9%81%93
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Nodes in k-Group.
	 * Memory Usage: 39.1 MB, less than 78.80% of Java online submissions for Reverse Nodes in k-Group.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 */
	public ListNode reverseKGroup(ListNode head, int k) {

		if (head == null || head.next == null)
			return head;

		int count = 0;
		ListNode cur = head;

		while (cur != null && count != k) {
			cur = cur.next;
			count++;
		}

		if (count == k) {
			cur = reverseKGroup(cur, k);
			while (count-- > 0) {
				ListNode temp = head.next;
				head.next = cur;
				cur = head;
				head = temp;
			}

			head = cur;
		}

		return head;

	}

}
