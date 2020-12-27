package BinarySearchTree;

public class KthLargest {
	class Node {

		public int val;
		public Node left;
		public Node right;
		public int cnt ;

		public Node(int val, int cnt) {
			this.val = val;
			this.cnt = cnt ;
		}

	}
	
	/*
	 * https://leetcode.com/submissions/detail/434987315/?from=explore&item_id=1018
	 * 
	 * 10 / 10 test cases passed.
	   Status: Accepted
	   Runtime: 273 ms
	   Memory Usage: 50.5 MB
	 * 
	 */

	public static void main(String[] args) {

		int k = 3;
		int[] nums = { 4, 5, 8, 2 };

		KthLargest obj = new KthLargest(k, nums);
		System.out.println(obj.add(3)); // return 4
		System.out.println(obj.add(5)); // return 5
		System.out.println(obj.add(10)); // return 5
		System.out.println(obj.add(9)); // return 8
		System.out.println(obj.add(4)); // return 8
	}

	private Node root;
	private int m_k;;

	private Node insertNode(Node root, int num) {
		if (root == null) {
			return new Node(num, 1);
		}
		if (root.val < num) {
			root.right = insertNode(root.right, num);
		} else {
			root.left = insertNode(root.left, num);
		}
		root.cnt++;
		return root;
	}

	private int searchKth(Node root, int k) {
		// m = the size of right subtree
		int m = root.right != null ? root.right.cnt : 0;
		// root is the m+1 largest node in the BST
		if (k == m + 1) {
			return root.val;
		}
		if (k <= m) {
			// find kth largest in the right subtree
			return searchKth(root.right, k);
		} else {
			// find (k-m-1)th largest in the left subtree
			return searchKth(root.left, k - m - 1);
		}
	}

	public KthLargest(int k, int[] nums) {
		root = null;
		for (int i = 0; i < nums.length; ++i) {
			root = insertNode(root, nums[i]);
		}
		m_k = k;
	}

	public int add(int val) {
		root = insertNode(root, val);
		return searchKth(root, m_k);
	}

}
