package Array.search;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {

		int [] nums ={42, 32, 27, 56, 28, 30} ;
		int target = 56 ;
	
		Arrays.sort(nums);
		//{27, 28, 30, 32, 42, 56}
		int startIndex = 0 ; 
		int endIndex = nums.length - 1 ;
		
		
		while(startIndex <= endIndex){
			
			int middle = (startIndex + endIndex) / 2 ;
			if(target == nums[middle]){
				System.out.println("Target has found on index:" + middle) ;
				return ;
			}
			
			if(target < nums[middle]){
				endIndex = middle - 1 ;
			}else{
				startIndex = middle + 1 ;
			}
		}
		
	}

}
