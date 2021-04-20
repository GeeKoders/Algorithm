package Tag.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
	
	
	/*
	 * 496. Next Greater Element I (Easy)
	 * 
	 * https://leetcode.com/problems/next-greater-element-i/
	 * 
	 * solution: https://leetcode.com/problems/next-greater-element-i/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=MH-9LmOb4gE&ab_channel=happygirlzt
	 * 
	 * Runtime: 3 ms, faster than 81.94% of Java online submissions for Next Greater Element I.
	 * Memory Usage: 39 MB, less than 77.93% of Java online submissions for Next Greater Element I.
	 * 
	 */
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {

		int n = nums2.length;
		Stack<Integer> stack = new Stack<>();

		Map<Integer, Integer> map = new HashMap<>();

		int[] res = new int[nums1.length];

		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
				stack.pop();
			}

			map.put(nums2[i], stack.isEmpty() ? -1 : nums2[stack.peek()]);
			stack.push(i);
		}

		for (int i = 0; i < nums1.length; i++) {
			res[i] = map.get(nums1[i]);
		}

		return res;
	}
}
