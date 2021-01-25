package Trie;

class WordDictionary {
    class TrieNode{
        private TrieNode[] children;
        private boolean isWord;
        public TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }
    
    /*
     * https://leetcode.com/explore/learn/card/trie/148/practical-application-i/1052/
     * 
     * solution: https://leetcode.com/explore/learn/card/trie/148/practical-application-i/1052/
     * 
     * youtube: https://www.youtube.com/watch?v=neb_2UK5Kuo&feature=youtu.be&ab_channel=happygirlzt
     * 
     * 
     * 
		13 / 13 test cases passed.
		Status: Accepted
		Runtime: 36 ms (Your runtime beats 93.64 % of java submissions.)
		Memory Usage: 50.1 MB (Your memory usage beats 33.30 % of java submissions.)
     * 
     */
    public static void main(String[] args) {
		
	}

    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    private void buildTrie(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }

        cur.isWord = true;
    }
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        buildTrie(word);
    }

    /** Returns if the word is in the data structure. A word could
    contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return find(word, 0, root);
    }

    private boolean find(String word, int index, TrieNode cur) {
        if (index == word.length()) {
            return cur.isWord;
        }

        char c = word.charAt(index);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (cur.children[i] != null) {
                    if (find(word, index + 1, cur.children[i])) return true;
                }
            }
            return false;
        } else {
            return cur.children[c - 'a'] != null &&
             find(word, index + 1, cur.children[c - 'a']);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */