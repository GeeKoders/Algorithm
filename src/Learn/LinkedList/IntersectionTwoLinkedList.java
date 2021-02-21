package Learn.LinkedList;

public class IntersectionTwoLinkedList {


	class ListNode{
		
		int val ;
		ListNode next ;
		public ListNode(int val){
			this.val = val ;
		}
	}
	
	
	/*
	 * 160. Intersection of Two Linked Lists (Easy)
	 * 
	 * https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1215/
	 * 
	 * solution: https://leetcode.com/problems/intersection-of-two-linked-lists/solution/
	 * 
	 * Runtime: 1 ms, faster than 97.80% of Java online submissions for Intersection of Two Linked Lists.
	 * Memory Usage: 42 MB, less than 51.67% of Java online submissions for Intersection of Two Linked Lists.
	 * 
	 * Time complexity: O(M+N)
	 * Space complexity: O(1)
	 * 
	 */
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        if(headA == null || headB == null){
	            return null;
	        }
	        
	        ListNode a = headA;
	        ListNode b = headB;
	        
	        while(a != b){
	            if(a == null){
	                a = headB;
	            }else{
	                a = a.next;
	            }
	            if(b == null){
	                b = headA;
	            }else{
	                b = b.next;
	            }     
	        }
	        
	        return a;
	    }

}
