package Tag.Array;

public class TwoSum {

	
	/*
	 * 1. Two Sum (Easy)
	 * 
	 * https://leetcode.com/problems/two-sum/
	 * 
	 * soltuion: https://leetcode.com/problems/two-sum/solution/
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Sum.
	   Memory Usage: 39.4 MB, less than 35.62% of Java online submissions for Two Sum.
	 * 
	 * Time complexity: O(N^2)
	 * Space complexity: O(1)
	 * 
	 */
	public int[] twoSum(int[] nums, int target) {
        
        int[] res = new int[2] ;
        
        for(int i=0; i<nums.length; i++){
            for(int j= i+1; j<nums.length; j++){
                        
                if(nums[i] + nums[j] == target){
                    return new int[]{i , j} ;
                }
            }
        }
        
        return res ;
    }
}
