package recursion;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {

		Factorial factorial = new Factorial() ;
		Scanner sc = new Scanner(System.in) ;
		System.out.print("Input your number:");
		int result = factorial.f(sc.nextInt()) ;
		System.out.println(result);
		
	}
	
	public int f(int n){
		
		if(n == 1){
			return 1 ;
		}else{
			return n * f(n-1) ;
		}
	}

}
