package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTreeIteratorWithStack {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;


		TreeNode(int val) {
			this.val = val;
		}

	}
	
	/*
	 * https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/140/introduction-to-a-bst/1008/
	 * 
	 * solution: https://leetcode.com/problems/binary-search-tree-iterator/solution/
	 *
	 */
	
	public static void main(String[] args) {
		
	}
	
	private Stack<TreeNode> stack ;
 
    public BinarySearchTreeIteratorWithStack(TreeNode root) {
        
    	
    	this.stack = new Stack<>() ;
       
        leftmostInorder(root) ;        
        
    }
   
    private void leftmostInorder(TreeNode root) {
    	
    	
    	while(root!=null){
    		this.stack.push(root);
    		root = root.left ;
    	}
    	
	}

	// O(1)
    public int next() {
    	
    	TreeNode tempNode = stack.pop() ;
    	
    	if(tempNode.right!=null){
    		leftmostInorder(tempNode.right) ;
    	}
    	return tempNode.val ;
    }
    // O(1)
    public boolean hasNext() {
        return stack.size() > 0 ;
    }

}
