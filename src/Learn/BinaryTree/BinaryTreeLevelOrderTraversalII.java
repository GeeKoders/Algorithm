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
}
