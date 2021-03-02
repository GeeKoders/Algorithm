package Learn.BinaryTree;

public class CountUnivalueSubtrees {

	class TreeNode{
		int val ;
		TreeNode left ;
		TreeNode right ;
		public TreeNode(int val){
			this.val = val ;
		}
	}
	/*
	 * 250. Count Univalue Subtrees (Medium)
	 * 
	 * https://leetcode.com/problems/count-univalue-subtrees/
	 * 
	 * solution: https://leetcode.com/problems/count-univalue-subtrees/solution/
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Univalue Subtrees.
	 * Memory Usage: 38 MB, less than 79.62% of Java online submissions for Count Univalue Subtrees.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(H)
	 * 
	 * 
	 */
	private int count = 0 ;
    
    public int countUnivalSubtrees(TreeNode root) {
        
        
        helper(root, 0) ;
        
        return count ;
        
    }
    
    private boolean helper(TreeNode root, int val){
        
        if(root == null) return true ;
        
        if(!helper(root.left, root.val) | !helper(root.right, root.val)) return false ;
        
        count ++ ;
        
        return root.val == val ;
    }
}
