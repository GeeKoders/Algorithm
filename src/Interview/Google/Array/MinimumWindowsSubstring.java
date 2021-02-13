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
	 * https://www.youtube.com/watch?v=jSto0O4AJbM&ab_channel=NeetCode
	 * 
	 * https://www.youtube.com/watch?v=vvVe7qxOz9U&ab_channel=happygirlzt
	 * 
	 * Runtime: 13 ms, faster than 46.41% of Java online submissions for Minimum Window Substring.
	 * Memory Usage: 40.1 MB, less than 29.10% of Java online submissions for Minimum Window Substring.
	 * 
	 * Time complexity: O(|S| + |T|)
	 * Space complexity: O(|S| + |T|)
	 * 
	 * 
	 */
	public String minWindow(String s, String t) {
		if (s.length() == 0 || t.length() == 0) {
	          return "";
	      }

	      Map<Character, Integer> target = new HashMap<Character, Integer>();
	      for (int i = 0; i < t.length(); i++) {
	          int count = target.getOrDefault(t.charAt(i), 0);
	          target.put(t.charAt(i), count + 1);
	      }


	      int required = target.size();

	      int l = 0, r = 0;


	      int have = 0;
	      int minLength = Integer.MAX_VALUE ;
	      int minStart = 0 ;
	      int minEnd = 0 ;


	      Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

	      // ans list of the form (window length, left, right)
	      int[] ans = {-1, 0, 0};

	      while (r < s.length()) {
	          
	          char c = s.charAt(r);
	          int count = windowCounts.getOrDefault(c, 0);
	          windowCounts.put(c, count + 1);

	  
	          if (target.containsKey(c) && windowCounts.get(c).intValue() == target.get(c).intValue()) {
	              have++;
	          }


	          while (l <= r && have == required) {
	              c = s.charAt(l);
	              if ( r - l + 1 < minLength) {
	                  minLength = r - l + 1;
	                  minStart = l;
	                  minEnd = r;
	              }

	              windowCounts.put(c, windowCounts.get(c) - 1);
	              if (target.containsKey(c) && windowCounts.get(c).intValue() < target.get(c).intValue()) {
	                  have--;
	              }


	              l++;
	          }

	          r++;   
	      }

	      return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minEnd + 1);
	        
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
