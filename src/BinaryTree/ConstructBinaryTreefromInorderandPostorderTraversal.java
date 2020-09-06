package BinaryTree;

public class ConstructBinaryTreefromInorderandPostorderTraversal {

	/*
	 * Given preorder and inorder traversal of a tree, construct the binary tree.
	 * 
	 * Note:
	 * You may assume that duplicates do not exist in the tree.
	 * 
	 * For example, given
	 * preorder = [3,9,20,15,7]
	 * inorder = [9,3,15,20,7]
	 * 
	 * Return the following binary tree:
	 * 
	 *             3
   				  / \
                 9  20
                   /  \
                  15   7   
	 * 
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder) ;
    }
	
	
	//reference: https://www.youtube.com/watch?v=GeltTz3Z1rw&ab_channel=NickWhite
	/*
	 * Our aim is to find out the index of right child for current node in the preorder array
	 * 
	 * We know the index of current node in the preorder array - preStart (or whatever your call it), it's the root of a subtree
	 * 
	 * Remember pre order traversal always visut all the node on left branch before going to the right (root -> left -> ... -> right), therefore, we can get the immediate right child index by
	 * skipping all the node on the left branches/subtrees of current node
	 * 
	 * The inorder array has this information eactly. Remember when we found the root in "inorder" array we immediately know how many nodes are on the left subtree and how many
	 * are on the right subtree
	 * 
	 * Therefore the immediate right child index is preStart + numsOnleft + 1 (remember in preorder traversal array root is always ahead of children nodes but you don't know which one is 
	 * the left child which one is the right, and this is why we need inorder array)
	 * 
	 * numsOnLeft = root - inStart
	 * 
	 */
	public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int []inorder){
		
		if(preStart > preorder.length - 1 || inStart > inEnd){
			return null ;
		}
		
		TreeNode root = new TreeNode(preorder[preStart]) ;
		
		int inIndex = 0 ;
		for(int i=inStart; i<=inEnd; i++){
			if(root.val == inorder[i]){
				inIndex = i ;
			}
		}
		
		
		root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder) ;
		root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder) ;
		
		return root ;
		
	}
	

}
