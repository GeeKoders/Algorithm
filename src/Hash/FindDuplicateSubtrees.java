package Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {

	
	
	/*
	 * https://leetcode.com/explore/learn/card/hash-table/185/hash_table_design_the_key/1127/
	 * solution: https://leetcode.com/problems/find-duplicate-subtrees/solution/
	 * 
	 * Given the root of a binary tree, return all duplicate subtrees.
	 * For each kind of duplicate subtrees, you only need to return the root node of any one of them.
	 * Two trees are duplicate if they have the same structure with the same node values.
	 * 
	 * Example 1:
	 * Input: root = [1,2,3,4,null,2,4,null,null,4]
	 * Output: [[2,4],[4]]
	 * 
	 * Example 2:
	 * Input: root = [2,1,1]
	 * Output: [[1]]
	 * 
	 * Example 3:
	 * Input: root = [2,2,2,3,null,3,null]
	 * Output: [[2,3],[3]]
	 * 
	 * Constraints:
	 * The number of the nodes in the tree will be in the range [1, 10^4]
	 * -200 <= Node.val <= 200
	 */
	public static void main(String[] args) {

	}
	
	private Map<String, Integer> map ; 
    private List<TreeNode> res ;
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    
        map = new HashMap<>() ;
        res = new ArrayList<>() ;
        
        preorderSerial(root) ;
        return res ;
        
    }
    
    private String preorderSerial(TreeNode curr){
        
        if(curr == null) return "N" ;
        
        String serial = curr.val + "," + preorderSerial(curr.left) + preorderSerial(curr.right) ;
        
        map.put(serial, map.getOrDefault(serial, 0) + 1) ;
        
        if(map.get(serial) == 2){
            res.add(curr) ;
        }
        
        return serial ;
        
    }
	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */
	
	

}
