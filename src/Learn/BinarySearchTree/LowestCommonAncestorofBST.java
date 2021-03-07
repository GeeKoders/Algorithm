package Learn.BinarySearchTree;

public class LowestCommonAncestorofBST {
	class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}

	}
	
	/*
	 * 235. Lowest Common Ancestor of a Binary Search Tree (Easy)
	 * 
	 * https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/142/conclusion/1012/
	 * 
	 * solution: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/solution/
	 * 
	 * youtube: https://www.youtube.com/watch?v=6POfA8fruxI&ab_channel=NickWhite
	 * 
	 * 
	 *  27 / 27 test cases passed.
		Status: Accepted
		Runtime: 3 ms
		Memory Usage: 39.7 MB
	 * 
	 * recursively
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 */
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q) ;
        }
        
         if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q) ;
        }
        
        return root ;
        
    }
	
	/*
	 * 
	 * Runtime: 6 ms, faster than 21.00% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
	 * Memory Usage: 47.1 MB, less than 9.14% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
	 * 
	 * iteratively
	 * Time complexity: O(N)
	 * Space complexity: O(1)
	 * 
	 * 
	 */
	
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        
        
		TreeNode curr = root ;
        
        while(curr != null){
			if(p.val < curr.val && q.val < curr.val){
	            curr = curr.left ; 
	        }else if(p.val > curr.val && q.val > curr.val){
	        	curr = curr.right ;
	        }else{
                return curr ;
            }
	        
	         
		}
		
		return null ;
        
    }
	
}
