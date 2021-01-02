package Nary;

import java.util.Collections;
import java.util.LinkedList;
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
    
    // approach 2
    /*
     * Time complexity: O(N)
     * Space complexity: best case is O(logN), worst case is O(N) 
     * 
     * 
     */
    public int maxDepth2(Node root) {
    	
    	if(root == null){
    		return 0 ; 
    	}else if(root.children.isEmpty()){
    		return 1 ; 
    	}else{
    		
    		List<Integer> heights = new LinkedList<>() ;
    		
    		for(Node item: root.children){
    			heights.add(maxDepth2(item)) ;
    		}
    		
    		return Collections.max(heights) ;
    	}
    	
    }
    
    
}
