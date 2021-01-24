package recursionII;

import java.util.ArrayList;
import java.util.List;

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
	
	
}
