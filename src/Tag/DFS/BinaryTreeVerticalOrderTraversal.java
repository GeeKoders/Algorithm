package Tag.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class BinaryTreeVerticalOrderTraversal {
	
	
	/*
	 * 314. Binary Tree Vertical Order Traversal (Medium)
	 * 
	 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/
	 * 
	 * solution: https://leetcode.com/problems/binary-tree-vertical-order-traversal/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=J5YnIxbG3hw&ab_channel=happygirlzt
	 * 
	 * Runtime: 3 ms, faster than 56.42% of Java online submissions for Binary Tree Vertical Order Traversal.
	 * Memory Usage: 39.4 MB, less than 36.64% of Java online submissions for Binary Tree Vertical Order Traversal.
	 * 
	 * Time complexity: O(NlogN)
	 * Space complexity: O(N)
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
	
	class Node {
		TreeNode root;
		int hd;

		public Node(TreeNode root, int hd) {
			this.root = root;
			this.hd = hd;
		}
	}

	public List<List<Integer>> verticalOrder(TreeNode root) {
		TreeMap<Integer, List<Integer>> map = new TreeMap<>();
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(root, 0));

		while (!q.isEmpty()) {
			Node cur = q.poll();
			map.putIfAbsent(cur.hd, new ArrayList<>());
			map.get(cur.hd).add(cur.root.val);

			if (cur.root.left != null) {
				q.offer(new Node(cur.root.left, cur.hd - 1));
			}

			if (cur.root.right != null) {
				q.offer(new Node(cur.root.right, cur.hd + 1));
			}
		}

		for (List<Integer> value : map.values()) {
			res.add(value);
		}

		return res;
	}
}
