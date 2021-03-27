package Tag.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
	
	/*
	 * 692. Top K Frequent Words (Medium)
	 * 
	 * https://leetcode.com/problems/top-k-frequent-words/
	 * 
	 * solution: https://leetcode.com/problems/top-k-frequent-words/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=cupg2TGIkyM&ab_channel=MichaelMuinos
	 * 
	 * Time complexity: O(Nlog(K))
	 * Space complexity: O(N)
	 * 
	 */
	public List<String> topKFrequent(String[] words, int k) {

		Map<String, Integer> map = new HashMap<>();

		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		PriorityQueue<String> pq = new PriorityQueue<>(
				new Comparator<String>() {

					@Override
					public int compare(String word1, String word2) {

						int frequency1 = map.get(word1);
						int frequency2 = map.get(word2);
						if (frequency1 == frequency2)
							return word2.compareTo(word1); // with greatest
															// alphabatical word
															// first

						return frequency1 - frequency2;

					}

				});

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			pq.add(entry.getKey());
			if (pq.size() > k)
				pq.poll();
		}

		List<String> res = new ArrayList<>();

		while (!pq.isEmpty()) {
			res.add(pq.poll());
		}

		Collections.reverse(res);

		return res;
	}
}
