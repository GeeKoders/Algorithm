package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {

	
	/*
	 * https://leetcode.com/explore/learn/card/binary-search/135/template-iii/945
	 * solution: https://leetcode.com/problems/find-k-closest-elements/solution/
	 * 
	 * Given a sorted array arr, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending
	 * order. If there is a tie, the smaller elements are always preferred.
	 * 
	 * Example 1:
	 * Input: arr = [1,2,3,4,5], k = 4, x = 3
	 * Output: [1,2,3,4]
	 * 
	 * Example 2:
	 * Input: arr = [1,2,3,4,5], k = 4, x = -1
	 * Output: [1,2,3,4]
	 * 
	 * Constraints:
	 * 1 <= k <= arr.length
	 * 1 <= arr.length <= 10^4
	 * Absolute value of elements in the array and x will not exceed 10^4
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        
        
        List<Integer> res = new ArrayList<>() ;
        
        int left = 0 ; 
        int right = arr.length - 1 ;
       
        while(right - left >= k){
            
            if(Math.abs(arr[left] - x) > Math.abs(arr[right] - x)){
                left ++ ;                
            }else{
                right -- ;
            }
         }
        
        for(int i=left; i<=right; i++){
            res.add(arr[i]) ;
        }
        
        return res ;
        
        
    }

}
