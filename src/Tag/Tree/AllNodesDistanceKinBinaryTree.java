package Tag.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class AllNodesDistanceKinBinaryTree {

	class TreeNode{
		int val ;
		TreeNode left ;
		TreeNode right ;
		public TreeNode(int val){
			this.val = val ;
		}
	}
	/*
	 * 863. All Nodes Distance K in Binary Tree (Medium)
	 * 
	 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
	 * 
	 * solution: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/solution/
	 * 
	 * reference: 
	 * 
	 * https://www.youtube.com/watch?v=o1siL8eKCos&t=746s&ab_channel=HuaHua
	 * 
	 * Runtime: 15 ms, faster than 50.80% of Java online submissions for All Nodes Distance K in Binary Tree.
	 * Memory Usage: 39.5 MB, less than 16.45% of Java online submissions for All Nodes Distance K in Binary Tree.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 */
	Map<TreeNode, TreeNode> parent;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parent = new HashMap();
        dfs(root, null);

        Queue<TreeNode> queue = new LinkedList();
        queue.add(null);
        queue.add(target);

        Set<TreeNode> seen = new HashSet();
        seen.add(target);
        seen.add(null);

        int dist = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (dist == K) {
                    List<Integer> ans = new ArrayList();
                    for (TreeNode n: queue)
                        ans.add(n.val);
                    return ans;
                }
                queue.offer(null);
                dist++;
            } else {
                if (!seen.contains(node.left)) {
                    seen.add(node.left);
                    queue.offer(node.left);
                }
                if (!seen.contains(node.right)) {
                    seen.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode par = parent.get(node);
                if (!seen.contains(par)) {
                    seen.add(par);
                    queue.offer(par);
                }
            }
        }

        return new ArrayList<Integer>();
    }

    public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            parent.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
	
}
