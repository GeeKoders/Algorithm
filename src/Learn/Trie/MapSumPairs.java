package Trie;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs {

	class TrieNode {
		public boolean isEnd;
		public Map<Character, TrieNode> trieMap = new HashMap<>();
	}

	/*
	 * https://leetcode.com/explore/learn/card/trie/148/practical-application-i/1058
	 * /
	 * 
	 * solution: https://leetcode.com/problems/map-sum-pairs/solution/
	 */
	public static void main(String[] args) {

	}

	/** Initialize your data structure here. */

	private TrieNode root;

	private Map<String, Integer> map;

	public MapSumPairs() {
		root = new TrieNode();
		map = new HashMap<>();
	}

	public void insert(String key, int val) {

		TrieNode curr = root;

		for (int i = 0; i < key.length(); i++) {

			char currLetter = key.charAt(i);
			if (curr.trieMap.get(currLetter) == null) {
				curr.trieMap.put(currLetter, new TrieNode());
			}
			curr = curr.trieMap.get(currLetter);
		}

		curr.isEnd = true;
		map.put(key, val);

	}

	private TrieNode searchPrefix(String prefix) {
		TrieNode curr = root;
		for (int i = 0; i < prefix.length(); i++) {

			char currLetter = prefix.charAt(i);
			if (curr.trieMap.get(currLetter) == null) {
				return null;
			}
			curr = curr.trieMap.get(currLetter);
		}
		return curr;
	}

	/*
	 * 
		34 / 34 test cases passed.
		Status: Accepted
		Runtime: 12 ms (Your runtime beats 55.83 % of java submissions.)
		Memory Usage: 39 MB (Your memory usage beats 57.95 % of java submissions.)
	 * 
	 * 
	 * 
	 * 
	 */
	public int sum(String prefix) {

		TrieNode curr = searchPrefix(prefix);

		if (curr == null)
			return 0;
		int sum = 0;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {

			if (entry.getKey().startsWith(prefix)) {
				sum += entry.getValue();
			}

		}

		return sum;

	}
}
