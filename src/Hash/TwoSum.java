package Hash;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	/*
	 * https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1115/
	 * solution: https://leetcode.com/problems/two-sum/solution/
	 * 
	 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
	 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
	 * 
	 * Example:
	 * Given nums = [2, 7, 11, 15], target = 9,
	 * 
	 * Because nums[0] + nums[1] = 2 + 7 = 9,
	 * return [0, 1].
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// your runtime beats 5.08% of java submissions
	public int[] twoSum(int[] nums, int target) {
        
        for(int i=0; i<nums.length; i++){
            
            for(int j=i+1; j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j} ;
                }               
            }
        }
        
        return new int[]{} ;
    }
	// time exceed limits
	public int[] twoSum2(int[] nums, int target) {
        
        Map<Integer, Integer> map = new HashMap<>() ;
        
        for(int i=0; i<nums.length; i++){
            map.put(i, target - nums[i]) ;
        }
        
        int j = 0 ;
        
        for(int i=0; i<nums.length; i++){
            
            while(j < nums.length){
                if(i!= j && map.get(i) == nums[j++]) return new int[]{i, j} ;
            }
        }
        
        
        return new int[]{} ;
    }

}
