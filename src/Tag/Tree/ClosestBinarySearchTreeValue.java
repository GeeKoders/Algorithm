package Tag.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ClosestBinarySearchTreeValue {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}

	}

	/*
	 * 270. Closest Binary Search Tree Value (Easy)
	 * 
	 * https://leetcode.com/problems/closest-binary-search-tree-value/
	 * 
	 * https://leetcode.com/problems/closest-binary-search-tree-value/solution/
	 * 
	 * Memory Limit Exceeded
	 * 
	 */
	public int closestValue(TreeNode root, double target) {

		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(root);

		int res = root.val;
		double diff = Double.MAX_VALUE;

		while (!queue.isEmpty()) {

			int n = queue.size();

			TreeNode cur = queue.poll();

			if (Math.abs(cur.val - target) < diff) {
				diff = Math.abs(cur.val - target);
				res = cur.val;
			}

			for (int i = 0; i < n; i++) {

				if (cur.left != null) {
					queue.add(cur.left);
				}

				if (cur.right != null) {
					queue.add(cur.right);
				}

			}

		}
		return res;

	}
	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Closest Binary Search Tree Value.
	 * Memory Usage: 38.8 MB, less than 74.69% of Java online submissions for Closest Binary Search Tree Value.
	 * 
	 * Time complexity: O(H)
	 * Space complexity: O(1)
	 * 
	 */
	public int closestValue2(TreeNode root, double target) {
		
		int res = root.val;   
	    while(root != null){
	        if(Math.abs(target - root.val) < Math.abs(target - res)){
	            res = root.val;
	        }      
	        root = root.val > target? root.left: root.right;
	    }     
	    return res;
		
	}
}
