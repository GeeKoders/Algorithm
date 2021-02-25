package Learn.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

	
	class TreeNode{
		
		int val ;
		TreeNode left ;
		TreeNode right ;
		
		public TreeNode(int val){
			this.val = val ;
		}
		
	}
	
public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> res = new ArrayList<>() ;
        List<Integer> list = new ArrayList<>() ;
        
        if(root == null) return res;
        
        helper(root, targetSum, list, res) ;
        
        return res ;
        
    }
    /*
     * 113. Path Sum II (Medium)
     * 
     * https://leetcode.com/problems/path-sum-ii/
     * solution: https://leetcode.com/problems/path-sum-ii/solution/
     * 
     * Runtime: 1 ms, faster than 99.97% of Java online submissions for Path Sum II.
     * Memory Usage: 39.2 MB, less than 80.84% of Java online submissions for Path Sum II.
     * 
     * Time complexity: O(N^2)
     * Space complexity: O(N)
     * 
     */
    private void helper(TreeNode root, int targetSum, List<Integer> list, List<List<Integer>> res){
        
        
        list.add(root.val) ;
        
        if(root.left == null && root.right == null){
            
            if(root.val == targetSum)
                res.add(new ArrayList<>(list)) ;
            return ;
        }
        
        if(root.left != null){
            
            helper(root.left, targetSum - root.val, list, res) ;
            list.remove(list.size() - 1) ;
        }
        
        if(root.right != null){
             helper(root.right, targetSum - root.val, list, res) ;
            list.remove(list.size() - 1) ;
        }
        
    }
}
