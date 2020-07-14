package recursion;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		Fibonacci fibonacci = new Fibonacci();
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your number:");
		int result = fibonacci.f(sc.nextInt());
		System.out.println(result);

	}

	public int f(int n) {

		if (n == 1 || n == 2) {
			return 1;
		} else {
			return f(n - 2) + f(n - 1);
		}

	}

}
