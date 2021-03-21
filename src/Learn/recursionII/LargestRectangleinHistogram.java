package Learn.recursionII;

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
	
	/*
	 * 
	 * reference: https://www.youtube.com/watch?v=KkJrGxuQtYo&ab_channel=basketwangCoding
	 * 
	 * Runtime: 29 ms, faster than 39.63% of Java online submissions for Largest Rectangle in Histogram.
	 * Memory Usage: 50.3 MB, less than 23.89% of Java online submissions for Largest Rectangle in Histogram.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 */
	 public int largestRectangleArea2(int[] heights) {
	       if(heights == null || heights.length == 0) return 0 ;
	        int max = 0 ;
	        Stack<Integer> stack = new Stack<>() ;
	        
	        for(int curr=0; curr<heights.length; curr++){

	            if(stack.isEmpty() || heights[curr] >= heights[stack.peek()]){
	                stack.push(curr) ;
	            }else{
	                
	                int right = curr ;
	                int index = stack.pop() ;
	                
	                while(!stack.isEmpty() && heights[index] == heights[stack.peek()]){
	                    index = stack.pop() ;
	                }
	                
	                int leftMost = (stack.isEmpty())? -1: stack.peek() ;
	                
	                max = Math.max(max, (right - leftMost - 1) * heights[index]) ;
	                
	                curr -- ;
	                
	            }
	            
	        }
	        
	        int rightMost = stack.peek() + 1 ;
	        while(!stack.isEmpty()){
	            
	            int index = stack.pop() ;
	            int left = (stack.isEmpty()) ? -1 : stack.peek() ;
	            max = Math.max(max, (rightMost - left - 1) * heights[index]) ;
	            
	        }
	        
	        return max ;
	        
	    }	
	
}
