package BinarySearchTree;

import java.util.TreeSet;

public class DuplicateIII {
	
	
	
	/*
	 * https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/142/conclusion/1013/
	 * 
	 * solution: https://leetcode.com/problems/contains-duplicate-iii/solution/
	 * 
	 * youtube (easy to understand): https://www.youtube.com/watch?v=Cu7g9ovYHNI&ab_channel=FisherCoder
	 * 
	 *  53 / 53 test cases passed.
		Status: Accepted
		Runtime: 31 ms
		Memory Usage: 41 MB
	 * 
	 * 
	 * Time complexity: O(nlog(min(n, k)))
	 * Space complexity: O(min(n, k))
	 * 
	 */
	public boolean containsNearbyAlmostDuplicate(int []nums, int k, int t){
		
		TreeSet<Long> set = new TreeSet() ;
		
		for(int i=0; i < nums.length; i++){
			
			// use Long instead of Integer to avoid overflow problem
			
			Long floor = set.floor((long) nums[i]) ;
			if(floor!=null && nums[i] - floor <= t){
				return true ;
			}
			
			Long ceiling = set.ceiling((long) nums[i]) ;
			
			if(ceiling != null && ceiling - nums[i] <= t){
				return true ;
			}
			
			set.add((long)nums[i]) ;
			if(set.size() > k){
				set.remove((long)nums[i - k]) ;
			}
			
		}
		
		return false ;
		
		
	}
	

}
