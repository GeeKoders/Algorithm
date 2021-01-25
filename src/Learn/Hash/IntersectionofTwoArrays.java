package Hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class IntersectionofTwoArrays {

	/*
	 * https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1105/
	 * solution: https://leetcode.com/problems/intersection-of-two-arrays/solution/
	 * 
	 * Given two arrays, write a function to compute their intersection.
	 * 
	 * Example 1: 
	 * Input: nums1 = [1,2,2,1], nums2 = [2,2] 
	 * Output: [2]
	 * 
	 * Example 2: 
	 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4] 
	 * Output: [9,4]
	 * 
	 * Note: 
	 * Each element in the result must be unique. 
	 * The result can be in any order.
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// your runtime beats 5.43% of java submissions
	public int[] intersection(int[] nums1, int[] nums2) {

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < nums1.length; i++) {

			for (int j = 0; j < nums2.length; j++) {

				if (nums1[i] == nums2[j]) {
					if (!list.contains(nums1[i])) {
						list.add(nums1[i]);
					}
				}
			}
		}

		int[] result = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;

	}

	// your runtime beats 5.43% of java submissions
	public int[] intersection2(int[] nums1, int[] nums2) {

		Stack<Integer> stack1 = new Stack<>();
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < nums1.length; i++) {
			if (!stack1.contains(nums1[i])) {
				stack1.push(nums1[i]);
			}
		}

		for (int i = 0; i < nums2.length; i++) {
			if (stack1.contains(nums2[i])) {
				set.add(nums2[i]);
			}

		}

		int[] result = new int[set.size()];
		int count = 0;
		for (Integer item : set) {
			result[count++] = item;
		}

		return result;

	}

	// your runtime beats 99.41% of java submissions
	public int[] intersection3(int[] nums1, int[] nums2) {

		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();

		for (int i = 0; i < nums1.length; i++) {
			set1.add(nums1[i]);
		}

		for (int i = 0; i < nums2.length; i++) {
			if (set1.contains(nums2[i])) {
				set2.add(nums2[i]);
			}

		}

		int[] result = new int[set2.size()];
		int count = 0;
		for (Integer item : set2) {
			result[count++] = item;
		}

		return result;

	}

}
