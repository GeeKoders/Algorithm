package Learn.Stack;

import java.util.Stack;

public class DecodeString {

	
	/*
	 * 394. Decode String (Medium)
	 * 
	 * https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1379/
	 * 
	 * solution: https://leetcode.com/problems/decode-string/solution/
	 * 
	 * Given an encoded string, return its decoded string.
	 * 
	 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k
	 * is guaranteed to be a positive integer.
	 * 
	 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
	 * 
	 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For
	 * example, there won't be input like 3a or 2[4].
	 * 
	 * Example 1:
	 * Input: s = "3[a]2[bc]"
	 * Output: "aaabcbc"
	 * 
	 * Example 2:
	 * Input: s = "3[a2[c]]"
	 * Output: "accaccacc"
	 * 
	 * Example 3:
	 * Input: s = "2[abc]3[cd]ef"
	 * Output: "abcabccdcdcdef"
	 * 
	 * Example 4:
	 * Input: s = "abc3[cd]xyz"
	 * Output: "abccdcdcdxyz"
	 * 
	 * Time complexity: O(maxK*n), where maxK is the maximum value of k and n is the length of a given string s.
	 * Space complexity: O(m + n), where m is the number of letters(a-z) and n is the number of digits(0-9) in string s
	 * 
	 */
	public static void main(String[] args) {
		DecodeString decodeString = new DecodeString() ;
		System.out.println(decodeString.decodeString("10[a]2[bc]"));
	}
	
	public String decodeString(String s) {
        
        Stack<Integer> count = new Stack<>() ;
        Stack<String> result = new Stack<>() ;
        
        int i = 0 ;
        result.push("") ;
        while(i < s.length()){
            
            char ch = s.charAt(i) ;
            
            if(ch >= '0' && ch <= '9'){
                int start = i ;
                while(s.charAt(i+1) >= '0' && s.charAt(i+1) <='9') i++ ;
                count.push(Integer.parseInt(s.substring(start, i+1))) ;
            }else if(ch == '['){
                result.push("") ;
            }else if(ch == ']'){
                String str = result.pop() ;
                StringBuilder sb = new StringBuilder() ;
                int times = count.pop() ;
                for(int j=0; j<times; j++){
                    sb.append(str) ;
                }
                
                result.push(result.pop() + sb.toString()) ;
            }else{
                
                result.push(result.pop() + ch) ;
                
            }
            
            i++ ;
            
        }
        
        return result.pop() ;
        
    }

}
