package Learn.LinkedList;

public class RemoveNthNodeFromEndOfList {

	/*
	 * 19. Remove Nth Node From End of List (Medium)
	 * 
	 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
	 * 
	 * solution: https://leetcode.com/problems/remove-nth-node-from-end-of-list/solution/
	 * 
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
	 * 
		208 / 208 test cases passed.
		Status: Accepted
		Runtime: 7 ms
		Memory Usage: 38.5 MB
	 * 
	 * Your memory usage beats 19.08 % of java submissions.
	 * 
	 * Time complexity: O(L)
	 * Space complexity: O(1)
	 * 
	 */

	
	class ListNode{
		
		int val ; 
		
		ListNode next ;
		
		public ListNode(int val){
			this.val = val ;
		}
		
		public ListNode(int val, ListNode next){
			this.val = val ;
			this.next = next ;
		}
		
	}
	
	public static void main(String[] args) {

	}
	
	// not a good solution
	public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int size = getSize(head) ;
        if(n<0 || n>size){
            return null ;
        }
        
        ListNode current = head ;
        ListNode prev = head ;
    
        int index = size - n;
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
        
    	int count = 0 ;
    	
        ListNode current = head ;
        
        while(current!=null){
            count++ ; 
            current = current.next ;
        }
        
        return count ;
        
    }
    /*
     * 
     * 
		208 / 208 test cases passed.
		Status: Accepted
		Runtime: 0 ms
		Memory Usage: 36.9 MB
     * 
     * Your memory usage beats 78.49 % of java submissions.
     * 
     * Time complexity: O(L)
	 * Space complexity: O(1)
	 * 
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        ListNode prev = dummy;
        while (n-- > 0) {
            curr = curr.next;
        }
        while (curr.next != null) {
            curr = curr.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
    }
    
    /*
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
     * Memory Usage: 37.3 MB, less than 22.30% of Java online submissions for Remove Nth Node From End of List.
     * 
     * Time complexity: O(L)
	 * Space complexity: O(1)
     * 
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
    	 if(head == null) return head ;
         
         int size = traversal(head) ;
         
         if(n > size) return head ;
         if(n == size) return head.next ;
         
         int counter = size - n ;
         
         ListNode prev = null ;
         ListNode cur = head ;
         
         while(counter -- > 0 && cur!=null){
             prev = cur ;
             cur = cur.next ;
         }
         
         if(prev == null){
             return null ;
         }else{
             prev.next = cur.next ;
         }
         
         
         return head ;        
    }
    
    private int traversal(ListNode head){
        
        ListNode cur = head ;
        
        int count = 0 ;
        
        while(cur!=null){
            count++ ;
            cur = cur.next ;
        }
        
        return count ;
    }
    

}
