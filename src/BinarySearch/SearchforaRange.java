package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class SearchforaRange {

	public static void main(String[] args) {

	}

	// time limit exceeded
	public int[] searchRange(int[] nums, int target) {

		 if(nums == null || nums.length == 0) return new int[]{-1, -1} ;
	        
	        int left = 0 ;
	        int right = nums.length - 1 ;
	        
	        int res [] = {-1, -1} ;
	        
	        while(left < right){
	            
	            int mid = left + (right - left) / 2 ;
	            int count = 0 ;
	            if(nums[mid] == target){
	                res[count++] = mid ;
	            }
	            
	            if(nums[mid] > target){
	                right = mid - 1 ;
	            }
	            
	            if(nums[mid] < target){
	                left = mid + 1 ;
	            }
	            
	        }
	        
	        return res ;

	}

}
