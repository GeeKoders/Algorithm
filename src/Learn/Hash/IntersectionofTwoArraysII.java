package Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionofTwoArraysII {

	
	/*
	 * https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1178
	 * reference: https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1178/discuss/282372/Java-solution-with-all-3-follow-up-questions
	 * 
	 * Given two arrays, write a function to compute their intersection.
	 * 
	 * Example 1:
	 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
	 * Output: [2,2]
	 * 
	 * Example 2:
	 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
	 * Output: [4,9]
	 * 
	 * Note:
	 * Each element in the result should appear as many times as it shows in both arrays.
	 * The result can be in any order.
	 * 
	 * Follow up:
	 * What if the given array is already sorted? How would you optimize your algorithm?
	 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
	 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
	 * 
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		IntersectionofTwoArraysII intersectionofTwoArraysII = new IntersectionofTwoArraysII() ;
		int []result = intersectionofTwoArraysII.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}) ;

	}
	
	public int[] intersect(int[] nums1, int[] nums2) {
        
        
		HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums1){
            int freq = map.getOrDefault(i, 0);
            map.put(i, freq + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
        	System.out.println(entry.getKey() + "," + entry.getValue());
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : nums2){
            if(map.get(i) != null && map.get(i) > 0){
                list.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        int[] ret = new int[list.size()]; 
        for(int i = 0; i < list.size();i++){
            ret[i] = list.get(i);
            System.out.println(ret[i]);
        }
        return ret;
        
        
    }
	//follow up
	/*
	 * What if the given array is already sorted? How would you optimize your algorithm?
	 * Classic two pointer iteration, i points to nums1 and j points to nums2. Because a sorted array is in ascending order, so if
	 * nums1[i] > nums[j], we need to increment j, and vice versa. Only when nums1[i] == nums[j], we add it to the result array.
	 * Time Complexity O(max(N, M)). Worst case, for example, would be nums1 = {100}, and nums2 = {1, 2, ..., 100 }. We will
	 * always iterate the longest array. The example code is below(I sorted it so it could go through OJ):
	 * 
	 */
	public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length, m = nums2.length;
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while(i < n && j < m){
            int a = nums1[i], b= nums2[j];
            if(a == b){
                list.add(a);
                i++;
                j++;
            }else if(a < b){
                i++;
            }else{
                j++;
            }
        }
        int[] ret = new int[list.size()];
        for(int k = 0; k < list.size();k++) ret[k] = list.get(k);
        return ret;
    }
	
	/*
	 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
	 * This one is a bit tricky. Let's say nums1 is K size. Then we should do binary search for every element in nums1. Each
	 * lookup is O(log N), and if we do K times, we have O(K log N).
	 * If K this is small enough, O(K log N) < O(max(N, M)). Otherwise, we have to use the previous two pointers method.
	 * 
	 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements
	 * into the memory at once?
	 * 
	 * This one is open-ended. But Map-Reduce I believe is a good answer.
	 */

}
