package Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

	
	/*
	 * https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1133/
	 * solution: https://leetcode.com/problems/top-k-frequent-elements/solution/
	 * 
	 * Given a non-empty array of integers, return the k most frequent elements.
	 * 
	 * Example 1:
	 * Input: nums = [1,1,1,2,2,3], k = 2
	 * Output: [1,2]
	 * 
	 * Example 2:
	 * Input: nums = [1], k = 1
	 * Output: [1]
	 * 
	 * Note:
	 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
	 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
	 * It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
	 * You can return the answer in any order.
	 * 
	 */
	public static void main(String[] args) {
		
	}
	
	public int[] topKFrequent(int[] nums, int k) {
        
        //Arrays.sort(nums) ;
        
        if(nums == null || nums.length == 0) return new int[]{} ;
        
        Map <Integer, Integer> map = new HashMap<>() ;
        
        
        for(int i=0; i<nums.length; i++){
            int freq = map.getOrDefault(nums[i], 0) ;
            map.put(nums[i], freq + 1) ;
        }
        
        List<Integer> list = new LinkedList<>() ;
        
    
        
        while(k-- > 0) {
            int maxValue = 0;
            int maxKey = 0;
            for(int key : map.keySet()) {
                if (maxValue < map.get(key)) {
                    maxValue = map.get(key);
                    maxKey = key;
                }
            }
            list.add(maxKey);
            map.remove(maxKey);
        }
        
        int [] result = new int[list.size()] ;
        
        for(int i=0; i<list.size() ;i++){
            result[i] = list.get(i) ;    
        }
        
       
        return result ;
    }
	

}
