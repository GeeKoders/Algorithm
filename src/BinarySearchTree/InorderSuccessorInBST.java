package BinarySearchTree;

public class InorderSuccessorInBST {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}

	public static void main(String[] args) {

	}

	/*
	 * https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/140/introduction-to-a-bst/998/
	 * 
	 * Youtube: https://www.youtube.com/watch?v=psFKTGahpCs&ab_channel=HaomengZhang
	 * 
	 * For those of you who cannot enjoy fancy code, here is my version with
	 * explanation. The key idea is that (1) if p node has a right subtree,
	 * successor would be the smallest note in p's right subtree (in a BST, it
	 * is just the leftmost node); (2) if p doesn't have a right subtree, it is
	 * the last node whose left subtree it is are under (this can be done
	 * through standard BST search and record its last right parent).
	 *
	 */

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

		if (root == null)
			return null;

		TreeNode pre = null;
		// case 1:
		// pre is used to save the last node whose left substree
		while (root.val != p.val) {

			if (p.val < root.val) {
				pre = root;
				root = root.left;
			} else if (p.val > root.val) {
				root = root.right;
			}
		}

		if (root.right == null) {
			return pre;
		} else {
			return getLeftMost(root.right);
		}

	}

	private TreeNode getLeftMost(TreeNode root) {

		if (root == null) return null;
			
		while(root.left != null){
			root = root.left ;
		}
		
		return root ;
		
	}

}
