package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraverse {

	//reference: https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/930/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            list.add(0,curr.val);
            if(curr.left!=null) {
              stack.push(curr.left);
            }
            if(curr.right!=null) {
               stack.push(curr.right); 
            }
        }
        return list;
    }

	
}
