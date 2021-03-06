package BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindtheDuplicateNumber {

	
	/*
	 * https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1039/
	 * solution: https://leetcode.com/problems/find-the-duplicate-number/solution/
	 * 
	 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must
	 * exist. Assume that there is only one duplicate number, find the duplicate one.
	 * 
	 * Example 1:
	 * Input: [1,3,4,2,2]
	 * Output: 2
	 * 
	 * Example 2:
	 * Input: [3,1,3,4,2]
	 * Output: 3
	 * 
	 * Note:
	 * 1. You must not modify the array (assume the array is read only).
	 * 2. You must use only constant, O(1) extra space.
	 * 3. Your runtime complexity should be less than O(n^2).
	 * 4. There is only one duplicate number in the array, but it could be repeated more than once.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int findDuplicate(int[] nums) {
        
	    
        Set<Integer> set = new HashSet<>() ;
       
        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i])){
                return nums[i] ;
            }else{
                set.add(nums[i]) ;
            }
        }
        
        return -1 ;
        
        
    }
	
	public int findDuplicate2(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>() ;
        
        List<Integer> list = new ArrayList<>() ;
        
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1) ;
        }
        
        for(int i=0; i<nums.length; i++){
            
            if(map.get(nums[i]) != null && map.get(nums[i]) > 1){
                list.add(nums[i]) ;
            }
            
        }
        
        return list.get(0) ;
        
    }
	
	public int findDuplicate3(int[] nums) {
        
        int []res = new int[nums.length] ;
        
        for(int item : nums){
            ++res[item] ;
        }
        
        for(int i=0; i<res.length; i++){
        
            if(res[i] > 1){
                return i ;
            }
        }
        
        return -1 ;
    }
	
	public int findDuplicate4(int[] nums) {
        
        int slow = 0;
        int fast = 0;
        int finder = 0;

        while (true)
        {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast)
                break;
        }
        while (true)
        {
            slow = nums[slow];
            finder = nums[finder];
            if (slow == finder)
                return slow;
        }
    }
	
	public int findDuplicate5(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);
        slow = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
	

}
