package String;

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

}
