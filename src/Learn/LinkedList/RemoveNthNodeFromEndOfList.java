package LinkedList;

public class RemoveNthNodeFromEndOfList {

	/*
	 * Given a linked list, remove the n-th node from the end of list and return
	 * its head. 
	 * Example: Given linked list: 1->2->3->4->5, and n = 2. 
	 * After removing the second node from the end, the linked list becomes 1->2->3->5.
	 * 
	 * Note:
	 * 
	 * Given n will always be valid.
	 * 
	 * Follow up:
	 * 
	 * Could you do this in one pass?
	 */

	private int count = 0 ;
	
	public static void main(String[] args) {

	}
	
	// not a good solution
	public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int size = getSize(head) ;
        System.out.println("size:" + size) ;
        if(n<0 || n>size){
            return null ;
        }
        
        ListNode current = head ;
        ListNode prev = head ;
    
        int index = size - n;
        int target = getIndex(head, index) ;
        System.out.println("target:" + target) ;
        int counter = 0 ;
        while(current!=null && counter++ != index){
            prev = current ;
            current = current.next ;
        }
        if(prev == current){
            head = head.next ;
        }else{
            prev.next = current.next ;    
        }
        
        
        return head ;
        
    }
    
    public int getSize(ListNode head){
        
        ListNode current = head ;
        
        while(current!=null){
            count++ ; 
            current = current.next ;
        }
        
        return count ;
        
    }
    
    public int getIndex(ListNode head, int index){
        int count = 0 ;
        
        ListNode current = head ;
        
        while(count++ < index){
            current = current.next ;
        }
        return current.val ;    
        
        
    }
    

}
