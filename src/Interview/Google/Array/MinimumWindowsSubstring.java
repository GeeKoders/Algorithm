package Interview.Google.Array;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowsSubstring {

	
	/*
	 * Wrong answer
	 * 
	 * 76. Minimum Window Substring (Hard)
	 * 
	 * https://leetcode.com/problems/minimum-window-substring/
	 * 
	 * solution: https://leetcode.com/problems/minimum-window-substring/solution/
	 * 
	 * reference:
	 * 
	 * https://leetcode.com/problems/minimum-window-substring/solution/
	 * 
	 * https://www.youtube.com/watch?v=vvVe7qxOz9U&ab_channel=happygirlzt
	 * 
	 * Time complexity: O(|S| + |T|)
	 * Space complexity: O(|S| + |T|)
	 * 
	 * 
	 */
	public String minWindow(String s, String t) {
		if (s == null || s.length() == 0) {
			return "";
		}

		Map<Character, Integer> map = new HashMap<>();
		Map<Character, Integer> window = new HashMap<>();

		int minLength = Integer.MAX_VALUE;
		int minStart = -1;
		int minEnd = -1;

		for (int i = 0; i < t.length(); i++) {
			map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
		}

		int l = 0;
		int r = 0;
		int have = 0;
		int required = t.length();

		for (r = 0; r < s.length(); r++) {

			char cur = s.charAt(r);

			window.put(cur, map.getOrDefault(cur, 0) + 1);

			if (map.containsKey(cur) && window.get(cur) == map.get(cur)) {
				have++;
			}

			while (have == required) {
				// update our result
				if ((r - l + 1) < minLength) {
					minStart = l;
					minEnd = r;
				}
				minLength = r - l + 1;

				// pop from the left of our window ;
				window.put(cur, map.getOrDefault(cur, 0) - 1);

				if (map.containsKey(s.charAt(l))) {

					if (window.get(s.charAt(l)) < map.get(s.charAt(l))) {
						have--;
					}

				}

				l++;

			}

		}

		minStart = l;
		minEnd = r;
		;

		return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart,
				minEnd);
	}
	
	
	/*
	 * reference:
	 * 
	 * https://www.youtube.com/watch?v=vvVe7qxOz9U&ab_channel=happygirlzt
     *
     * Your runtime beats 84.75 % of java submissions.
     *
     * Your memory usage beats 57.81 % of java submissions.
     * 
	 */
	public String minWindow2(String s, String t) {
	
		if (s == null || s.length() == 0) return "";
        int lo = 0, hi = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = -1, minEnd = -1;

        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int count = 0;
        for (hi = 0; hi < s.length(); hi++) {
            if (map[s.charAt(hi)] > 0) {
                count++;
            }
            map[s.charAt(hi)]--;
            if (count == t.length()) {
                while (lo < hi && map[s.charAt(lo)] < 0) {
                    map[s.charAt(lo)]++;
                    lo++;
                }

                if (hi - lo + 1 < minLen) {
                    minLen = hi - lo + 1;
                    minStart = lo;
                    minEnd = hi + 1;
                }
                map[s.charAt(lo)]++;
                count--;
                lo++;
            }
        }

        return (minStart == -1) ? "" : s.substring(minStart, minEnd);
		
	}
}
