package Learn.BinaryTree;

public class MinimumDepthofBinaryTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}

	}
	/*
	 * Minimum Depth of Binary Tree (Easy)
	 * 
	 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
	 * 
	 * https://leetcode.com/problems/minimum-depth-of-binary-tree/solution/
	 * 
	 * Runtime: 4 ms, faster than 72.35% of Java online submissions for Minimum Depth of Binary Tree.
	 * Memory Usage: 60.1 MB, less than 57.08% of Java online submissions for Minimum Depth of Binary Tree.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 */
	public int minDepth(TreeNode root) {

		if (root == null)
			return 0;
		if (root.left == null && root.right == null) {
			return 1;
		}

		int res = Integer.MAX_VALUE;

		if (root.left != null) {
			res = Math.min(res, minDepth(root.left));
		}

		if (root.right != null) {
			res = Math.min(res, minDepth(root.right));
		}

		return res + 1;

	}
	
	
	/*
	 * Runtime: 66 ms, faster than 5.01% of Java online submissions for Minimum Depth of Binary Tree.
	 * Memory Usage: 59.7 MB, less than 74.60% of Java online submissions for Minimum Depth of Binary Tree.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 */
	int res = Integer.MAX_VALUE ;
    public int minDepth2(TreeNode root) {
        
        if(root == null) return 0 ;
        if(root.left == null && root.right == null){
            return 1 ;
        }
        dfs(root, 1) ;
        
        return res ; 
        
    }
    
    private void dfs(TreeNode root, int cur){
        
        if(root.left == null && root.right == null){
            res = Math.min(res, cur) ;
            System.out.println("res:" + res) ;
            return ;   
        }
        
        if(root.left != null){
            dfs(root.left, cur + 1) ;
        }
        
        if(root.right != null){
            dfs(root.right, cur + 1) ;
        }
    }

}
