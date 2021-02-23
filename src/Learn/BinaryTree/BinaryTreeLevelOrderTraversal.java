package Learn.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

	/*
	 * 102. Binary Tree Level Order (Medium)
	 * 
	 * https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/931
	 * 
	 * solution: https://leetcode.com/problems/binary-tree-level-order-traversal/solution/
	 * 
	 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
	 * For example:
	 * Given binary tree [3,9,20,null,null,15,7],
	 *   3
   		/ \
  	   9  20
         /  \
        15   7
	 * 
	 * return its level order traversal as:
	 * [
  		[3],
  		[9,20],
  		[15,7]
	   ]
	   
	   Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Level Order Traversal.
	   Memory Usage: 39.3 MB, less than 44.43% of Java online submissions for Binary Tree Level Order Traversal.
	   
	   Time complexity: O(N)
	   Space complexity: O(N)
	   
	 */

	class TreeNode{
		
		int val ;
		TreeNode left ;
		TreeNode right ;
		
		public TreeNode(int val){
			this.val = val ;
		}
		
	}
	
	private List<Integer> list ;
    private List<List<Integer>> res = new ArrayList<>() ;
    private Queue<TreeNode> queue = new LinkedList<>() ;
    
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null) return res ;
        
        queue.add(root) ;
        while(!queue.isEmpty()){
            
            list = new ArrayList<>() ;
            int cnt = queue.size() ;
            for(int i=0; i<cnt; i++){
                TreeNode curr = queue.poll() ;
                list.add(curr.val) ;
                
                if(curr.left != null){
                    queue.add(curr.left) ;   
                }
            
                if(curr.right != null){
                    queue.add(curr.right) ;
                }
                
            }   
                
            res.add(list) ;
        }
        
        return res ;
        
    }

}
