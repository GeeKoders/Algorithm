package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

	/*
	 * https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1383/
	 * solution: https://leetcode.com/problems/binary-tree-inorder-traversal/solution/
	 * 
	 * Given a binary tree, return the inorder traversal of its nodes' values.
     * 
     * Example:
     * Input: [1,null,2,3]
	 *  1
	 * 	 \
	 *    2
	 *   /
	 *  3
	 * Output: [1,3,2]
	 *  
	 */
	
	
	public static void main(String[] args) {

	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>() ;
        
        traverse(root, result) ;
        
        return result ;
        
        
    }
    
    public void traverse(TreeNode root, List<Integer> result){
        
        if(root == null) return ;
        
        if(root.left != null){
            traverse(root.left, result) ;
        }
        
        result.add(root.val) ;
        
        if(root.right != null){
            traverse(root.right, result) ;
        }
        
    }
	
    class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode() {}
    	TreeNode(int val) { this.val = val; }
    	TreeNode(int val, TreeNode left, TreeNode right) {
    		this.val = val;
    		this.left = left;
    		this.right = right;
    	}
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
