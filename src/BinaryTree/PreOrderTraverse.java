package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraverse {

	//reference: https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/930/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            list.add(current.val);
            if(current.right!=null) {
               stack.push(current.right);
            }
            if(current.left!=null) {
              stack.push(current.left);
            }
        }
        return list;
    }

	
}
