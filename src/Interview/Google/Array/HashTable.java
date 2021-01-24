package Interview.Google.Array;

import java.util.HashMap;
import java.util.Map;

public class HashTable {

	
	public static void main(String[] args) {
//		char [] str = "Hello world".toCharArray();
//		printFreq(str) ;
		
		char[] str = "◣⚽◢⚡◣⚾⚡◢".toCharArray();
	    printFreq2(str);
	}
	// ASCII http://www.asciitable.com/
	private static void printFreq(char[] str){
		
		int [] freq = new int[256] ;
		
		for(int i=0; i<str.length; i++){
			freq[str[i]] ++ ;
		}
		
		for(int i=0; i<freq.length; i++){
			if(freq[i] > 0){
				System.out.println("[" + (char)i + "] = " + freq[i]);
			}
			
		}
		
	}
	
	// We use hashmap because the above method waste too much memory
	private static void printFreq2(char[] str){
		
		Map<Character, Integer> freq = new HashMap() ;
		
		for(int i=0; i<str.length; i++){
			
			if(freq.containsKey(str[i])){
				freq.put(str[i], freq.get(str[i]) + 1) ;
			}else{
				freq.put( str[i], 1) ;
			}
		}
		
		for(Map.Entry<Character, Integer> entry: freq.entrySet()){
			System.out.println("[" + (char)entry.getKey() + "] = " + entry.getValue());
		}
		
		
	}
}
