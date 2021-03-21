package Tag.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
	
	
	/*
	 * 811. Subdomain Visit Count (Easy)
	 * 
	 * https://leetcode.com/problems/subdomain-visit-count/
	 * 
	 * solution: https://leetcode.com/problems/subdomain-visit-count/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=wfg1UtZd7U8&ab_channel=%E4%B8%83%E4%BA%BA%E5%B0%8F%E7%BB%84Pleasewatchin2xSPEED
	 * 
	 * Runtime: 13 ms, faster than 90.28% of Java online submissions for Subdomain Visit Count.
	 * Memory Usage: 40.4 MB, less than 41.21% of Java online submissions for Subdomain Visit Count.
	 * 
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 * 
	 * 
	 * 
	 */
	public List<String> subdomainVisits(String[] cpdomains) {

		List<String> res = new ArrayList<>();

		if (cpdomains == null || cpdomains.length == 0)
			return res;

		Map<String, Integer> map = new HashMap<>();

		for (String c : cpdomains) {

			int spaceIndex = Integer.valueOf(c.indexOf(' '));
			int currCount = Integer.valueOf(c.substring(0, spaceIndex));

			String content = c.substring(spaceIndex + 1);

			int dotIndex = 0;

			while (content != "") {

				map.put(content, map.getOrDefault(content, 0) + currCount);

				dotIndex = content.indexOf('.');

				if (dotIndex == -1) {
					content = "";
				} else {
					content = content.substring(dotIndex + 1);
				}

			}

		}

		for (String key : map.keySet()) {

			res.add(map.get(key) + " " + key);

		}

		return res;
	}
}
