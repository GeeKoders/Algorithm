package Tag.String;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	
	/*
	 * 179. Largest Number (Medium)
	 * 
	 * https://leetcode.com/problems/largest-number/
	 * 
	 * solution: https://leetcode.com/problems/largest-number/solution/
	 * 
	 * reference:
	 * 
	 * https://www.youtube.com/watch?v=AKZaaVqjVl4&ab_channel=jayatitiwari
	 * 
	 * Runtime: 41 ms, faster than 5.02% of Java online submissions for Largest Number.
	 * Memory Usage: 39.3 MB, less than 20.12% of Java online submissions for Largest Number.
	 * 
	 * Time complexity: O(NlogN)
	 * Space complexity: O(N)
	 * 
	 */
	public String largestNumber(int[] nums) {
		if (nums.length == 0)
			return "";

		String[] sa = new String[nums.length];
		for (int i = 0; i < sa.length; i++) {
			sa[i] = Integer.toString(nums[i]);
		}

		Arrays.sort(sa, new Comparator<String>() {
			public int compare(String a, String b) {
				String o1 = a + b;
				String o2 = b + a;
				System.out.println("o1:" + o1 + ",o2:" + o2);
				return o2.compareTo(o1);
			}
		});

		if (sa[0].equals("0")) {
			return "0";
		}

		StringBuilder sb = new StringBuilder();

		for (String s : sa) {
			System.out.println("s:" + s);
			sb.append(s);
		}

		return sb.toString();

	}
}
