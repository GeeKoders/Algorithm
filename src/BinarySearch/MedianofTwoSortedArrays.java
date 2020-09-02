package BinarySearch;

import java.util.Arrays;

public class MedianofTwoSortedArrays {

	/*
	 * https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1040/
	 * solution: https://leetcode.com/problems/median-of-two-sorted-arrays/solution/ 
	 * 
	 * Given two sorted arrays nums1 and nums2 of size m and n respectively.
	 * 
	 * Return the median of the two sorted arrays.
	 * 
	 * Follow up: The overall run time complexity should be O(log (m+n)).
	 * 
	 * Example 1:
	 * Input: nums1 = [1,3], nums2 = [2]
	 * Output: 2.00000
	 * Explanation: merged array = [1,2,3] and median is 2.
	 * 
	 * Example 2:
	 * Input: nums1 = [1,2], nums2 = [3,4]
	 * Output: 2.50000
	 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
	 * 
	 * Example 3:
	 * Input: nums1 = [0,0], nums2 = [0,0]
	 * Output: 0.00000
	 * 
	 * Example 4:
	 * Input: nums1 = [], nums2 = [1]
	 * Output: 1.00000
	 * 
	 * Example 5:
	 * Input: nums1 = [2], nums2 = []
	 * Output: 2.00000
	 * 
	 * Constraints:
	 * nums1,length == m
	 * nums2,length == n
	 * 0 <= m <= 1000
	 * 0 <= n <= 1000
	 * 1 <= m + n <= 2000
	 * 
	 */
	public static void main(String[] args) {

		int [] x = {1, 3, 9, 8, 15} ;
		int [] y = {7, 11, 19, 21, 18, 25} ;
		MedianofTwoSortedArrays medianofTwoSortedArrays = new MedianofTwoSortedArrays() ;
		System.out.println(medianofTwoSortedArrays.findMedianSortedArrays2(x, y)) ;
		
	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if(nums2.length == 0 && nums1.length == 0) return -1 ;
        
        if(nums1.length == 0 && nums2.length == 1) return nums2[0] ;
        if(nums2.length == 0 && nums1.length == 1) return nums1[0] ;
        
        int [] res = new int[nums1.length + nums2.length] ;
        int count = 0 ;
        for(int i=0; i<nums1.length; i++){
            res[count++] = nums1[i] ;
        }
        for(int i=0; i<nums2.length; i++){
            res[count++] = nums2[i] ;
        }
        
        Arrays.sort(res) ;
        
        int left = 0 ;
        int right = res.length - 1 ;
        
        int mid = left + (right - left) / 2 ;
        double target = 0 ;
        
        if(res.length % 2 == 0){
            target = (res[mid] + res[mid+1])/2.0 ;
        }else{
            target = res[mid] ;
        }
        
        return target ;
    }
	//reference: https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1040/discuss/2481/Share-my-O(log(min(mn)))-solution-with-explanation
	//reference: https://www.youtube.com/watch?time_continue=1475&v=LPFhl65R7ww&feature=emb_logo
	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		
		//if input1 is greater than switch them so that input1 is smaller than input2.
		if(nums1.length > nums2.length){
			return findMedianSortedArrays2(nums2, nums1) ;
		}
		
		int x = nums1.length ;
		int y = nums2.length ;
		
		int low = 0 ;
		int high = x ;
		while(low <= high){
			
			int partitionX = (low + high)/2 ;
			int partitionY = (x + y + 1) / 2 - partitionX ;
			
			//if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
			//if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1] ;
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX] ;
		
			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1] ;
			int minRightY = (partitionX == y) ? Integer.MAX_VALUE : nums2[partitionY] ;
			
			
			if(maxLeftX <= minRightY && maxLeftY <= minRightX){
				//we have partitioned array at correct place
				//Now get max of left elements and min of right elements to get the median in case of even length combined array size
				
				if((x+y) % 2 == 0){
					return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2 ;
				}else{
					return (double)Math.max(maxLeftX, maxLeftY) ;
				}
				
			}else if(maxLeftX > minRightY){ //we are too far on right side for partitionX. Go on left side.
				high = partitionX - 1 ;
			}else{ // we are too far on left side for partitionX. Go on right side.
				low = partitionX + 1 ;  
			}
			
			
		}
		
		//Only we we can come here is if input arrays were not sorted. Throw in that scenario.
		throw new IllegalArgumentException();
	}

}
