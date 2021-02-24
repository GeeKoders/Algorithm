package Learn.recursionII;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class SameTree {

	class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

	}

	/*
	 * 100. Same Tree(Easy)
	 * 
	 * https://leetcode.com/explore/learn/card/recursion-ii/503/recursion-to-iteration/2894/
	 * 
	 * solution: https://leetcode.com/problems/same-tree/solution/
	 * 
	 * solution: https://leetcode.com/problems/same-tree/solution/
	 * Memory Usage: 36.6 MB, less than 28.67% of Java online submissions for Same Tree.
	 *
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
	 *  
	 * Time complexity: O(N)
	 * Space complexity: O(logN), the worst case is O(N)
	 * 
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {

		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		if (p.val != q.val)
			return false;

		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	// iterative
	public boolean check(TreeNode p, TreeNode q) {
		// p and q are null
		if (p == null && q == null)
			return true;
		// one of p and q is null
		if (q == null || p == null)
			return false;
		if (p.val != q.val)
			return false;
		return true;
	}

	public boolean isSameTree2(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (!check(p, q))
			return false;
		// init deques
		ArrayDeque<TreeNode> deqP = new ArrayDeque<TreeNode>();
		ArrayDeque<TreeNode> deqQ = new ArrayDeque<TreeNode>();
		deqP.addLast(p);
		deqQ.addLast(q);

		while (!deqP.isEmpty()) {
			p = deqP.removeFirst();
			q = deqQ.removeFirst();

			if (!check(p, q))
				return false;
			if (p != null) {
				// in Java nulls are not allowed in Deque
				if (!check(p.left, q.left))
					return false;
				if (p.left != null) {
					deqP.addLast(p.left);
					deqQ.addLast(q.left);
				}
				if (!check(p.right, q.right))
					return false;
				if (p.right != null) {
					deqP.addLast(p.right);
					deqQ.addLast(q.right);
				}
			}
		}
		return true;
	}
	
	//easy to understand
	/*
	 * 
		60 / 60 test cases passed.
		Status: Accepted
		Runtime: 0 ms (Your memory usage beats 24.57 % of java submissions.)
		Memory Usage: 36.7 MB
	 * 
	 */
	public boolean isSameTree3(TreeNode p, TreeNode q) {
		
		Queue<TreeNode> queue = new LinkedList<>();
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p != null && q != null) {
            queue.offer(p);
            queue.offer(q);
        }
        while (!queue.isEmpty()) {
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();
            if (first == null && second == null)
                continue;
            if (first == null || second == null)
                return false;
            if (first.val != second.val)
                return false;
            queue.offer(first.left);
            queue.offer(second.left);
            queue.offer(first.right);
            queue.offer(second.right);
        }
        return true;
    }

}
