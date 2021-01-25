package Trie;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairsII {

	
	/*
	 * 
		34 / 34 test cases passed.
		Status: Accepted
		Runtime: 11 ms (Your runtime beats 98.23 % of java submissions.)
		Memory Usage: 39.1 MB (Your memory usage beats 44.88 % of java submissions.)
	 * 
	 */
	
	public static void main(String[] args) {
		
	}
	
	private Map<String, Integer> map ;
	
	public MapSumPairsII(){
		map = new HashMap<>() ;
	}
	
	public void insert(String key, int val){
		map.put(key, val) ;
	}
	
	public int sum(String prefix){
		
		int result = 0 ;
		for(String key: map.keySet()){
			if(key.startsWith(prefix)){
				result += map.get(key) ;
			}
		}
		return result ;
	}
	
}
