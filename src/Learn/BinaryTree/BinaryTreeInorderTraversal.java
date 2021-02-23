package Learn.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

	/*
	 * 94. Binary Tree Inorder Traversal (Medium)
	 * 
	 * https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1383/
	 * 
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
	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
	 * Memory Usage: 37.3 MB, less than 48.80% of Java online submissions for Binary Tree Inorder Traversal.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 */
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
    
    public List<Integer> inorderTraversal2(TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>() ;
        
        Stack<TreeNode> stack = new Stack<>() ;
        
        TreeNode current = root ;
        
        if(root == null) return null ;
        
        while(current!=null || !stack.isEmpty()){
            
            while(current != null){
                stack.push(current) ;
                current = current.left ;
            }
            
            current = stack.pop() ;
            result.add(current.val) ;
            current = current.right ;
                
        }
        
        return result ;
        
    }
    
    private List<Integer> res ;
    
    public List<Integer> inorderTraversal3(TreeNode root) {
        
        res = new ArrayList<>() ;
        traversal(root) ;
        return res ;
    }
    
    public void traversal(TreeNode curr){
        
        if(curr == null) return ;
        
        traversal(curr.left) ;
        res.add(curr.val) ;
        traversal(curr.right) ;
            
    }
	
}


