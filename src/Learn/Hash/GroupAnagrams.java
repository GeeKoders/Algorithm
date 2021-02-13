package Learn.Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	
	/*
	 * 49. Group Anagrams (Medium)
	 * 
	 * https://leetcode.com/explore/learn/card/hash-table/185/hash_table_design_the_key/1124/
	 * solution: https://leetcode.com/problems/group-anagrams/solution/
	 * 
	 * Given an array of strings, group anagrams together.
	 * 
	 * Example:
	 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
	 * Output:
	 * [
	 * 	["ate","eat","tea"],
	 * 	["nat","tan"],
	 * 	["bat"]
	 * ]
	 * 
	 * Note:
	 * All inputs will be in lowercase.
	 * The order of your output does not matter.
	 * 
	 * Runtime: 6 ms, faster than 81.35% of Java online submissions for Group Anagrams.
	 * Memory Usage: 42.1 MB, less than 64.45% of Java online submissions for Group Anagrams.
	 * 
	 * Time complexity: O(NKlogK), where N is the length of strs, and K is the maximum length of a string in strs. The outer loop has complexity O(N) as we iterate through each string. 
	 * Space complexity: O(NK), the total information content stored in ans.
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
        
        if(strs.length == 0) return new ArrayList<>() ;
        
        Map<String, List<String>> ans = new HashMap<>() ;
        
        for(String s: strs){
            
            char[] ca = s.toCharArray() ;
            Arrays.sort(ca) ;
            String key = String.valueOf(ca) ;
            if(!ans.containsKey(key)){
                ans.put(key, new ArrayList<String>()) ;
            }
            
            ans.get(key).add(s) ;
            
        }
        
        return new ArrayList<List<String>>(ans.values()) ;
        
        
        
    }

}
