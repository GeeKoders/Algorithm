package BinarySearch;

public class BinarySearch {

	/*
	 * https://leetcode.com/explore/learn/card/binary-search/138/background/1038/
	 * solution: https://leetcode.com/problems/binary-search/solution/
	 * 
	 * Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If
	 * target exists, then return its index, otherwise return -1.
	 * 
	 * Example 1:
	 * Input: nums = [-1,0,3,5,9,12], target = 9
	 * Output: 4
	 * Explanation: 9 exists in nums and its index is 4
	 * 
	 * Example 2:
	 * Input: nums = [-1,0,3,5,9,12], target = 2
	 * Output: -1
	 * Explanation: 2 does not exist in nums so return -1
	 * 
	 * Note:
	 * 1.You may assume that all elements in nums are unique.
	 * 2.n will be in the range [1, 10000].
	 * 3.The value of each element in nums will be in the range [-9999, 9999].
	 * 
	 */
	
	public static void main(String[] args) {
		
		BinarySearch bs = new BinarySearch() ;
		int [] nums = {-1,0,3,5,9,12} ;
		int target = 2 ;
		int result = bs.search(nums, target) ;
		System.out.println(result);
		
	}
	
	public int search(int[] nums, int target) {
        
        int start = 0 ; 
        int end = nums.length - 1 ;
        
        while(start <= end){
            
            int mid = (start + end) / 2 ;
            
            if(target == nums[mid]) return mid ;
             
            if(target < nums[mid]){
                end = mid - 1 ;    
            }else{
                start = mid + 1 ;
            }
            
        }
        
        return -1 ;
        
    }
}
