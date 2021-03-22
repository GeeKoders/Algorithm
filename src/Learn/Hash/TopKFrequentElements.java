package Learn.Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	
	/*
	 * Top K Frequent Elements (Medium)
	 * 
	 * https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1133/
	 * 
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
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		TopKFrequentElements topKFrequentElements = new TopKFrequentElements() ;
		List<Integer> result = topKFrequentElements.topKFrequent2(new int[]{1,1,1,2,2,3,4,4}, 2) ;
		
		
		for(int item: result){
			System.out.println(item);
		}
		
		
		
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
	//reference: https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1133/discuss/81602/Java-O(n)-Solution-Bucket-Sort
	@SuppressWarnings("unchecked")
	public List<Integer> topKFrequent2(int[] nums, int k) {

		List<Integer>[] bucket = new List[nums.length + 1];
		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

		for (int n : nums) {
			frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
		}

		for (int key : frequencyMap.keySet()) {
			int frequency = frequencyMap.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}
		
		System.out.println("test:" + bucket[2]);

		/*
		 * {frequency:key
		 * 	3: [1]
		 *  2: [2, 4]
		 *  1: [3]
		 * }
		 * 
		 */
		
		List<Integer> res = new ArrayList<>();

		for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
			if (bucket[pos] != null) {
				res.addAll(bucket[pos]);
			}
		}
		return res;
	}
	/*
	 * Runtime: 11 ms, faster than 49.71% of Java online submissions for Top K Frequent Elements.
	 * Memory Usage: 41.4 MB, less than 88.86% of Java online submissions for Top K Frequent Elements.
	 * 
	 * Time complexity: O(Nlogk)
	 * Space complexity: O(N+k)
	 * 
	 */
	public int[] topKFrequent3(int[] nums, int k) {
        
        if(k == nums.length) return nums ;
        
        Map<Integer, Integer> map = new HashMap<>() ;
        
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0) + 1) ;
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2)) ;
        
        
       for(int n:map.keySet()){
          
          heap.add(n) ;
          if(heap.size() > k) heap.poll() ;
          
       }  
       
       int []res = new int[k] ;
       int count = 0; 
       while(heap.size()>0){
           
           res[count++] = heap.poll() ;
           
       }
        
       return res ;
        
    }
	
	

}
