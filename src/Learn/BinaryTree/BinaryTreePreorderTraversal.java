package Learn.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

	
	/*
	 * 144. Binary Tree Preorder Traversal (Medium)
	 * 
	 * https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/928/
	 * 
	 * solution: https://leetcode.com/problems/binary-tree-preorder-traversal/solution/
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
	
	class TreeNode{
		
		int val ;
		TreeNode left ;
		TreeNode right ;
		public TreeNode(int val, TreeNode left, TreeNode right){
			this.val = val ;
			this.left = left ;
			this.right = right ;
		}
		
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
    /*
     * 
     * 
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
     * Memory Usage: 37.2 MB, less than 65.93% of Java online submissions for Binary Tree Preorder Traversal.
     * 
     * Time complexity: O(logN)
     * Space complexity: O(N)
     * 
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        
        List<Integer> res = new ArrayList<>() ;
        
        return traversal(res, root) ;
        
    }
    
    private List<Integer> traversal(List<Integer> res, TreeNode root){
        
        if(root == null) return res ;
        
        res.add(root.val) ;
        
        traversal(res, root.left) ;
        traversal(res, root.right) ;
        
        return res ;
    } 

}
