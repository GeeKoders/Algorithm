package Learn.BinaryTree;

public class MaximumDepthofBinaryTree {

	
	/*
	 * 104. Maximum Depth of Binary Tree (Easy)
	 * 
	 * https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/535/
	 * 
	 * solution: https://leetcode.com/problems/maximum-depth-of-binary-tree/solution/
	 * 
	 * Given a binary tree, find its maximum depth.
	 * 
	 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
	 * 
	 * Note: A leaf is a node with no children.
	 * 
	 * Example:
	 * Given binary tree [3,9,20,null,null,15,7],
	 * 
	 * 3
   	  / \
     9  20
       /  \
      15   7
	 * 
	 * return its depth = 3.
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
	
	public int maxDepth(TreeNode root) {
        
        if(root==null){
           return 0;
       }
       return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
       
   }
	
	private int res = 0 ;
    /*
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
     * Memory Usage: 39 MB, less than 49.45% of Java online submissions for Maximum Depth of Binary Tree.
     * 
     * Time complexity: O(N)
     * Space complexity: O(logN)
     * 
     */
    public int maxDepth2(TreeNode root) {
        
        if(root == null) return 0 ;
        
        dfs(root, 1) ;
        return res ;
    }
    
    private void dfs(TreeNode root, int cur){
        
        if(root.left == null && root.right == null){
            res = Math.max(res, cur) ;
            return ;
        }
        
        if(root.left != null) dfs(root.left, cur+1) ;
        if(root.right != null) dfs(root.right, cur+1) ;
        
        
        
    }

}
