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
	 * https://www.youtube.com/watch?v=HAuqbJojVPk&t=2s&ab_channel=NareshGupta
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
	
	/*
	 * approach3
	 * solution: https://www.youtube.com/watch?v=blsm1fA9JHQ&ab_channel=coderZ
	 * 
	 * [3, 10, 5, 25, 2, 8] = [00011, 01010, 00101, 11001, 00010, 01000]
	 * 
	 * a^b=c, a^c=b
	 * a^b=max, a^max=b
	 * mask = 10000 -> maximum = 10000 ? true
	 * mask = 11000 -> maximum = 11000 ? true
	 * mask = 11100 -> maximum = 11100 ? true
	 * mask = 11110 -> maximum = 11110 ? false -> maximum = 11100
	 * mask = 11111 -> maximum = 11101 ? false -> maximum = 11100 > 28
	 * 
	 * 
		39 / 39 test cases passed.
		Status: Accepted
		Runtime: 76 ms (Your runtime beats 46.93 % of java submissions.)
		Memory Usage: 40 MB
	 * 
	 */
	public int findMaximumXOR3(int [] nums){
		
		int maximum = 0 ; 
		int mask = 0 ;
		for(int i = 30; i>=0; i--){
			int one = 1 << i ;
			mask = mask | one ;
			HashSet<Integer> set = new HashSet<>() ;
			for(int num: nums) set.add(mask & num) ;
			for(int val: set){
				if(set.contains(val ^ (maximum | one))){
					maximum = maximum | one ;
					break ;
				}
			}
			
			
		}
		return maximum ;
		
		
	}
		
}
