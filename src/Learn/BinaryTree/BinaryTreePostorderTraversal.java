package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {

	/*
	 * https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/930/
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
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
