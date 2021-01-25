package BinaryTree;

public class ConstructBinaryTreefromInorderandPostorderTraversal {

	
	/*
	 * Given inorder and postorder traversal of a tree, construct the binary tree.
	 * 
	 * Note:
	 * You may assume that duplicates do not exist in the tree.
	 * 
	 * For example, given
	 * inorder = [9,3,15,20,7]
	 * postorder = [9,15,7,20,3]
	 * 
	 * Return the following binary tree:
	 * 
	 *           3
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
	//reference: https://www.youtube.com/watch?v=s5XRtcud35E&ab_channel=Jenny%27slecturesCS%2FITNET%26JRF
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) { return null; }
        
        return helper(postorder, postorder.length - 1, inorder, 0, inorder.length - 1) ;
    }
    
	public TreeNode helper(int[] postorder, int postEnd, int[] inorder, int inStart, int inEnd){
		
		if(inStart > inEnd || postEnd < 0){
			return null ;
		}
		
		TreeNode root = new TreeNode(postorder[postEnd]) ;
		
		int inIndex = 0 ;
		for(int i=inStart; i<=inEnd; i++){
			if(root.val == inorder[i]){
				inIndex = i ;
                break ;
			}
		}
		
		 root.left = helper(postorder, postEnd - (inEnd - inIndex  + 1), inorder, inStart, inIndex - 1);
		 root.right = helper(postorder, postEnd - 1, inorder, inIndex + 1, inEnd);
            

		
		return root ;
		
	}

}
