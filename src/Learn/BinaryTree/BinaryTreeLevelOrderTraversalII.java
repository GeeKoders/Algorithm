package Learn.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
	
	
	class TreeNode{
		int val ;
		TreeNode left ;
		TreeNode right ;
		public TreeNode(int val){
			this.val = val ;
		}
		
		
	}
	
	/*
	 * 107. Binary Tree Level Order Traversal II (Medium)
	 * 
	 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
	 * 
	 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/solution/
	 * 
	 * Runtime: 1 ms, faster than 84.86% of Java online submissions for Binary Tree Level Order Traversal II.
	 * Memory Usage: 39.1 MB, less than 69.67% of Java online submissions for Binary Tree Level Order Traversal II.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 */
	
	private List<Integer> list;
	private List<List<Integer>> res = new ArrayList<>();
	private Queue<TreeNode> queue = new LinkedList<>();

	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		if (root == null)
			return res;

		queue.add(root);
		while (!queue.isEmpty()) {

			list = new ArrayList<>();
			int cnt = queue.size();
			for (int i = 0; i < cnt; i++) {
				TreeNode curr = queue.poll();
				list.add(curr.val);

				if (curr.left != null) {
					queue.add(curr.left);
				}

				if (curr.right != null) {
					queue.add(curr.right);
				}

			}

			res.add(list);
		}

		Collections.reverse(res);

		return res;

	}
	
	/*
	 * Runtime: 19 ms, faster than 8.22% of Java online submissions for Binary Tree Level Order Traversal II.
	 * Memory Usage: 40.2 MB, less than 9.97% of Java online submissions for Binary Tree Level Order Traversal II.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)	
	 * 
	 */
	private List<List<Integer>> res2 = new ArrayList<>() ;
    
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        
      
        if(root == null) return res2 ;
        
        helper(root, 0) ;
        
        Collections.reverse(res2) ;
        
        return res2 ;
        
    }
    
    private void helper(TreeNode root, int level){
        System.out.println("level:" + level) ;
        System.out.println("size():" + res.size()) ;
        if(res2.size() == level){
            res2.add(new ArrayList<>()) ;
        }
        
        res2.get(level).add(root.val) ;
        
        if(root.left != null) helper(root.left, level + 1) ;
        if(root.right != null) helper(root.right, level + 1) ;
        
    }
}
