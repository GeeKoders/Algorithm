package Interview.Google.Array;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
	
	/*
	 * 163. Missing Ranges (Easy)
	 * 
	 * https://leetcode.com/problems/missing-ranges/
	 * 
	 * solution: https://leetcode.com/problems/missing-ranges/solution/
	 * 
	 * Runtime: 6 ms, faster than 58.49% of Java online submissions for Missing Ranges.
	 * 
	 * Memory Usage: 37.3 MB, less than 81.43% of Java online submissions for Missing Ranges.
	 * 
	 * take care about edge case
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 */
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {

		List<String> res = new ArrayList<>() ;
        
        int prev = lower - 1 ;
        for(int i=0; i<=nums.length; i++){
            int cur = (i<nums.length) ? nums[i]: upper + 1 ; 
            if(prev+1 <= cur-1){
               res.add(helper(prev+1, cur-1)) ; 
            }
            
            prev = cur ;
        }
        return res ;
    }
    
    private String helper(int lower, int upper){
        
        if(lower == upper){
            return String.valueOf(lower) ;
        }else{
            return String.valueOf(lower) + "->" + String.valueOf(upper) ;
        }
	}

}
