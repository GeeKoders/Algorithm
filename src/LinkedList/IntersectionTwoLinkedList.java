package LinkedList;

public class IntersectionTwoLinkedList {

	
	/*
	 * https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1215/
	 * 
	 */
	
	public static void main(String[] args) {

	}
	
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
