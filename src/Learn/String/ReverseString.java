package Learn.String;

public class ReverseString {

	
	/*
	 * 344. Reverse String (Easy)
	 * 
	 * https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1183/
	 * 
	 * solution: https://leetcode.com/articles/reverse-string/
	 * 
	 * Write a function that reverses a string. The input string is given as an array of characters char[].
	 * 
	 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
	 * 
	 * You may assume all the characters consist of printable ascii characters.
	 * 
	 * Example 1:
	 * Input: ["h","e","l","l","o"]
	 * Output: ["o","l","l","e","h"]
	 * 
	 * Example 2:
	 * Input: ["H","a","n","n","a","h"]
	 * Output: ["h","a","n","n","a","H"]
	 * 
	 * Runtime: 1 ms, faster than 96.39% of Java online submissions for Reverse String.
	 * Memory Usage: 46.2 MB, less than 34.89% of Java online submissions for Reverse String.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(1)
	 * 
	 */
	
	public static void main(String[] args) {

	}
	
	public void reverseString(char[] s) {
        int i = 0 ;
		int j = s.length - 1 ;
		
		while(j>i){
			swap(s, j, i) ;
			j--;
			i++;
		}
		
    }
    
    private void swap(char[] s, int i, int j){
		char tmp = s[i] ;
		s[i] = s[j] ;
		s[j] = tmp ;
	}

}
