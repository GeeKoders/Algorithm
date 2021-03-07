package Tag.Tree;

public class LowestCommonAncestorofaBinaryTree {

	class TreeNode{
		
		int val ;
		TreeNode left ;
		TreeNode right ;
		
		public TreeNode(int val){
			this.val = val ;
		}
	}
	/*
	 * 236. Lowest Common Ancestor of a Binary Tree (Medium)
	 * 
	 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
	 * 
	 * solution: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/
	 * 
	 * Runtime: 13 ms, faster than 11.24% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
	 * Memory Usage: 45.3 MB, less than 11.10% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(H)
	 * 
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null || root == p || root == q) return root ;
        TreeNode left = lowestCommonAncestor(root.left, p, q) ;
        TreeNode right = lowestCommonAncestor(root.right, p, q) ;
        
         if(left == null)
            return right;
        else if (right == null)
            return left;
        else
            return root;
            
    }
	
	
}
