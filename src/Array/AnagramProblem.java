package Array;

import java.util.Arrays;

public class AnagramProblem {

	public static void main(String[] args) {

		char[] firstWord = {'a', 'p', 'p', 'l', 'e'} ;
		char[] secondWord = {'e', 'l', 'p', 'b', 'a'} ;
		
		AnagramProblem anagramProblem = new AnagramProblem() ;
		boolean result = anagramProblem.solution1(firstWord, secondWord) ;
		
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

}
