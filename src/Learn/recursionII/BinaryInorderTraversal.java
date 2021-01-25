package recursionII;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryInorderTraversal {

	class TreeNode{
		
		int val ;
		TreeNode left ;
		TreeNode right ;
		public TreeNode(int val){
			this.val = val ;
		}
		
	}
	/*
	 * recursive
	 * 
	 * 94. Binary Tree Inorder Traversal (Medium)
	 * 
	 * https://leetcode.com/explore/learn/card/recursion-ii/503/recursion-to-iteration/2774/
	 * 
	 * solution: https://leetcode.com/problems/binary-tree-inorder-traversal/solution/
	 * 
	 * 
		68 / 68 test cases passed.
		Status: Accepted
		Runtime: 0 ms
		Memory Usage: 39.1 MB
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(logN)
	 * 
	 */
	public List <Integer> inorderTraversal(TreeNode root) {
        List <Integer> res = new ArrayList();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List < Integer > res) {
        
        if(root == null) return ;
        
        if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
    }
    
    /*
     * Stack solution
     * 
     *  68 / 68 test cases passed.
		Status: Accepted
		Runtime: 1 ms
		Memory Usage: 39 MB
		
		Time Complexity: O(N)
		Space complexity: O(N)
     * 
     */
    public List <Integer> inorderTraversal2(TreeNode root) {
    	 
    	
    	List <Integer> result = new ArrayList<>() ;
         Stack<TreeNode> stack = new Stack() ;
         TreeNode curr = root; 
         
         while(curr!= null || !stack.isEmpty()){
             
             while(curr!=null){
                 stack.push(curr) ;
                 curr = curr.left ;
             }
             curr = stack.pop() ;
             result.add(curr.val) ;
             curr = curr.right ;
         }
         
         return result ;
    }
	
	
}
