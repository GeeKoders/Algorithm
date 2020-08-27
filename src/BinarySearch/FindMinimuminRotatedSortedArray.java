package BinarySearch;

public class FindMinimuminRotatedSortedArray {

	
	/*
	 * https://leetcode.com/explore/learn/card/binary-search/126/template-ii/949/
	 * solution: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/solution/
	 * 
	 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
	 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
	 * 
	 * Find the minimum element.
	 * 
	 * You may assume no duplicate exists in the array.
	 * 
	 * Example 1:
	 * Input: [3,4,5,1,2] 
	 * Output: 1
	 * 
	 * Example 2:
	 * Input: [4,5,6,7,0,1,2]
	 * Output: 0
	 * 
	 */
	public static void main(String[] args) {

	}
	
	public int findMin(int[] nums) {
        
        if (nums == null || nums.length == 0) {
           return 0;
       }
       if (nums.length == 1) {
           return nums[0];
       }
       int start = 0, end = nums.length - 1;
       while (start < end) {
           int mid = (start + end) / 2;
           if (mid > 0 && nums[mid] < nums[mid - 1]) {
               return nums[mid];
           }
           if (nums[start] <= nums[mid] && nums[mid] > nums[end]) {
               start = mid + 1;
           } else {
               end = mid - 1;
           }
       }
       return nums[start];
       
       
       
   }
}
