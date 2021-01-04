package Trie;

import java.util.HashMap;
import java.util.Map;

public class TrieII {

	class TrieNode{
		
		public boolean isWord ;
		public Map<Character, TrieNode> map = new HashMap<>() ;
		
	}
	
	/*
	 * 15 / 15 test cases passed.
		Status: Accepted
		Runtime: 40 ms
		Memory Usage: 51 MB
	 * 
	 */
	public static void main(String[] args) {
		
	}
	
	private TrieNode root ;
	
	public TrieII(){
		root = new TrieNode() ;
	}
	
	public void insert(String word){
		
		TrieNode curr = root ;
		
		for(int i=0; i<word.length(); i++){
			
			char currLetter = word.charAt(i) ;
			
			if(curr.map.get(currLetter) == null){
				curr.map.put(currLetter, new TrieNode()) ;
			}
			curr = curr.map.get(currLetter) ;
			
		}
		curr.isWord = true ;
	}
	
	public boolean search(String word){
		
		TrieNode curr = root; 
		for(int i=0; i<word.length(); i++){
			
			char currLetter = word.charAt(i) ;
			if(curr.map.get(currLetter) != null){
				curr = curr.map.get(currLetter) ;
			}else{
				return false ;
			}
			
		}
		
		return curr != null && curr.isWord ; 
		
	}
	
	public boolean startsWith(String prefix) {
		
		TrieNode curr = root; 
		for(int i=0; i<prefix.length(); i++){
			
			char currLetter = prefix.charAt(i) ;
			if(curr.map.get(currLetter) != null){
				curr = curr.map.get(currLetter) ;
			}else{
				return false ;
			}
			
		}
		
		return true ;
	}
	
}
