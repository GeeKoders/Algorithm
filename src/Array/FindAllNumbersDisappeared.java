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
		List<Integer> list = findAllNumbersDisappeared.solution1(nums) ;
		
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

}
