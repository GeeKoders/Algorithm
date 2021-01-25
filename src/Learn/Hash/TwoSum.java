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

		TwoSum twoSum = new TwoSum() ;
		int result[] = twoSum.twoSum3(new int[]{2, 7, 11, 15}, 9) ;
		
		for(int item: result){
			System.out.println(item);
		}
		
		
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
	//O(N), O(N)
	public int[] twoSum3(int[] nums, int target) {
        
        Map<Integer, Integer> map = new HashMap<>() ;
        
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i) ;
        }
        
        
        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i] ;
            if(map.containsKey(complement) && map.get(complement) != i) return new int[]{i, map.get(complement)} ;
        }
        
        
        return new int[]{} ;
    }
	//O(N), O(N)
	public int[] twoSum4(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {
	            return new int[] { map.get(complement), i };
	        }
	        map.put(nums[i], i);
	    }
	    
	    return new int[]{} ;
	}
	
	public int[] twoSum5(int[] nums, int target) {
        Map <Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;
            } else {
                map.put(nums[i], i);
            }
        }
        
        return res;
    }

}
