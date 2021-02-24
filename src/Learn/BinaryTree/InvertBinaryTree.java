package Learn.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

	
	
	class TreeNode{
		int val ;
		TreeNode left ;
		TreeNode right ;
	}
	/*
	 * 226. Invert Binary Tree (Easy)
	 * 
	 * https://leetcode.com/problems/invert-binary-tree/
	 * 
	 * solution: https://leetcode.com/problems/invert-binary-tree/solution/
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
	 * Memory Usage: 36.3 MB, less than 67.69% of Java online submissions for Invert Binary Tree.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 */
	public TreeNode invertTree(TreeNode root) {
        
        if(root == null) return null ;
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.add(root) ;
        
        while(!queue.isEmpty()){
            
            TreeNode cur = queue.poll() ;
            TreeNode temp = cur.left ;
            cur.left = cur.right ;
            cur.right = temp ;
            if(cur.left != null) queue.add(cur.left) ;
            if(cur.right != null) queue.add(cur.right) ;
            
            
        }
            
            
        return root ;
        
    }
}
