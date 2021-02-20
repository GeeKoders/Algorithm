package Learn.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle. (Easy)
	 * 
	 * https://leetcode.com/problems/linked-list-cycle/submissions/
	 * 
	 * solution: https://leetcode.com/problems/linked-list-cycle/solution/
	 * 
	 * Given a linked list, determine if it has a cycle in it.
	 * 
	 * To represent a cycle in the given linked list, we use an integer pos
	 * which represents the position (0-indexed) in the linked list where tail
	 * connects to. If pos is -1, then there is no cycle in the linked list.
	 * 
	 * Example 1:
	 * Input: head = [3,2,0,-4], pos = 1
	 * Output: true
	 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
	 * 
	 * Example 2:
	 * Input: head = [1,2], pos = 0
	 * Output: true
	 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
	 * 
	 * Example 3:
	 * Input: head = [1], pos = -1
	 * Output: false
	 * Explanation: There is no cycle in the linked list.
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//time complexity:O(N), space complexity:O(N)
	public boolean solution1(CycleListNode head) {
	    Set<CycleListNode> nodesSeen = new HashSet<>();
	    while (head != null) {
	        if (nodesSeen.contains(head)) {
	            return true;
	        } else {
	            nodesSeen.add(head);
	        }
	        head = head.next;
	    }
	    return false;
	}
	
	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle.
	 * Memory Usage: 39.8 MB, less than 40.52% of Java online submissions for Linked List Cycle.
	 * 
	 * Time complexity:O(N)
	 * Space complexity:O(1)
	 * 
	 */
	public boolean solution2(CycleListNode head) {
		
		CycleListNode slowPoiner = head ;
		CycleListNode fastPointer = head.next ;
		
		if(head == null || head.next == null){
			return false ;
		}
		
	    while (slowPoiner != fastPointer) {
	        
	    	if(fastPointer == null || fastPointer.next == null){
	    		return false ;
	    	}
	    	
	    	slowPoiner = slowPoiner.next ;
	    	fastPointer = fastPointer.next.next ;
	        
	    }
	    return true;
	}

}

class CycleListNode {
	public int val;
	public CycleListNode next;

	public CycleListNode(int x) {
		this.val = x;
		this.next = null;
	}
}