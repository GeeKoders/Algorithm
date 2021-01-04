package Trie;

public class Trie {
	
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
		
		public TrieNode get(char ch){
			return links[ch - 'a'] ;
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
		Trie obj = new Trie();
		obj.insert("abc");
		boolean param_2 = obj.search("abc");
		boolean param_3 = obj.startsWith("ab");
	}
	
	
	private TrieNode root ;
	 /** Initialize your data structure here. */
    public Trie() {
    	root = new TrieNode() ;
    }
    
    /** Inserts a word into the trie. */
    /*
     * Time complexity: O(m), where m is the key length
     * Space complexity: O(m)
     * 
     */
    public void insert(String word) {
       
    	TrieNode node = root ;
       
    	for(int i=0; i< word.length(); i++){
    		
    		char currentChar = word.charAt(i) ;
    		
    		if(!node.containsKey(currentChar)){
    			node.put(currentChar, new TrieNode());
    		}
    		
    		node = node.get(currentChar) ;
    		
    	}
        node.setEnd(); 
       
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
    }
	
}
