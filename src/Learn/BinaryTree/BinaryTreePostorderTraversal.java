package Learn.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {

	/*
	 * 145. Binary Tree Postorder Traversal (Medium)
	 * 
	 * https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/930/
	 * 
	 * solution: https://leetcode.com/problems/binary-tree-postorder-traversal/solution/
	 * 
	 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
	 * 
	 * Follow up: Recursive solution is trivial, could you do it iteratively?
	 * 
	 * Example 1:
	 * Input: root = [1,null,2,3]
	 * Output: [3,2,1]
	 * 
	 * Example 2:
	 * Input: root = []
	 * Output: []
	 * 
	 * Example 3:
	 * Input: root = [1]
	 * Output: [1]
	 * 
	 * Example 4:
	 * Input: root = [1,2]
	 * Output: [2,1]
	 * 
	 * Example 5:
	 * Input: root = [1,null,2]
	 * Output: [2,1]
	 * 
	 * Constraints:
	 * The number of the nodes in the tree is in the range [0, 100].
	 * -100 <= Node.val <= 100
	 * 
	 */

	class TreeNode{
		
		int val ;
		TreeNode left ;
		TreeNode right ;
		public TreeNode(int val){
			this.val = val ;
		}
		
	}
	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Postorder Traversal.
	 * Memory Usage: 37.3 MB, less than 48.81% of Java online submissions for Binary Tree Postorder Traversal.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 */
	private List<Integer> res ;
    
    public List<Integer> postorderTraversal(TreeNode root) {
        res = new ArrayList<>() ;
        traversal(root) ;
        return res ;
        
    }
    
    public void traversal(TreeNode curr){
        
        if(curr == null) return ;
        
        traversal(curr.left) ;
        traversal(curr.right) ;
        res.add(curr.val) ;
        
    }

}
