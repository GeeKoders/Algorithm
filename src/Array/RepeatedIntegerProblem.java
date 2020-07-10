package Array;

import java.util.Arrays;

public class RepeatedIntegerProblem {

	public static void main(String[] args) {
		
		// {0, 4, 2, 4, 1, 1} is bug
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		RepeatedIntegerProblem repeatedIntegerProblem = new RepeatedIntegerProblem() ;
		int[] result = repeatedIntegerProblem.solution1(nums) ;
		
		
		for(int items: result){
			System.out.print(items + " ");
		}
		
	}
	//not in-place
	public int[] solution1(int[] nums) {

		//O(logN)
		Arrays.sort(nums);
		
		int target[] = new int[nums.length] ;
		int count = 0 ;
		//O(N)
		for (int i = 0; i < nums.length - 1; i++) {
			
			if(nums[i] == nums[i+1]){
				if( target[count] != nums[count+1]){
					target[count++] = nums[i] ;
				}
				
			}
			
		}
		
		return target ;
	}

}
