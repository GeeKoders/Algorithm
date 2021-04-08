package Tag.Graph;

import java.util.Arrays;
import java.util.LinkedList;

public class SerializeandDeserializeBinaryTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	/*
	 * 297. Serialize and Deserialize Binary Tree (Hard)
	 * 
	 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
	 * 
	 * solution: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=1BbMhi2hxDM&ab_channel=happygirlzt
	 * 
	 * Runtime: 7 ms, faster than 91.29% of Java online submissions for Serialize and Deserialize Binary Tree.
	 * Memory Usage: 40.8 MB, less than 74.84% of Java online submissions for Serialize and Deserialize Binary Tree.
	 * 
	 */
	private void buildString(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("#,");
			return;
		}

		sb.append(root.val);
		sb.append(",");
		buildString(root.left, sb);
		buildString(root.right, sb);
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		buildString(root, sb);
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		LinkedList<String> strList = new LinkedList(Arrays.asList(data
				.split(",")));
		return buildTree(strList);
	}

	private TreeNode buildTree(LinkedList<String> strList) {

		String first = strList.removeFirst();
		if (first.equals("#"))
			return null;
		TreeNode root = new TreeNode(Integer.valueOf(first));
		root.left = buildTree(strList);
		root.right = buildTree(strList);

		return root;

	}
}
