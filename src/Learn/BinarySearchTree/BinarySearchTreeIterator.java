package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
	 * 173. Binary Search Tree Iterator (Medium)
	 * 
	 * https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/140/introduction-to-a-bst/1008/
	 * 
	 * solution: https://leetcode.com/problems/binary-search-tree-iterator/solution/
	 *
	 * Runtime: 14 ms, faster than 99.38% of Java online submissions for Binary Search Tree Iterator.
	 * Memory Usage: 42.6 MB, less than 75.65% of Java online submissions for Binary Search Tree Iterator.
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
    
    /*
     * Time complexity: refer to the solution
     * Space complexity: O(N)
     * 
     */
    Stack<TreeNode> stack;

    public void BSTIterator2(TreeNode root) {

        // Stack for the recursion simulation
        this.stack = new Stack<TreeNode>();

        // Remember that the algorithm starts with a call to the helper function
        // with the root node as the input
        this._leftmostInorder(root);
    }

    private void _leftmostInorder(TreeNode root) {

        // For a given node, add all the elements in the leftmost branch of the tree
        // under it to the stack.
        while (root != null) {
            this.stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next2() {
        // Node at the top of the stack is the next smallest element
        TreeNode topmostNode = this.stack.pop();

        // Need to maintain the invariant. If the node has a right child, call the
        // helper function for the right child
        if (topmostNode.right != null) {
            this._leftmostInorder(topmostNode.right);
        }

        return topmostNode.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext2() {
        return this.stack.size() > 0;
    }

}
