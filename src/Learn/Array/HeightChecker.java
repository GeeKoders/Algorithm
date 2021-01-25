package Array;

import java.util.Arrays;

public class HeightChecker {

	/*
	 * Students are asked to stand in non-decreasing order of heights for an
	 * annual photo.
	 * 
	 * Return the minimum number of students that must move in order for all
	 * students to be standing in non-decreasing order of height.
	 * 
	 * Notice that when a group of students is selected they can reorder in any
	 * possible way between themselves and the non selected students remain on
	 * their seats.
	 * 
	 * Example 1:
	 * Input: heights = [1,1,4,2,1,3] 
	 * Output: 3 
	 * Explanation: Current array :[1,1,4,2,1,3] 
	 * Target array : [1,1,1,2,3,4] 
	 * On index 2 (0-based) we have 4vs1 so we have to move this student. 
	 * On index 4 (0-based) we have 1vs3 so we have to move this student. 
	 * On index 5 (0-based) we have 3vs4 so we have to move this student.
	 * 
	 * Example 2:
	 * Input: heights = [5,1,2,3,4]
     * Output: 5
	 * 
	 * Example 3:
	 * Input: heights = [1,2,3,4,5]
	 * Output: 0
	 * 
	 */

	public static void main(String[] args) {

		HeightChecker heightChecker = new HeightChecker() ;
		int[] heights = {1,1,4,2,1,3} ;
		int result = heightChecker.solution1(heights) ;
		System.out.println(result);
	}
	
	public int solution1(int[] heights) {
        
        if(heights == null || heights.length == 0 || heights.length == 1){
            return 0;    
        }
        
        int count = 0 ;
        
        int target[] = heights.clone() ;
        Arrays.sort(target) ;
            
        for(int i=0; i<target.length; i++){
            if(target[i] != heights[i]){
                count++ ;
            }
        }
        
        return count ;
        
        
    }

}
