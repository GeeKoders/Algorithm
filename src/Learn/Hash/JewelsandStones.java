package Hash;

import java.util.HashMap;
import java.util.Map;

public class JewelsandStones {

	/*
	 * https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1136/
	 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type
	 * of stone you have.  You want to know how many of the stones you have are also jewels.
	 * 
	 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different
	 * type of stone from "A".
	 * 
	 * Example 1:
	 * Input: J = "aA", S = "aAAbbbb"
	 * Output: 3
	 * 
	 * Example 2:
	 * Input: J = "z", S = "ZZ"
	 * Output: 0
	 * 
	 * Note:
	 * S and J will consist of letters and have length at most 50.
	 * The characters in J are distinct.
	 * 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int numJewelsInStones(String J, String S) {
        
        Map<Integer, Character> map = new HashMap<>() ;
        
        char[] jChar = J.toCharArray() ;
        
        for(int i=0; i<jChar.length; i++){
            map.put(i, jChar[i]) ;
        }
        
        char[] sChar = S.toCharArray() ;
        
        int result = 0 ;
        
        for(int i=0; i<sChar.length; i++){
            if(map.containsValue(sChar[i])){
                result++ ;
            }
        }
        
        return result ;
    }

}
