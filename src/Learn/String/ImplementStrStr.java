package String;

public class ImplementStrStr {

	/*
	 * https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1161
	 * Implement strStr().
	 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
	 * 
	 * Example 1:
	 * Input: haystack = "hello", needle = "ll"
	 * Output: 2
	 * 
	 * Example 2:
	 * Input: haystack = "aaaaa", needle = "bba"
	 * Output: -1
	 * 
	 * Clarification:
	 * What should we return when needle is an empty string? This is a great question to ask during an interview.
	 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr()
	 * and Java's indexOf().
	 * 
	 * Constraints:
	 * haystack and needle consist only of lowercase English characters.
	 * 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle) ;
    }
	
	public int strStr2(String haystack, String needle) {
        
        for (int i = 0; ; i++) {
            for (int j = 0;  ; j++) {
                if (j == needle.length()) return i;
                 if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
        
    }

}
