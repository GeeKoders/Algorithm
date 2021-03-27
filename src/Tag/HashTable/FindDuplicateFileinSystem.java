package Tag.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileinSystem {
	
	/*
	 * 609. Find Duplicate File in System (Medium)
	 * 
	 * https://leetcode.com/problems/find-duplicate-file-in-system/
	 * 
	 * solution: https://leetcode.com/problems/find-duplicate-file-in-system/solution/
	 * 
	 * Time complexity: O(n∗x). n strings of average length x is parsed.
	 * Space complexity: O(n∗x). map and res size grows upto n * x.
	 * 
	 * 
	 * Runtime: 29 ms, faster than 50.17% of Java online submissions for Find Duplicate File in System.
	 * Memory Usage: 47.4 MB, less than 85.36% of Java online submissions for Find Duplicate File in System.
	 * 
	 */
	public List<List<String>> findDuplicate(String[] paths) {

		Map<String, List<String>> map = new HashMap<>();
		for (String path : paths) {

			String[] values = path.split(" ");

			for (int i = 1; i < values.length; i++) {
				String[] name_cnt = values[i].split("\\(");
				name_cnt[1] = name_cnt[1].replace(")", "");
				List<String> list = map.getOrDefault(name_cnt[1],
						new ArrayList<String>());
				list.add(values[0] + "/" + name_cnt[0]);
				map.put(name_cnt[1], list);
			}

		}

		List<List<String>> res = new ArrayList<>();
		for (String key : map.keySet()) {

			if (map.get(key).size() > 1) {
				res.add(map.get(key));
			}

		}

		return res;
	}
}
