package Trie;

import java.util.HashSet;
import java.util.Set;

public class MaximumXORofTwoNumbers {

	
	
	/*
	 * 
	 * solution: https://www.youtube.com/watch?v=ZHtZfkAcPKc&ab_channel=MaxMing
	 *           https://www.youtube.com/watch?v=PTvFn17ZDRg&ab_channel=LearnCodeRepeat
	 * approach 1 : I can't understand
	 */
	public int findMaximumXOR(int[] nums) {
        
		int maxNum = nums[0];
	    for(int num : nums) maxNum = Math.max(maxNum, num);
	    // length of max number in a binary representation
	    int L = (Integer.toBinaryString(maxNum)).length();

	    int maxXor = 0, currXor;
	    Set<Integer> prefixes = new HashSet<>();
	    for(int i = L - 1; i > -1; --i) {
	      // go to the next bit by the left shift
	      maxXor <<= 1;
	      // set 1 in the smallest bit
	      currXor = maxXor | 1;
	      prefixes.clear();
	      // compute all possible prefixes 
	      // of length (L - i) in binary representation
	      for(int num: nums) prefixes.add(num >> i);
	      // Update maxXor, if two of these prefixes could result in currXor.
	      // Check if p1^p2 == currXor, i.e. p1 == currXor^p2.
	      for(int p: prefixes) {
	        if (prefixes.contains(currXor^p)) {
	          maxXor = currXor;
	          break;
	        }
	      }
	    }
	    return maxXor;
	  }
	
	// approach2
	/*
	 * 
	 * 
	 * Time Limit Exceeded
	 */
	
	public int findMaximumXOR2(int[] nums) {
		
		int max = 0 ;
		for(int i = 0; i< nums.length-1; i++){
			for(int j = i+1 ; j<nums.length  ; j++){
				max = Math.max(max, nums[i] ^ nums[j]) ;
			}
			
			
		}
		
		return max ;
		
	}
		
}
