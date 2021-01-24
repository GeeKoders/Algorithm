package recursionII;

import java.util.Stack;

public class LargestRectangleinHistogram {

	/*
	 * 84. Largest Rectangle in Histogram(Hard)
	 * 
	 * https://leetcode.com/explore/learn/card/recursion-ii/507/beyond-recursion/2901/
	 * 
	 * solution: https://leetcode.com/problems/largest-rectangle-in-histogram/solution/
	 * 
	 * reference
	 * 
	 * https://www.youtube.com/watch?v=GYuBQacXr1A&feature=youtu.be&ab_channel=happygirlzt
	 * 
	 *  96 / 96 test cases passed.
		Status: Accepted
		Runtime: 16 ms (Your runtime beats 40.42 % of java submissions.)
		Memory Usage: 52.3 MB (Your memory usage beats 8.00 % of java submissions.)
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 * 
	 */
	public int largestRectangleArea(int[] heights) {
        int n = heights.length ;
        Stack<Integer> stack = new Stack() ;
        stack.push(-1) ;
        int max = 0 ;
        for(int i=0; i<n; i++){
            
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]){
                max = Math.max(max, heights[stack.pop()] * i - stack.peek() - 1) ;
                stack.push(i) ;            
                
            }
        }
        
        while(stack.peek() != -1){
            max = Math.max(max, heights[stack.pop()] * (n - stack.peek() - 1)) ;
        }
        
        return max ;
        
    }
	
}
