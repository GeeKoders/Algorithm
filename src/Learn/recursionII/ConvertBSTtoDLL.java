package recursionII;

import java.util.Stack;

public class ConvertBSTtoDLL {
	class Node {
		public int val;
		public Node left;
		public Node right;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right) {
			val = _val;
			left = _left;
			right = _right;
		}
	};

	// the smallest (first) and the largest (last) nodes
	Node first = null;
	Node last = null;

	
	/*
	 * 426. Convert Binary Search Tree to Sorted Doubly Linked List (Medium)
	 * 
	 * https://leetcode.com/explore/learn/card/recursion-ii/507/beyond-recursion/2899/
	 * 
	 * solution: https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/solution/
	 * 
	 * reference:
	 * 
	 * https://www.youtube.com/watch?v=8-ErlqTsFN0&ab_channel=CodingSimplified
	 * 
	 * https://thecodingsimplified.com/convert-bst-to-sorted-doubly-linked-list-problem/
	 * 
	 * https://www.youtube.com/watch?v=oY7d3lsC3Ew&ab_channel=happygirlzt
	 * 
	 * 
		50 / 50 test cases passed.
		Status: Accepted
		Runtime: 0 ms
		Memory Usage: 38.6 MB (Your memory usage beats 26.36 % of java submissions.)
		
		Time complexity: O(N)
		Space complexity: O(logN)
		
	 */
	public Node treeToDoublyList(Node root) {
		if (root == null)
			return null;

		helper(root);
		// close DLL
		last.right = first;
		first.left = last;
		return first;
	}
	
	public void helper(Node node) {
		if (node != null) {
			// left
			helper(node.left);
			// node
			if (last != null) {
				// link the previous node (last)
				// with the current one (node)
				last.right = node;
				node.left = last;
			} else {
				// keep the smallest node
				// to close DLL later on
				first = node;
			}
			last = node;
			// right
			helper(node.right);
		}
	}
	// soltuion2 (easy to understand in-place)
    Node dummy;
    
    Node prev;
    
    public Node treeToDoublyList2(Node root) 
    {
        if(root == null)
            return null;
        dummy = new Node(-1);
        prev = dummy;
        dummy.right = root;
        treeToDoublyListHelper(root);
        prev.right = dummy.right;
        dummy.right.left=prev;
        return dummy.right;
        
    }
    
    public void treeToDoublyListHelper(Node node) 
    {
        if(node==null)
            return;
        treeToDoublyListHelper(node.left);
        prev.right = node;
        node.left = prev;
        prev = node;
        treeToDoublyListHelper(node.right);
        
    }
    
    //solution3
    /*
     * 50 / 50 test cases passed.
	   Status: Accepted
       Runtime: 0 ms
       Memory Usage: 38.2 MB (Your memory usage beats 72.97 % of java submissions.)
     * 
     * 
     */
    public Node treeToDoublyList3(Node root){
    	
    	if(root == null) return null ;
    	
    	Node prev = null ;
    	Node head = null ;
    	
    	Stack<Node> stack = new Stack() ;
    	while(root != null || !stack.isEmpty()){
    		
    		while(root!=null){
    			stack.push(root) ;
    			root = root.left ;
    		}
    		
    		root = stack.pop();
    		
    		if(prev == null){
    			head = root; 
    		}else{
    			prev.right = root ;
    			root.left = prev ;
    		}
    		
    		prev = root ;
    		root = root.right ;
    		
    	}
    	
    	prev.right = head ;
    	head.left = prev ;
    	return head ;
    	
    }
	
	
}
