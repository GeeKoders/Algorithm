package Tag.Tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementinaBST {

	class TreeNode{
		int val ;
		TreeNode left ;
		TreeNode right ;
		public TreeNode(int val){
			this.val = val ;
		}
	}
	/*
	 * 230. Kth Smallest Element in a BST (Medium)
	 * 
	 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
	 * 
	 * solution: https://leetcode.com/problems/kth-smallest-element-in-a-bst/solution/
	 * 
	 * Runtime: 1 ms, faster than 37.10% of Java online submissions for Kth Smallest Element in a BST.
	 * Memory Usage: 39.7 MB, less than 23.79% of Java online submissions for Kth Smallest Element in a BST.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 * 
	 */
	public int kthSmallest(TreeNode root, int k) {
        if (root == null)
			return -1;

		List<Integer> list = new ArrayList<>();

		helper(root, k, list);
		return list.get(k-1) ;
    }
    
    private void helper(TreeNode root, int k, List<Integer> list) {

		if (root.left != null)
			helper(root.left, k, list);
		list.add(root.val);
		if (root.right != null)
			helper(root.right, k, list);

	}
}
