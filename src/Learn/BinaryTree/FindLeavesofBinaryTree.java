package Learn.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesofBinaryTree {

	
	class TreeNode{
		int val ;
		TreeNode left ;
		TreeNode right ;
		public TreeNode(int val){
			this.val = val ;
		}
	}
	/*
	 * 366. Find Leaves of Binary Tree (Medium)
	 * 
	 * https://leetcode.com/problems/find-leaves-of-binary-tree/
	 * 
	 * solution: https://leetcode.com/problems/find-leaves-of-binary-tree/solution/
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Leaves of Binary Tree.
	 * Memory Usage: 37.4 MB, less than 59.81% of Java online submissions for Find Leaves of Binary Tree.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 */
	private List<List<Integer>> res ;
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        res = new ArrayList<>() ;
        
        if(root == null) return res ;
        
        getHeight(root) ;
        
        return res ;
    }
    
    private int getHeight(TreeNode root){
        
        if(root == null) return -1 ;
        
        int leftHeight = getHeight(root.left) ;
        int rightHeight = getHeight(root.right) ;
        
        int currHeight = Math.max(leftHeight, rightHeight) + 1 ;
        
        if(res.size() == currHeight){
            res.add(new ArrayList<>()) ;
        }
        
        res.get(currHeight).add(root.val) ;
    
        return currHeight ;
    }
}
