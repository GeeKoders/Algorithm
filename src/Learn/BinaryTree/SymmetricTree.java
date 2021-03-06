package Learn.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

	
	/*
	 * 101. Symmetric Tree (Easy)
	 * https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/536/
	 * solution: https://leetcode.com/problems/symmetric-tree/solution/
	 * 
	 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
	 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
	 * 
	 * 1
   	  / \
     2   2
    / \ / \
   3  4 4  3
	 * 
	 * But the following [1,2,2,null,3,null,3] is not:
	 * 
	 * 1
      / \
     2   2
      \   \
      3    3
	 * 
	 * But the following [1,2,2,null,3,null,3] is not:
	 * 
	 * 
	 */

	class TreeNode{
		
		int val ;
		TreeNode left ;
		TreeNode right ;
		
		public TreeNode(int val){
			this.val = val ;
		}
		
	}

	//O(N), O(N)
	public boolean isSymmetric(TreeNode root) {
        
        return isMirror(root, root) ;
        
    }
    
    public boolean isMirror(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null) return true ;
        if(t1 == null || t2 == null) return false ;
        
        
        return t1.val == t2.val && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left) ;
        
    }
    /*
     * Runtime: 1 ms, faster than 29.99% of Java online submissions for Symmetric Tree.
     * Memory Usage: 38.6 MB, less than 21.30% of Java online submissions for Symmetric Tree.
     * 
     * Time complexity: O(N)
     * Space complexity: O(N)
     * 
     */
    public boolean isSymmetric2(TreeNode root){
    	
    	Queue<TreeNode> q = new LinkedList<>() ;
    	
    	q.add(root) ;
    	q.add(root) ;
    	
    	while(!q.isEmpty()){
    		
    		TreeNode t1 = q.poll() ;
    		TreeNode t2 = q.poll() ;
    		if(t1 == null && t2 == null) continue ;
    		if(t1 == null || t2 == null) return false; 
    		
    		if(t1.val != t2.val) return false ;
    		q.add(t1.left) ;
    		q.add(t2.right) ;
    		q.add(t1.right) ;
    		q.add(t2.left) ;
    	}
    	
    	return true ;
    	
    	
    }
}
