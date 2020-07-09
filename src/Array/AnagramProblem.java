package Array;

import java.util.Arrays;

public class AnagramProblem {

	public static void main(String[] args) {

		char[] firstWord = {'a', 'p', 'p', 'l', 'e'} ;
		char[] secondWord = {'e', 'l', 'p', 'b', 'a'} ;
		String one = "Select" ;
		String two = "leScet" ;
		AnagramProblem anagramProblem = new AnagramProblem() ;
//		boolean result = anagramProblem.solution1(firstWord, secondWord) ;
		boolean result = anagramProblem.solution2(one, two) ;
		
		System.out.println(result);
	}
	
	public boolean solution1(char[] firstWord, char[] secondWord){
		
		if(firstWord.length != secondWord.length) return false ;
			
		//O(logN)
		Arrays.sort(firstWord);
		Arrays.sort(secondWord);
		
		//O(N)
		for(int i=0; i<firstWord.length; i++){
			
			if(firstWord[i] != secondWord[i]){
				return false ;
			}
		}
		
		return true ;
		
	}
	
	public boolean solution2(String one, String two){
		
		char[] firstWord = one.toLowerCase().toCharArray() ;
		char[] secondWord = two.toLowerCase().toCharArray() ;
		
		if(firstWord.length != secondWord.length) return false ;
			
		//O(logN)
		Arrays.sort(firstWord);
		Arrays.sort(secondWord);
		
		//O(N)
		for(int i=0; i<firstWord.length; i++){
			
			if(firstWord[i] != secondWord[i]){
				return false ;
			}
		}
		
		return true ;
		
	}


}
