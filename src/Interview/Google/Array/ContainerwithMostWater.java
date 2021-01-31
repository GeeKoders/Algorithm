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
	
	/*
	 * Your runtime beats 45.14 % of java submissions.
	 * Your memory usage beats 8.72 % of java submissions.
	 * 
	 * Two pointer
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(1)
	 * 
	 */
	public int maxArea2(int[] height) {
        
		int res = -1 ;
        
        if(height == null || height.length < 2) return res ;
        
        int n = height.length ;
        
        int left = 0 ; 
        int right = n - 1  ;
        
        while(left < right){
            
            
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left)) ;
            
            if(height[left] < height[right]){
                left ++ ;
            }else{
                right -- ;
            }
            
            
        }
        
        return res ;
        
    }
	
}
