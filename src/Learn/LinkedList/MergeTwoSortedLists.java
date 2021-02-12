package Learn.LinkedList;

public class MergeTwoSortedLists {

	/*
	 * 21. Merge Two Sorted Lists (Easy)
	 * 
	 * solution: https://leetcode.com/problems/merge-two-sorted-lists/solution/
	 * 
	 * https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1227/
	 * https://www.youtube.com/c/FisherCoder/videos
	 * 
	 * Merge two sorted linked lists and return it as a new sorted list. The new
	 * list should be made by splicing together the nodes of the first two
	 * lists.
	 * 
	 * Example:
	 * Input: 1->2->4, 1->3->4
	 * Output: 1->1->2->3->4->4
	 * 
	 * Time complexity: O(n+m)
	 * Space complexity: O(n+m)
	 * 
	 */

	class ListNode{
		
		int val ;
		
		ListNode next ;
		
		public ListNode(int val){
			this.val = val ;
		}
		
	}
	
	public static void main(String[] args) {

	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1 == null) return l2 ;
        if(l2 == null) return l1 ;
        
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2) ;
            return l1 ;
        }else{
            l2.next = mergeTwoLists(l1, l2.next) ;
            return l2 ;
        }

    }
	/*
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
	 * Memory Usage: 38.4 MB, less than 51.26% of Java online submissions for Merge Two Sorted Lists.
	 * 
	 * Time complexity: O(n+m)
	 * Space complexity: O(1)
	 * 
	 */
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        
        if(l1 == null && l2 == null) return null ;
        
        ListNode dummy = new ListNode(-1) ;
        ListNode curr = dummy ;
        
        ListNode curr1 = l1 ;
        ListNode curr2 = l2 ;
        
        while(curr1 != null && curr2 !=null){
            
                if(curr1.val <= curr2.val){
                    curr.next = new ListNode(curr1.val)  ;
                    curr1 = curr1.next ;
                }else{
                    curr.next = new ListNode(curr2.val)  ;
                    curr2 = curr2.next ;
                }
                
                curr = curr.next ;
        }
        
         while(curr1 != null){
                curr.next = new ListNode(curr1.val)  ;
                curr1 = curr1.next ;
                curr = curr.next ;
        }
                
        while(curr2 != null){
            curr.next = new ListNode(curr2.val)  ;
            curr2 = curr2.next ;
            curr = curr.next ;
        }
        
        return dummy.next ;
    }

}
