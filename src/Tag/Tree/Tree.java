package Tag.Tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {

	class TreeNode{
		int val ;
		TreeNode left ;
		TreeNode right ;
		public TreeNode(int val){
			this.val = val ;
		}
	}
	
	public static void main(String[] args) {
		
	}
	
	private void Traversal(TreeNode root){
		
		if(root == null) return ;

		List<Integer> res = new ArrayList<>() ;
		
		inOrderTraversal(root, res) ;
		preOrderTraversal(root, res) ;
		postOrderTraversal(root, res) ;
		
		
	}
	
	private void inOrderTraversal(TreeNode root, List<Integer> res){
		
		if(root.left != null) inOrderTraversal(root.left, res) ;
		
		res.add(root.val) ;
		
		if(root.right != null) inOrderTraversal(root.right, res) ;
		
		
	}
	
	private void preOrderTraversal(TreeNode root, List<Integer> res){

		res.add(root.val) ;
		
		if(root.left != null) inOrderTraversal(root.left, res) ;
		
		if(root.right != null) inOrderTraversal(root.right, res) ;
	}
	
	private void postOrderTraversal(TreeNode root, List<Integer> res){

		if(root.left != null) inOrderTraversal(root.left, res) ;
		
		if(root.right != null) inOrderTraversal(root.right, res) ;
		
		res.add(root.val) ;
	}
	
}
