package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

	
	/*
	 * https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/928/
	 * 
	 * Given a binary tree, return the preorder traversal of its nodes' values.
	 * 
	 * Example:
	 * Input: [1,null,2,3]
	 * 	1
	 * 	 \
	 *    2
	 *   /
	 *  3
	 * Output: [1,2,3]
	 * Follow up: Recursive solution is trivial, could you do it iteratively?
	 *    
	 */
	public static void main(String[] args) {

	}
	
	private List<Integer> res ; 
    
    public List<Integer> preorderTraversal(TreeNode root) {
        res = new ArrayList<>() ;
        inOrderTraversal(root) ;
        return res ;        
    }
    
    public void inOrderTraversal(TreeNode current){
        
        if(current == null) return ;
        
        res.add(current.val) ;
        inOrderTraversal(current.left) ;
        inOrderTraversal(current.right) ;
    }

}
