package Array;

public class MoveZeroes {

	/*
	 * Given an array nums, write a function to move all 0's to the end of it
	 * while maintaining the relative order of the non-zero elements.
	 * 
	 * Example: 
	 * Input: [0,1,0,3,12] 
	 * Output: [1,3,12,0,0]
	 * 
	 * Note:
	 * 
	 * You must do this in-place without making a copy of the array. Minimize
	 * the total number of operations.
	 * 
	 */

	public static void main(String[] args) {
		
		MoveZeroes moveZeroes = new MoveZeroes() ;
		int[] nums = {0,1,0,3,12} ;
		moveZeroes.solution1(nums);
		
	}
	
	public void solution1(int[] nums) {
        
	       
        int count = 0 ;
        for(int i=0; i<nums.length; i++){
            
            if(nums[i] != 0){
                nums[count++] = nums[i] ;
            }
        }
        
        for(int i= count; i<nums.length; i++){
            nums[i] = 0 ;
        }
        
        for(int items: nums){
        	System.out.print(items + " ");
        }
        
    }

}
