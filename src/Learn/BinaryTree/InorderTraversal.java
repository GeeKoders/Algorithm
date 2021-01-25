package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

	//reference : https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/930/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if (root==null) return res;

        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;

        while(curr!=null || !stack.isEmpty()){
            while (curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            curr=stack.pop();
            res.add(curr.val);
            curr=curr.right;
        }
        return res;
    }


}
