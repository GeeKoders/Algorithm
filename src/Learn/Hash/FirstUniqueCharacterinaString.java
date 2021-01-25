package Hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstUniqueCharacterinaString {

	/*
	 * https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1120/
	 * solution: https://leetcode.com/problems/first-unique-character-in-a-string/solution/
	 * 
	 * Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
	 * Examples:
	 * 
	 * s = "leetcode"
	 * return 0.
	 * 
	 * s = "loveleetcode"
	 * return 2.
	 * 
	 * Note: You may assume the string contains only lowercase English letters.
	 * 
	 */
	public static void main(String[] args) {
		
	}
	
	public int firstUniqChar(String s) {
        
        if(s.length() < 1) return -1 ;
        if(s.length() == 1) return 0 ;
        
        for(int i=0; i<s.length();i++){
            int count = 0 ;    
            for(int j=0; j<s.length(); j++){
                
                if(j!=i){
                    if(s.charAt(i) == (s.charAt(j))){
                        break ;
                    }else{
                        count++ ;
                    }
                }
                
                
            }
            
            if(count!=0 && count == s.length() - 1){
                return i ;
            }
        }
        
        return -1 ;
        
    }
	
	public int firstUniqChar2(String s) {
		
		int freq[] = new int[26] ;
		
		for(int i=0; i<s.length(); i++){
			freq[s.charAt(i) - 'a'] ++ ;
		}
		
		for(int i=0; i<s.length(); i++){
			if(freq[s.charAt(i) - 'a'] == 1){
				return i ;
			}
		}
		
		return -1 ;
	}
	
	
	public int firstUniqChar3(String s) {
		Map<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                map.remove(s.charAt(i));
            } else {
                map.put(s.charAt(i), i);
                set.add(s.charAt(i));
            }
        }
        
        // for(Map.Entry<Character, Integer> entry: map.entrySet()){
        //     return entry.getValue() ;
        // }
        //return -1 ;
        return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();
    }

}
