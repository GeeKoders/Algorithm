package Array;

public class TwoSumII {

	
	/*
	 * https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1153/
	 * 
	 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
	 * 
	 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
	 * 
	 * Note:
	 * Your returned answers (both index1 and index2) are not zero-based.
     * You may assume that each input would have exactly one solution and you may not use the same element twice.
	 * 
	 * Example:
	 * Input: numbers = [2,7,11,15], target = 9
	 * Output: [1,2]
	 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
	 * 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] twoSum(int[] numbers, int target) {
        
        int[] twoSum = new int[2] ;
        
        
        for(int i=0; i<numbers.length; i++){
            
           for(int j=i+1; j<numbers.length; j++){
               
               int sum = numbers[i] + numbers[j] ; 
               
               if( sum > target){
                   break ;
               }
               
               if(sum == target){
                   twoSum[0] = i + 1 ;
                   twoSum[1] = j + 1 ;
               }
               
           }
            
        }
        
        return twoSum;
    }
	
	//the best solution
	public int[] twoSum2(int[] numbers, int target) {
        
        int start = 0 ; 
        int end = numbers.length - 1 ;
        
        while(start < end){
            
            if( (numbers[start] + numbers[end]) == target ) break ;
            if( (numbers[start] + numbers[end]) < target ){
                start ++ ;
            }else{
                end -- ;
            }
        }
        
        return new int[]{start+1, end+1} ; 
    }

}
