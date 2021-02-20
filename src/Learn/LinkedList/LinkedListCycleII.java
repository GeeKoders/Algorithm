package Learn.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {

	/*
	 * 142. Linked List Cycle II (Medium)
	 * 
	 * https://leetcode.com/problems/linked-list-cycle-ii/
	 * 
	 * solution: https://leetcode.com/problems/linked-list-cycle-ii/solution/
	 * 
	 * Given a linked list, return the node where the cycle begins. If there is
	 * no cycle, return null.
	 * 
	 * To represent a cycle in the given linked list, we use an integer pos
	 * which represents the position (0-indexed) in the linked list where tail
	 * connects to. If pos is -1, then there is no cycle in the linked list.
	 * 
	 * Note: Do not modify the linked list.
	 * 
	 * Example 1: 
	 * Input: head = [3,2,0,-4], pos = 1 
	 * Output: tail connects to node index 1
	 * Explanation: There is a cycle in the linked list, where tail
	 * connects to the second node.
	 */
	
	class ListNode{
		
		int val ;
		ListNode next ;
		public ListNode(int val){
			this.val = val ;
		}
		
	}

	
	public ListNode detectCycle(ListNode head) {

		if (head == null || head.next == null) {
			return null;
		}

		ListNode slowPointer = head;
		ListNode fastPointer = head;

		do {

			if (fastPointer == null || fastPointer.next == null) {
				return null;
			}
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		} while (slowPointer != fastPointer);

		fastPointer = head;

		while (slowPointer != fastPointer) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next;
		}

		return slowPointer;
	}
	
	/*
	 * 
	 * Runtime: 3 ms, faster than 24.85% of Java online submissions for Linked List Cycle II.
	 * Memory Usage: 40 MB, less than 26.39% of Java online submissions for Linked List Cycle II.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 */
	public ListNode detectCycle2(ListNode head) {
	    
		Set<ListNode> visited = new HashSet<ListNode>();

        ListNode node = head;
        while (node != null) {
            if (visited.contains(node)) {
                return node;
            }
            visited.add(node);
            node = node.next;
        }

        return null;
        
    }

}