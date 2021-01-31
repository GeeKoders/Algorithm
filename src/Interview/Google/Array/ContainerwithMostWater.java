package Interview.Google.Array;

public class ContainerwithMostWater {
	
	
	/*
	 * 11. Container With Most Water(Medium)
	 * 
	 * https://leetcode.com/problems/container-with-most-water/
	 * 
	 * solution: https://leetcode.com/problems/container-with-most-water/solution/
	 * 
	 * Your runtime beats 14.96 % of java submissions.
	 * Your memory usage beats 34.30 % of java submissions.
	 * 
	 * Brute Force
	 * 
	 * Time complexity: O(N^2)
	 * Space complexity:O(1)
	 * 
	 */
	public int maxArea(int[] height) {
        
        int n = height.length ;
        int res = 0 ;
        for(int i = 0 ; i<n; i++){
            for(int j=i+1; j<n; j++){
                
                res = Math.max(res, Math.min(height[i], height[j]) * (j - i)) ;
            }
            
        }
        
        return res ;
        
    }
}
