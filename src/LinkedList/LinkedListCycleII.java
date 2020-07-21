package LinkedList;

public class LinkedListCycleII {

	/*
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public CycleListIINode detectCycle(CycleListIINode head) {

		if (head == null || head.next == null) {
			return null;
		}

		CycleListIINode slowPointer = head;
		CycleListIINode fastPointer = head;

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

}

class CycleListIINode {
	public int val;
	public CycleListIINode next;

	public CycleListIINode(int x) {
		this.val = x;
		this.next = null;
	}
}