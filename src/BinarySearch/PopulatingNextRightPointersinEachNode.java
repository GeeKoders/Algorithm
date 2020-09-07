package BinarySearch;

public class PopulatingNextRightPointersinEachNode {

	
	/*
	 * https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/994
	 * 
	 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
	 * 
	 * 		struct Node {
			  int val;
			  Node *left;
			  Node *right;
			  Node *next;
			}	
			
	 *  Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
	 *  Initially, all next pointers are set to NULL.
	 *  
	 *  Follow up:	
	 *  You may only use constant extra space.
	 *  Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.	
	 *
	 *  Input: root = [1,2,3,4,5,6,7]
	 *	Output: [1,#,2,3,#,4,5,6,7,#]
	 *  Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
	 *
	 *	Constraints:
	 *  The number of nodes in the given tree is less than 4096.
	 *  -1000 <= node.val <= 1000
	 *  
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Time Limit Exceeded
	public Node connect(Node root) {

		while (root != null && root.left != null) {
			Node cur = root;
			while (cur != null) {
				cur.left.next = cur.right;
				if (cur.right != null && cur.next != null) {
					cur.right.next = cur.next.left;
				}
				cur = cur.next;
			}
		}
		root = root.left;

		return root;
	}

}

class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
};