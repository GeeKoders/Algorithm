package recursion;

public class ReverseString {

	public static void main(String[] args) {
		
		ReverseString reverseString = new ReverseString() ;
		char[] text1 = {'h','e','l','l','o'} ;
		char[] text2 = {'H','a','n','n','a', 'h'} ;
		char[] result = reverseString.solution1(text2) ;
		
		for(char items: result){
			System.out.print(items + " ");
		}
	}
	
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
	
	private void swap(char[] text, int i, int j){
		char tmp = text[i] ;
		text[i] = text[j] ;
		text[j] = tmp ;
	}

}
