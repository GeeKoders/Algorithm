package Learn.String;

public class LongestCommonPrefix {

	
	
	/*
	 * 14. Longest Common Prefix (Easy)
	 * 
	 * https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1162/
	 * 
	 * solution: https://leetcode.com/articles/longest-common-prefix/
	 * 
	 * Write a function to find the longest common prefix string amongst an array of strings.
	 * If there is no common prefix, return an empty string "".
	 * 
	 * Example 1:
	 * Input: ["flower","flow","flight"]
	 * Output: "fl"
	 * 
	 * Example 2:
	 * Input: ["dog","racecar","car"]
	 * Output: ""
	 * Explanation: There is no common prefix among the input strings.
	 * 
	 * Note:
	 * All given inputs are in lowercase letters a-z.
	 * 
	 * Time complexity : O(S), where S is the sum of all characters in all strings
	 * Space complexity : O(1)
	 * 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String longestCommonPrefix(String[] strs) {
        
        if(strs == null || strs.length == 0) return "" ;
        
        String pre = strs[0] ;
        
        for(int i=1; i<strs.length; i++){
            
            while(strs[i].indexOf(pre) != 0){
                pre = pre.substring(0, pre.length() - 1) ;
                System.out.println("pre:" + pre) ;
            }
            
        }
        
        return pre ;
        
        
        
    }

}
