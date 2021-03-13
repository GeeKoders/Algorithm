package Learn.BinarySearch;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {

	
	/*
	 * 116. Populating Next Right Pointers in Each Node (Medium)
	 * 117. Populating Next Right Pointers in Each Node II (Medium)
	 * 
	 * 
	 * https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/994
	 * 
	 * solution: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/solution/
	 * 
	 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
	 * 
	 * 		struct Node {
			  int val;
			  Node *left;
			  Node *right;
			  Node *next;
			}	
			
	 *  Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
	 *  Initially, all next pointers are set to NULL.
	 *  
	 *  Follow up:	
	 *  You may only use constant extra space.
	 *  Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.	
	 *
	 *  Input: root = [1,2,3,4,5,6,7]
	 *	Output: [1,#,2,3,#,4,5,6,7,#]
	 *  Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
	 *
	 *	Constraints:
	 *  The number of nodes in the given tree is less than 4096.
	 *  -1000 <= node.val <= 1000
	 *  
	 */
	//Time Limit Exceeded
	public Node connect(Node root) {

		while (root != null && root.left != null) {
			Node cur = root;
			while (cur != null) {
				cur.left.next = cur.right;
				if (cur.right != null && cur.next != null) {
					cur.right.next = cur.next.left;
				}
				cur = cur.next;
			}
			
		}
		root = root.left;

		return root;
	}
	
	public Node connect2(Node root) {
        
	      if(root == null) return root;
	        
	        Node curr = root;
	        while(curr != null) {
	            Node head = curr;
	            while(curr != null) {
	               if(curr.left != null) {
	                   curr.left.next = curr.right;
	               }
	                
	                if(curr.right != null && curr.next != null) {
	                    curr.right.next = curr.next.left;
	                }
	                curr = curr.next;
	            }
	            curr = head.left;
	        }
	        
	        return root;
	        
	}
	/*
	 * Runtime: 2 ms, faster than 45.35% of Java online submissions for Populating Next Right Pointers in Each Node.
	 * Memory Usage: 39.1 MB, less than 70.19% of Java online submissions for Populating Next Right Pointers in Each Node.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 */
	public Node connect3(Node root) {
        
	      if(root == null) return root;
	        
	      Queue<Node> queue = new LinkedList<>() ;
	        
	        queue.add(root) ;
	        
	        while(!queue.isEmpty()){
	            
	            int n = queue.size() ;
	            
	            for(int i=0; i<n; i++){
	                Node cur = queue.poll() ;
	                if(i < n - 1){
	                    cur.next = queue.peek() ;
	                }
	                
	                
	                
	                if(cur.left != null) queue.add(cur.left) ;
	                
	                if(cur.right != null) queue.add(cur.right) ;
	                    
	            }
	            
	            
	        }
	        
	        return root ;        
	       
	        
	    }
}

class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
};