package Interview.Google.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {

	class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
	
	/*
	 * 138. Copy List with Random Pointer (Medium)
	 * 
	 * https://leetcode.com/problems/copy-list-with-random-pointer/
	 * 
	 * solution: https://leetcode.com/problems/copy-list-with-random-pointer/solution/
	 * 
	 * reference:
	 * 
	 * https://www.youtube.com/watch?v=ouDuPdr4vz0&ab_channel=%E4%BB%A3%E7%A0%81%E9%AD%94%E6%9C%AF%E5%B8%88magiciendecode
	 * 
	 * https://www.youtube.com/watch?v=OvpKeraoxW0&ab_channel=BackToBackSWE
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Copy List with Random Pointer.
	 * 
	 * Memory Usage: 38.7 MB, less than 68.29% of Java online submissions for Copy List with Random Pointer.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 */
	class Solution {
	    public Node copyRandomList(Node head) {
	        
	        
	        if(head == null) return null ;
	        
	        Map<Node, Node> map = new HashMap<>() ;
	        Node dummy = new Node(-1) ;
	        Node original = head ;
	        Node copy = dummy ;
	        
	        //copy all nodes in list        
	        while(original != null){
	            copy.next = new Node(original.val) ;
	            copy = copy.next ;
	            map.put(original, copy) ;
	            original = original.next ;
	        }
	        
	        //copy all randoms
	        original = head; 
	        
	        while(original!=null){
	            
	            if(original.random != null){
	                
	                Node currentCopy = map.get(original) ;
	                currentCopy.random = map.get(original.random) ;
	            }
	            
	            original = original.next ;
	            
	        }
	        
	        
	        return dummy.next ;
	        
	    }
	}
	
	
}
