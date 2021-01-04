package Trie;

public class ImplementTrie {
	
	class TrieNode{
		
		private TrieNode[] links; 
		
		private int R = 26 ;
		
		private boolean isEnd ; 
		
		public TrieNode(){
			links = new TrieNode[R] ;
		}
		
		public boolean containsKey(char ch){
			return links[ch - 'a'] == null ;
		}
		
		public void put(char ch, TrieNode node){
			links[ch - 'a'] = node ;
		}
		
		public void setEnd(){
			isEnd = true ;
		}
		
		public boolean isEnd(){
			return isEnd ;
		}
		
		
	}
	

	/*
	 * https://leetcode.com/explore/learn/card/trie/147/basic-operations/1047/
	 * 
	 * solution: https://leetcode.com/problems/implement-trie-prefix-tree/solution/
	 * 
	 */
	public static void main(String[] args) {
		ImplementTrie obj = new ImplementTrie();
		obj.insert("abc");
		boolean param_2 = obj.search("abc");
		boolean param_3 = obj.startsWith("ab");
	}
	
	
	 /** Initialize your data structure here. */
    public ImplementTrie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
    }
	
}
