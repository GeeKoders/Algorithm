package Array;

import java.util.Arrays;

public class MergeSortedArray {

	/*
	 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1
	 * as one sorted array.
	 * 
	 * Note:
	 * 
	 * The number of elements initialized in nums1 and nums2 are m and n
	 * respectively. You may assume that nums1 has enough space (size that is
	 * equal to m + n) to hold additional elements from nums2.
	 * 
	 * Example:
	 * 
	 * Input: nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6], n = 3
	 * 
	 * Output: [1,2,2,3,5,6]
	 * 
	 * Constraints:
	 * 
	 * -10^9 <= nums1[i], nums2[i] <= 10^9 
	 * nums1.length == m + n 
	 * nums2.length == n
	 * 
	 */

	public static void main(String[] args) {
		
		MergeSortedArray mergeSortedArray = new MergeSortedArray() ;
		
		int[] nums1 = {1,2,3,0,0,0} ;
		int m = 3 ;
		int[] nums2 = {2, 5, 6} ; 
		int n = 3 ;
		
		mergeSortedArray.solution1(nums1, m, nums2, n);
	}
	
	public void solution1(int[] nums1, int m, int[] nums2, int n) {
        
        if((m+n)!= nums1.length) return ;
        
        int count = 0 ;
        
        for(int i=m; i< m+n; i++){
            nums1[i] = nums2[count++] ;
        }
     
         Arrays.sort(nums1) ;
         
         display(nums1) ;
        
    }

	private void display(int[] nums1) {
		
		for(int item: nums1){
			System.out.print(item + " ");
		}
		
	}
} 

