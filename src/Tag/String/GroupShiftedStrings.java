package Tag.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {

	
	/*
	 * 249. Group Shifted Strings (Medium)
	 * 
	 * https://leetcode.com/problems/group-shifted-strings/
	 * 
	 * discuss:
	 * 
	 * https://leetcode.com/problems/group-shifted-strings/discuss/67442/My-Concise-JAVA-Solution
	 * 
	 * youtube:
	 * 
	 * https://www.youtube.com/watch?v=Eqhu29_NTSs&ab_channel=WorkWithGoogler
	 * 
	 * Runtime: 10 ms, faster than 23.42% of Java online submissions for Group Shifted Strings.
	 * Memory Usage: 39.3 MB, less than 51.10% of Java online submissions for Group Shifted Strings.
	 * 
	 * Time complexity: O(m*n), where m is the length of each word and n is the length of array 
	 * Space complexity: O(n)
	 * 
	 */
	public List<List<String>> groupStrings(String[] strings) {
		List<List<String>> result = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strings) {
			int offset = str.charAt(0) - 'a';
			String key = "";
			for (int i = 0; i < str.length(); i++) {
				char c = (char) (str.charAt(i) - offset);
				if (c < 'a') {
					c += 26;
				}
				key += c;
			}
			if (!map.containsKey(key)) {
				List<String> list = new ArrayList<String>();
				map.put(key, list);
			}
			map.get(key).add(str);
		}
		for (String key : map.keySet()) {
			List<String> list = map.get(key);
			// Collections.sort(list);
			result.add(list);
		}
		return result;

	}
}
