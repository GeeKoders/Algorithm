package recursionII;

public class ValidateBinarySearchTree {

	class TreeNode{
		int val ;
		TreeNode left ;
		TreeNode right ;
		
		public TreeNode(int val){
			this.val = val ;
		}
	}
	
	
	/*
	 * https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2874/
	 * 
	 * solution: https://leetcode.com/problems/validate-binary-search-tree/solution/
	 * 
	 *  77 / 77 test cases passed.
		Status: Accepted
		Runtime: 0 ms (Your runtime beats 100.00 % of java submissions.)
		Memory Usage: 40.8 MB
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(h)
	 * 
	 */
	public static void main(String[] args) {
		
	}
	
	public boolean isValidBST(TreeNode root) {
        if (root == null)  return false;
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean dfs(TreeNode root, long min, long max) {
        if (root == null)  return true;
        if (root.val <= min || root.val >= max)  return false;
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }
	
}
