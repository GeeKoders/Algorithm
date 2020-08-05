package String;

import java.util.ArrayList;

public class ReverseWordsInAStringIII {

	/*
	 * https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1165/
	 * 
	 * solution: https://leetcode.com/articles/reverse-words-in-a-string-iii/
	 * 
	 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
	 * 
	 * Example 1:
	 * Input: "Let's take LeetCode contest"
	 * Output: "s'teL ekat edoCteeL tsetnoc"
	 * 
	 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
	 * 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String reverseWords1(String s) {
        
        String [] arr = s.split(" ") ;
        
        StringBuilder sb = new StringBuilder() ;
        
        for(int i=0; i<arr.length; i++){
            
            char[] charArr = arr[i].toCharArray() ;
            
            int start = 0 ;
            int end = charArr.length - 1 ;
        
            while(start < end){
                swap(charArr, start, end) ;
                start++ ;
                end-- ;
            }
            
            for(char item : charArr){
                sb.append(item) ;
            }
            sb.append(" ") ;
        }
        
        return sb.toString().trim() ;
        
    }
    
    public void swap(char[] charArr, int i, int j){
        
        char tmp = charArr[i] ;
        charArr[i] = charArr[j] ;
        charArr[j] = tmp ;
        
    }
    //Time complexity : O(n), Space complexity : O(n)
    public String reverseWords2(String s) {
        String words[] = s.split(" ");
        StringBuilder res=new StringBuilder();
        for (String word: words)
            res.append(new StringBuffer(word).reverse().toString() + " ");
        return res.toString().trim();
    }
    //Without using pre-defined split and reverse function
    //Time complexity : O(n), Space complexity : O(n)
    public String reverseWords3(String s) {
        String words[] = split(s);
        StringBuilder res=new StringBuilder();
        for (String word: words)
            res.append(reverse(word) + " ");
        return res.toString().trim();
    }
    public String[] split(String s) {
        ArrayList < String > words = new ArrayList < > ();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                words.add(word.toString());
                word = new StringBuilder();
            } else
                word.append( s.charAt(i));
        }
        words.add(word.toString());
        return words.toArray(new String[words.size()]);
    }
    public String reverse(String s) {
      StringBuilder res=new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            res.insert(0,s.charAt(i));
        return res.toString();
    }

}
