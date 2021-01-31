package Tag.Array;

import java.util.HashMap;
import java.util.Map;

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
	/*
	 * HashTable
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Sum.
	 * Memory Usage: 40.4 MB, less than 12.00% of Java online submissions for Two Sum.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 * 
	 */
	public int[] twoSum2(int[] nums, int target) {
        
        int [] res = new int[2] ;
        
        if(nums == null || nums.length < 1){
            return res ;
        }
        
        Map<Integer, Integer> map = new HashMap() ;
        
        for(int i=0; i<nums.length; i++){
            
            int complement = target - nums[i] ;
            
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i} ;
            }
            
            map.put(nums[i], i) ;
        }
        
        return res ;
    }
}
