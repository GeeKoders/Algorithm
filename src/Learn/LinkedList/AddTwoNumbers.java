package Learn.LinkedList;

public class AddTwoNumbers {

	/*
	 * 2. Add Two Numbers (Medium)
	 * 
	 * https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1228/
	 * 
	 * solution: https://leetcode.com/problems/add-two-numbers/solution/
	 * 
	 * You are given two non-empty linked lists representing two non-negative
	 * integers. The digits are stored in reverse order and each of their nodes
	 * contain a single digit. Add the two numbers and return it as a linked
	 * list.
	 * 
	 * You may assume the two numbers do not contain any leading zero, except
	 * the number 0 itself.
	 * 
	 * Example:
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	 * Output: 7 -> 0 -> 8
	 * Explanation: 342 + 465 = 807.
	 * 
	 * Your runtime beats 77.58 % of java submissions.
	 * Your memory usage beats 61.49 % of java submissions.
	 * 
	 * Time complexity: O(max(m, n))
	 * Space complexity: O(max(m, n))
	 * 
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
		// TODO Auto-generated method stub

	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummyHead = new ListNode(0) ;
        ListNode p = l1, q = l2, curr = dummyHead ;
        int carry = 0 ;
        
        while(p!=null || q!=null){
            
            int x = (p != null) ? p.val : 0 ;
            int y = (q != null) ? q.val : 0 ;
            int sum = carry + x + y ;
            carry = sum / 10 ; 
            curr.next = new ListNode(sum % 10) ;
            curr = curr.next ;
            if(p != null) p = p.next ;
            if(q != null) q = q.next ;
        }
        
        if (carry > 0){
            curr.next = new ListNode(carry) ;
        }
        return dummyHead.next ;
    }

}
