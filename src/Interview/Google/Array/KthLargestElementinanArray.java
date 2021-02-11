package Interview.Google.Array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementinanArray {

	
	/*
	 * 215. Kth Largest Element in an Array (Medium)
	 * 
	 * https://leetcode.com/problems/kth-largest-element-in-an-array/
	 * 
	 * solution: https://leetcode.com/problems/kth-largest-element-in-an-array/solution/
	 * 
	 * Your runtime beats 98.02 % of java submissions.
	 * Your memory usage beats 56.65 % of java submissions.
	 * 
	 * Time complexity: O(N*logN)
	 * Space complexity: O(1)
	 * 
	 * 
	 */
	public int findKthLargest(int[] nums, int k) {

		Arrays.sort(nums);

		int n = nums.length;

		return nums[n - k];

	}
	/*
	 * 
	 * Your runtime beats 31.72 % of java submissions.
	 * Your memory usage beats 99.39 % of java submissions.
	 * 
	 * Time complexity: O(NlogN) 
	 * Space complexity: O(N)
	 * 
	 */
	public int findKthLargest2(int[] nums, int k) {


        PriorityQueue<Integer> heap = new PriorityQueue<>() ;
        
        for(int i=0; i<nums.length; i++){
            heap.add(nums[i]) ;
        }
        
        int n = nums.length ;
        int count = 0 ;
        int res = 0 ;
        
        while(count != (n - k + 1)){
            res = heap.remove() ;
            count++ ;
        }
        
        return res ;

	}
	/*
	 * 
	 * Your runtime beats 60.30 % of java submissions.
	 * Your memory usage beats 78.99 % of java submissions.
	 * 
	 * Time complexity: O(Nlogk) 
	 * Space complexity: O(k)
	 * 
	 * 
	 */
	public int findKthLargest3(int[] nums, int k) {


        PriorityQueue<Integer> heap = new PriorityQueue<>() ;
        
        for(int i=0; i<nums.length; i++){
            heap.add(nums[i]) ;
            
            if(heap.size()>k){
            	heap.poll();
            }
            
        }
        
       
        
        return heap.poll() ;

	}
	
}
