package BinarySearchTree;

public class SearchInBST {
	
	class TreeNode{
		
		int val ;
		TreeNode left; 
		TreeNode right ;
		
		public TreeNode(int val) {
			this.val = val ;
		}
		
	}
	
	/*
	 * https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/141/basic-operations-in-a-bst/1000/
	 * 
	 * solution: https://leetcode.com/problems/search-in-a-binary-search-tree/solution/
	 * 
	 */
	// time complexity: O(logN), the worst case: O(N)
	// space complexity: O(1)
	public TreeNode searchBST(TreeNode root, int val) {
		
		while(root!=null && root.val != val){
			
			root = val < root.val ? root.left: root.right ;
		}
		return root ;
		
	}
	// time complexity: O(logN), the worst case: O(N)
	// space complexity: O(logN), the worst case: O(N)
	public TreeNode searchBST2(TreeNode root, int val) {
	    if (root == null || val == root.val) return root;

	    return val < root.val ? searchBST2(root.left, val) : searchBST2(root.right, val);
	  }

}
