package Hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SingleNumber {

	/*
	 * https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1176/
	 * solution: https://leetcode.com/problems/single-number/solution/
	 * 
	 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
	 * Note:
	 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
	 * 
	 * Example 1:
	 * Input: [2,2,1]
	 * Output: 1
	 * 
	 * Example 2:
	 * Input: [4,1,2,1,2]
	 * Output: 4
	 * 
	 */
	
	
	public static void main(String[] args) {

	}
	
	public int singleNumber(int[] nums) {
        
        Arrays.sort(nums) ;
        
        for(int i=0; i<nums.length; i=i+2){
            
            if(i+1 <nums.length && nums[i] == nums[i+1]){
            }else{
                return nums[i] ;
            }
        }
        return -1 ;
    }
	
	public int singleNumber2(int[] nums) {
	        
	        Arrays.sort(nums) ;
	        
	        Stack<Integer> stack = new Stack<>() ;
	        
	        for(int i=0; i<nums.length; i++){
	            
	            if(stack.contains(nums[i])){
	                stack.pop() ;
	            }else{
	                stack.push(nums[i]) ;
	            }
	            
	        }
	        
	        return stack.pop() ;
	        
	        
	}

	public int singleNumber3(int[] nums) {
        
        //Arrays.sort(nums) ;
        
        Set<Integer> set = new HashSet<>() ;
        
        for(int i=0; i<nums.length; i++){
            
            if(set.contains(nums[i])){
                set.remove(nums[i]) ;
            }else{
                set.add(nums[i]) ;
            }
            
        }
        
        for(int item: set){
        	return item ;
        }
        
        return -1 ;
        
    }
	

}
