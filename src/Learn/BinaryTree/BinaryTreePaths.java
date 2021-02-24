package Learn.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

	class TreeNode{
		
		int val ;
		TreeNode left ;
		TreeNode right ;
		
		public TreeNode(int val){
			this.val = val ;
		}
		
	}
	/*
	 * 257. Binary Tree Paths (Easy)
	 * 
	 * https://leetcode.com/problems/binary-tree-paths/
	 * 
	 * solution: https://leetcode.com/problems/binary-tree-paths/solution/
	 * 
	 * Runtime: 1 ms, faster than 99.81% of Java online submissions for Binary Tree Paths.
	 * Memory Usage: 39.3 MB, less than 58.21% of Java online submissions for Binary Tree Paths.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 */
	public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> res = new ArrayList<>() ;
        
        if(root == null) return res ;
        
        helper(root, "", res) ;
        
        return res ; 
       
    }
    
    private void helper(TreeNode root, String curString, List<String> res){
        
        if(root != null){
            curString += Integer.toString(root.val) ;
        
            if(root.left == null && root.right == null){
                res.add(curString) ;
            }else{
                curString += "->" ;
                helper(root.left, curString, res) ;
                helper(root.right, curString, res) ;    
            }    
        }
        
    }
}
