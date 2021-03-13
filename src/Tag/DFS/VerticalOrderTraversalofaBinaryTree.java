package Tag.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class VerticalOrderTraversalofaBinaryTree {
	
	class TreeNode{
		int val; 
		TreeNode left ;
		TreeNode right ;
		public TreeNode(int val){
			this.val = val ;
		}
		
	}
	/*
	 * 987. Vertical Order Traversal of a Binary Tree (Hard)
	 * 
	 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
	 * 
	 * solution: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=gWbUowYpddQ&ab_channel=AndroidBabies%E5%AE%89%E5%8D%93%E5%A4%A7%E5%AE%9D%E8%B4%9D%E4%BB%AC
	 * 
	 * Runtime: 3 ms, faster than 76.21% of Java online submissions for Vertical Order Traversal of a Binary Tree.
	 * Memory Usage: 39 MB, less than 80.45% of Java online submissions for Vertical Order Traversal of a Binary Tree.
	 * 
	 * Time complexitY: O(NlogN)
	 * Space complexity: O(N)
	 * 
	 * 
	 */
	public List<List<Integer>> verticalTraversal(TreeNode root) {

		TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

		List<List<Integer>> res = new ArrayList<>();

		dfs(root, 0, 0, map);

		for (TreeMap<Integer, PriorityQueue<Integer>> y : map.values()) {
			res.add(new ArrayList<>());
			for (PriorityQueue<Integer> nodes : y.values()) {

				while (!nodes.isEmpty()) {

					res.get(res.size() - 1).add(nodes.poll());

				}

			}

		}

		return res;

	}

	private void dfs(TreeNode root, int x, int y,
			TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {

		if (root == null)
			return;

		if (!map.containsKey(x)) {
			map.put(x, new TreeMap<>());
		}

		if (!map.get(x).containsKey(y)) {
			map.get(x).put(y, new PriorityQueue<>());
		}

		map.get(x).get(y).offer(root.val);

		dfs(root.left, x - 1, y + 1, map);
		dfs(root.right, x + 1, y + 1, map);
	}
}
