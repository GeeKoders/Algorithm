package Trie;

import java.util.List;

public class ReplaceWords {

	class TrieNode {

		private char val;

		private TrieNode[] children;

		private boolean isWord;

		public TrieNode(char val) {
			this.val = val;
			children = new TrieNode[26];
		}

	}

	/*
	 * https://leetcode.com/explore/learn/card/trie/148/practical-application-i/1053/
	 * 
	 * solution: https://leetcode.com/problems/replace-words/solution/
	 * 
	 * reference: https://leetcode.com/explore/learn/card/trie/148/practical-application-i/1053/discuss/105767/Java-SimpleClassical-Trie-questionsolution-(Beat-96)
	 * 
	 *  126 / 126 test cases passed.
		Status: Accepted
		Runtime: 7 ms (your runtime beats 90.72 % of java submissions.)
		Memory Usage: 50 MB (Your memory usage beats 57.84 % of java submissions.)
	 * 
	 */
	
	public static void main(String[] args) {

	}

	public String replaceWords(List<String> dictionary, String sentence) {

		String[] tokens = sentence.split(" ");
		TrieNode node = buildTrie(dictionary);
		return replaceWords(tokens, node);

	}

	private String replaceWords(String[] tokens, TrieNode root) {

		StringBuilder sb = new StringBuilder();
		for (String token : tokens) {
			sb.append(getShortestReplacement(token, root));
			sb.append(" ");
		}

		return sb.substring(0, sb.length() - 1);
	}

	private String getShortestReplacement(String token, TrieNode root) {

		TrieNode temp = root;
		StringBuilder sb = new StringBuilder();
		for (char c : token.toCharArray()) {
			sb.append(c);
			if (temp.children[c - 'a'] != null) {
				if (temp.children[c - 'a'].isWord) {
					return sb.toString();
				}

				temp = temp.children[c - 'a'];
			} else {
				return token;
			}
		}

		return token;

	}

	private TrieNode buildTrie(List<String> dictionary) {

		TrieNode root = new TrieNode(' ');

		for (String word : dictionary) {

			TrieNode temp = root;

			for (char c : word.toCharArray()) {

				if (temp.children[c - 'a'] == null) {
					temp.children[c - 'a'] = new TrieNode(c);
				}

				temp = temp.children[c - 'a'];

			}

			temp.isWord = true;

		}

		return root;

	}
}
