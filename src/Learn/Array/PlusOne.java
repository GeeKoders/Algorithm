package Array;

public class PlusOne {

	/*
	 * https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1148
	 * 
	 * 
	 * Given a non-empty array of digits representing a non-negative integer,
	 * increment one to the integer.
	 * 
	 * The digits are stored such that the most significant digit is at the head
	 * of the list, and each element in the array contains a single digit.
	 * 
	 * You may assume the integer does not contain any leading zero, except the
	 * number 0 itself.
	 * 
	 * Example 1:
	 * Input: [1,2,3]
	 * Output: [1,2,4]
	 * Explanation: The array represents the integer 123.
	 * 
	 * Example 2:
	 * Input: [4,3,2,1]
	 * Output: [4,3,2,2]
	 * Explanation: The array represents the integer 4321.
	 * 
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] plusOne(int[] digits) {
        
        for(int i=digits.length-1; i>=0 ; i--){
            
            if(digits[i] < 9){
                digits[i]++ ;
                return digits ;
            }
            
            digits[i] = 0 ;
        }
        
        int [] arr = new int[digits.length + 1] ;
        arr[0] = 1 ;        
        
        return arr ;        
        
    }

}
