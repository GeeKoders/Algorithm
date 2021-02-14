package Tag.String;

public class ImplementStrStr {

	/*
	 * 28. Implement strStr() (Easy)
	 *  
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
	 * solution: https://leetcode.com/problems/implement-strstr/solution/
	 * 
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * 
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement strStr().
	 * Memory Usage: 37.2 MB, less than 98.42% of Java online submissions for Implement strStr().
	 * 
	 */
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
	
	public int strStr3(String haystack, String needle) {
        // empty needle appears everywhere, first appears at 0 index
        if (needle.length() == 0)
            return 0;
        if (haystack.length() == 0)
            return -1;
        
        
        for (int i = 0; i < haystack.length(); i++) {
            // no enough places for needle after i
            if (i + needle.length() > haystack.length()) break;
            
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j))
                    break;
                if (j == needle.length()-1)
                    return i;
            }
        }
        
        return -1;
    }
	
	/*
	 * Runtime: 2 ms, faster than 51.22% of Java online submissions for Implement strStr().
	 * Memory Usage: 37.9 MB, less than 49.70% of Java online submissions for Implement strStr().
	 * 
	 * Time complexity: Time complexity: O((N-L)L), O(N) is the best case of one single match
	 * Space complexity: O(1)
	 * 
	 */
	public int strStr4(String haystack, String needle) {
        
        if(needle.length() == 0 && haystack.length() == 0) return 0 ;
        
        if(needle.length() > haystack.length()) return -1 ;
        
        if(needle.length() == 0) return 0 ;
        
        for(int i=0; i<haystack.length(); i++){
            
            if(i + needle.length() > haystack.length()) break ;
            
            for(int j=0; j<needle.length(); j++){
            
                if(haystack.charAt(i+j) != needle.charAt(j)) break ;
                
                if(j == needle.length() - 1) return i ;
                
            }
            
        }
        
        return -1 ;
    }
	
}
