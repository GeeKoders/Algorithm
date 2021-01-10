package Trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

	class TrieNode {
		TrieNode[] children;
		String word;

		public TrieNode() {
			children = new TrieNode[26];
			word = null;
		}
	}
	
	
	/*
	 * https://leetcode.com/explore/learn/card/trie/149/practical-application-ii/1056/
	 * 
	 * solution: https://leetcode.com/problems/word-search-ii/solution/
	 * 
	 * youtube: https://www.youtube.com/watch?v=5Ha1nJ5rjrE&feature=youtu.be&ab_channel=happygirlzt
	 * 
	 * 
	 *  37 / 37 test cases passed.
		Status: Accepted
		Memory Usage: 38960000
	 * 
	 */
	public static void main(String[] args) {
		
	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		if (board == null || board.length == 0)
			return res;

		TrieNode root = new TrieNode();
		buildTrie(root, words);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				char c = board[i][j];
				if (root.children[c - 'a'] != null) {
					dfs(board, i, j, root, res);
				}
			}
		}

		return res;
	}

	private void dfs(char[][] board, int i, int j, TrieNode cur,
			List<String> res) {
		if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1)
			return;

		if (board[i][j] == '#')
			return;
		char c = board[i][j];

		if (cur.children[c - 'a'] == null)
			return;
		cur = cur.children[c - 'a'];
		if (cur.word != null) {
			res.add(cur.word);
			cur.word = null;
		}

		board[i][j] = '#';
		dfs(board, i + 1, j, cur, res);
		dfs(board, i - 1, j, cur, res);
		dfs(board, i, j + 1, cur, res);
		dfs(board, i, j - 1, cur, res);
		board[i][j] = c;
	}

	private void buildTrie(TrieNode root, String[] words) {
		for (String s : words) {
			TrieNode cur = root;

			for (char c : s.toCharArray()) {
				int index = (int) (c - 'a');
				if (cur.children[index] == null) {
					cur.children[index] = new TrieNode();
				}
				cur = cur.children[index];
			}

			cur.word = s;
		}
	}

}
