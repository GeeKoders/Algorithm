package Hash;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

	
	/*
	 * https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1117/
	 * 
	 * Given two strings s and t, determine if they are isomorphic.
	 * Two strings are isomorphic if the characters in s can be replaced to get t.
	 * 
	 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to
	 * the same character but a character may map to itself.
	 * 
	 * Example 1:
	 * Input: s = "egg", t = "add"
	 * Output: true
	 * 
	 * Example 2:
	 * Input: s = "foo", t = "bar"
	 * Output: false
	 * 
	 * Example 3:
	 * Input: s = "paper", t = "title"
	 * Output: true
	 * 
	 * Note:
	 * You may assume both s and t have the same length.
	 * 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isIsomorphic(String s, String t) {
        
        if(s.length() != t.length()) return false ;
        
        Map<Character, Character> map = new HashMap<>() ;
        
        for(int i=0; i<s.length(); i++){
         
            if(map.containsKey(s.charAt(i))){
                if(t.charAt(i) != map.get(s.charAt(i))){
                    return false ;
                }
                
            }else{
                
                if(map.containsValue(t.charAt(i))) return false ;
                map.put(s.charAt(i), t.charAt(i)) ;
            }
        }
        
        return true ;
        
    }
	
	
	public boolean isIsomorphic2(String s, String t) {
        
		 if(s.length() != t.length()) return false ;
	        
	        char[] sa = s.toCharArray() ;
	        char[] ta = t.toCharArray() ;
	        
	        Map<Character, Character> map = new HashMap<>() ;
	        
	        for(int i=0; i<sa.length; i++){
	         
	            if(map.containsKey(sa[i])){
	                if(ta[i] != map.get(sa[i])){
	                    return false ;
	                }
	                
	            }else{
	                
	                if(map.containsValue(ta[i])) return false ;
	                map.put(sa[i], ta[i]) ;
	            }
	        }
	        
	        return true ;
	        
	    }

}
