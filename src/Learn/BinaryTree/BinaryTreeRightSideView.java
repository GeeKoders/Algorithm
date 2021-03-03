package Learn.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

	class TreeNode{
		int val ;
		TreeNode left ;
		TreeNode right ;
		
		public TreeNode(int val){
			this.val = val ;
		}
	}
	/*
	 * 199. Binary Tree Right Side View (Medium)
	 * 
	 * https://leetcode.com/problems/binary-tree-right-side-view/
	 * 
	 * solution: https://leetcode.com/problems/binary-tree-right-side-view/solution/
	 * 
	 * Runtime: 1 ms, faster than 77.90% of Java online submissions for Binary Tree Right Side View.
	 * Memory Usage: 37.6 MB, less than 74.26% of Java online submissions for Binary Tree Right Side View.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(H)
	 * 
	 */
	public List<Integer> rightSideView(TreeNode root) {
        
        if (root == null) return new ArrayList<Integer>();
        
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.add(root) ;
        
        List<Integer> res = new ArrayList();
        
        while (!queue.isEmpty()) {
            int n = queue.size();

            for(int i = 0; i < n; ++i) {
                TreeNode node = queue.poll();
                // if it's the rightmost element
                if (i == n - 1) {
                    res.add(node.val);    
                }

                // add child nodes in the queue
                if (node.left != null) {
                    queue.offer(node.left);    
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
        
        
    }
	
}
