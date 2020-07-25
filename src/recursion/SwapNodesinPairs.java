package recursion;

public class SwapNodesinPairs {

	
	/*
	 * https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1681
	 * 
	 * Given a linked list, swap every two adjacent nodes and return its head.
	 * You may not modify the values in the list's nodes, only nodes itself may be changed.
	 * 
	 * Example:
	 * Given 1->2->3->4, you should return the list as 2->1->4->3.
	 * 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public ListNode swapPairs(ListNode head) {
		 
		 if(head == null || head.next == null) return head ;
		 
		 ListNode dummy = new ListNode(0) ;
		 dummy.next = head ;
		 ListNode prev = dummy ;
		 
		 while(prev.next != null && prev.next.next != null){
			 
			 ListNode cur = prev.next, suc = cur.next, tmp = suc.next ;
			 
			 prev.next = suc ;
			 suc.next = cur ;
			 cur.next = tmp ;
			 prev = cur ;
			 
		 }
		 return dummy.next ;
	 }
	 
	// O(N) time and space due to recursion
	    public ListNode swapPairs2(ListNode cur) {
	        if (cur == null || cur.next == null) return cur;
	        ListNode suc = cur.next;
	        cur.next = swapPairs(suc.next);
	        suc.next = cur;
	        return suc;
	    }

}

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
