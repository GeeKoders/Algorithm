package Nary;

import java.util.List;

public class MaximumDepthofNary {

	class Node{
		
		public List<Node> children ;
		public int val ;
		
		public Node(int val){
			this.val = val ;
		}
		
	}
	
	/*
	 * https://leetcode.com/explore/learn/card/n-ary-tree/131/recursion/919/
	 * 
	 * solution: https://leetcode.com/problems/maximum-depth-of-n-ary-tree/solution/
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 * 
		37 / 37 test cases passed.
		Status: Accepted
		Runtime: 0 ms (Your runtime beats 100.00 % of java submissions.)
		Memory Usage: 38.7 MB
	 * 
	 */
	public static void main(String[] args) {
		
	}
	
	int max = 0;
    
    public int maxDepth(Node root) {
        
       helper(root, 0) ;
       return max ;
        
    }
    
    private void helper(Node root, int depth){
        
        if(root == null) return ;
        
        max = Math.max(max, depth + 1) ;
        
        for(Node child: root.children){
            helper(child, depth + 1) ;
        }
    
        
    }
}
