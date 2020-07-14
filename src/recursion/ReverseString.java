package recursion;

public class ReverseString {

	
	/*
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
	 */
	
	
	public static void main(String[] args) {
		
		ReverseString reverseString = new ReverseString() ;
		char[] text1 = {'h','e','l','l','o'} ;
		char[] text2 = {'H','a','n','n','a', 'h'} ;
//		char[] result = reverseString.solution1(text2) ;
		
		int i = 0 ;
		int j = text1.length - 1 ;
		char[] result = reverseString.solution2(text1, i, j) ;
		
		for(char items: result){
			System.out.print(items + " ");
		}
	}
	
	// O(N) time complexity, O(1) space complexity
	public char[] solution1(char[] text){
		
		int i = 0 ;
		int j = text.length - 1 ;
		
		while(j>i){
			swap(text, j, i) ;
			j--;
			i++;
		}
		
		return text ;
	}
	
	// O(N) time complexity, O(N) space complexity
	public char[] solution2(char[] text, int i, int j){
		
		if(j>i){
			char tmp = text[i] ;
			text[i++] = text[j] ;
			text[j--] = tmp ;
			
			solution2(text, i, j) ;
		}

		return text ;
	}
	
	private void swap(char[] text, int i, int j){
		char tmp = text[i] ;
		text[i] = text[j] ;
		text[j] = tmp ;
	}

}
