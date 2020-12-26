package BinarySearchTree;

public class DeleteNodeInBST {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	/*
	 * https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/141/basic-operations-in-a-bst/1006/
	 * 
	 * solution: https://leetcode.com/problems/delete-node-in-a-bst/solution/
	 *
	 *
	 * 91 / 91 test cases passed.
	   Status: Accepted
	   Runtime: 2 ms faster than 100.00% of Java online submissions for Delete Node in a BST.
	   Memory Usage: 39.3 MB, less than 71.80% of Java online submissions for Delete Node in a BST.
	 *
	 */
	
	public static void main(String[] args) {
		
	}

	public TreeNode deleteNode(TreeNode root, int key) {

		if (root == null)
			return null;

		return delete(root, key);

	}

	private TreeNode delete(TreeNode root, int key) {

		if (root == null)
			return null;

		TreeNode curr = root;

		if (key < curr.val) {
			curr.left = delete(curr.left, key);
		} else if (key > curr.val) {
			curr.right = delete(curr.right, key);
		} else {

			if (curr.left == null && curr.right == null) {
				System.out.println("Removing a leaf node...");
				return null;
			}
			// update the reference
			if (curr.left == null) {
				System.out.println("Removing the right child...");
				TreeNode temp = curr.right;
				curr = null;
				return temp;
			} else if (curr.right == null) {
				System.out.println("Removing the left child...");
				TreeNode temp = curr.left;
				curr = null;
				return temp;
			}

			// this is the node with two children case !!!
			System.out.println("Removing item with two children...");
			TreeNode temp = getPredecessor(curr.left);
			curr.val = temp.val;
			curr.left = delete(curr.left, temp.val);

		}
		return curr;
	}

	private TreeNode getPredecessor(TreeNode root) {

		if (root == null)
			return null;

		TreeNode curr = root;

		while(curr.right != null){
			curr = curr.right ;
		}

		return curr;

	}

}
