package Tag.String;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterinaString {

	/*
	 * 387. First Unique Character in a String (Easy)
	 * 
	 * https://leetcode.com/problems/first-unique-character-in-a-string/
	 * 
	 * solution: https://leetcode.com/problems/first-unique-character-in-a-string/solution/
	 * 
	 * Runtime: 27 ms, faster than 26.91% of Java online submissions for First Unique Character in a String.
	 * Memory Usage: 39.8 MB, less than 34.90% of Java online submissions for First Unique Character in a String.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(1) because English alphabet contains 26 letters.
	 * 
	 */
	public int firstUniqChar(String s) {

		if (s == null || s.length() == 0)
			return -1;

		int res = Integer.MAX_VALUE;

		Map<Character, Integer> mapCount = new HashMap<>();
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);

			mapCount.put(c, mapCount.getOrDefault(c, 0) + 1);

			if (!map.containsKey(c)) {
				map.put(c, i);
			}

		}

		for (Map.Entry entry : mapCount.entrySet()) {

			if (mapCount.get(entry.getKey()) == 1) {
				res = Math.min(res, map.get(entry.getKey()));
			}

		}

		return res == Integer.MAX_VALUE ? -1 : res;

	}
	/*
	 * better solution
	 * 
	 * Runtime: 21 ms, faster than 59.95% of Java online submissions for First Unique Character in a String.
	 * Memory Usage: 39.7 MB, less than 34.90% of Java online submissions for First Unique Character in a String.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(1) because English alphabet contains 26 letters.
	 * 
	 */
	public int firstUniqChar2(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1) 
                return i;
        }
        return -1;
    }
}
