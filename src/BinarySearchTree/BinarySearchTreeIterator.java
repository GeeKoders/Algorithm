package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator {

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
	 * https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/140/introduction-to-a-bst/1008/
	 * 
	 * solution: https://leetcode.com/problems/binary-search-tree-iterator/solution/
	 *
	 */
	
	public static void main(String[] args) {
//		BinarySearchTreeIterator obj = new BinarySearchTreeIterator(root);
//		int param_1 = obj.next();
//		boolean param_2 = obj.hasNext();
	}
	
	private List<Integer> list ;
    
    private int index ;
 
    public BinarySearchTreeIterator(TreeNode root) {
        
        list = new ArrayList<>() ;
        
        index = -1 ;
        
        inorder(root) ;        
        
    }
    // time complexity: O(N)
    // space complexity: O(N)
    private void inorder(TreeNode root){
        
        if (root == null) return ;
        
        inorder(root.left) ;
        list.add(root.val) ;
        inorder(root.right) ;
        
        
    }
    // O(1)
    public int next() {
        return list.get(++index) ;
    }
    // O(1)
    public boolean hasNext() {
        return index+1 < list.size() ;
    }

}
