package Tag.LinkedList;

public class DeleteNodeinaLinkedList {

	
	class ListNode{
		
		int val ; 
		ListNode next ;
		public ListNode(int val){
			this.val = val ;
		}
		
	}
	
	/*
	 * 237. Delete Node in a Linked List (Easy)
	 * 
	 * https://leetcode.com/problems/delete-node-in-a-linked-list/
	 * 
	 * solution: https://leetcode.com/problems/delete-node-in-a-linked-list/solution/
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a Linked List.
	 * Memory Usage: 40.9 MB, less than 6.62% of Java online submissions for Delete Node in a Linked List.
	 * 
	 * Time complexity: O(1)
	 * Space complexity: O(1)
	 * 
	 */
	public void deleteNode(ListNode node) {

		node.val = node.next.val;
		node.next = node.next.next;
	}
}
