package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllNumbersDisappeared {

	/*
	 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some
	 * elements appear twice and others appear once.
	 * 
	 * Find all the elements of [1, n] inclusive that do not appear in this
	 * array.
	 * 
	 * Could you do it without extra space and in O(n) runtime? You may assume
	 * the returned list does not count as extra space.
	 * 
	 * Example:
	 * Input:
	 * [4,3,2,7,8,2,3,1]
	 * 
	 * Output:
	 * [5,6]
	 * 
	 * 
	 */

	public static void main(String[] args) {

		FindAllNumbersDisappeared findAllNumbersDisappeared = new FindAllNumbersDisappeared() ;
		int[] nums = {4,3,2,7,8,2,3,1} ;
//		List<Integer> list = findAllNumbersDisappeared.solution1(nums) ;
//		List<Integer> list = findAllNumbersDisappeared.solution2(nums) ;
		List<Integer> list = findAllNumbersDisappeared.solution3(nums) ;
		for(Integer items: list){
			System.out.print("items:" + items + " ");
		}
	}
	
	
	// Time Limit Exceeded
	public List<Integer> solution1(int[] nums) {
        
        
        List<Integer> list = new ArrayList<Integer>() ;
        
        Arrays.sort(nums) ;
        
        
        for(int i=1; i<=nums.length; i++){
            
            int count = 0 ;
            
            for(int j=0; j<nums.length; j++){
                
                if(i == nums[j] ){
                    break ;
                }else{
                    count ++ ;
                }
            }   
            if(count == nums.length){
                 list.add(i) ;
            }
            
           
        }
        
        return list ;
    }
	
	public List<Integer> solution2(int[] nums) {
		
		List<Integer> list = new ArrayList<Integer>() ;
        
        int[] target = new int[nums.length] ;
        
        for(int i=0; i<nums.length; i++){
            int index = nums[i] - 1 ;
            target[index] = nums[i] ;
        }
        
        for(int items: target){
            System.out.print(items + " ") ;
        }
        
        for(int i=0; i<target.length; i++){
            
            if(target[i] == 0){
                list.add(i+1) ;
            }
            
        }
        
        return list ;
    }
	//better solution
	public List<Integer> solution3(int[] nums) {
		
		List<Integer> list = new ArrayList<Integer>() ;
        
	       //[4,3,2,7,8,2,3,1]
	        
	        for(int i=0; i<nums.length; i++){
	            int index = Math.abs(nums[i]) - 1 ;
	            
	            if(nums[index] < 0 ){
	                
	            }else{
	                nums[index] = -nums[index] ;
	            }
	        }
	        for(int i=0; i<nums.length; i++){
	            
	            if(nums[i]>0){
	                list.add(i+1) ;                
	            }
	        }
	        return list ;
	}
}
