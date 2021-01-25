package recursion;

import java.util.HashMap;
import java.util.Scanner;

public class Fibonacci {

	
	/*
	 * https://leetcode.com/explore/learn/card/recursion-i/255/recursion-memoization/1661/
	 * 
	 * solution: https://leetcode.com/articles/fibonacci-number/
	 * 
	 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
	 * F(0) = 0,   F(1) = 1
	 * F(N) = F(N - 1) + F(N - 2), for N > 1.
	 * Given N, calculate F(N).
	 * 
	 * Example 1:
	 * Input: 2
	 * Output: 1
	 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
	 * 
	 * Example 2:
	 * Input: 3
	 * Output: 2
	 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
	 * 
	 * Example 3:
	 * Input: 4
	 * Output: 3
	 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
	 * 
	 */
	
	private Integer[] cache = new Integer[31];
	
	public static void main(String[] args) {

		Fibonacci fibonacci = new Fibonacci();
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your number:");
		int result = fibonacci.fib4(sc.nextInt());
		System.out.println(result);

	}

	public int f(int n) {

		if (n == 1 || n == 2) {
			return 1;
		} else {
			return f(n - 2) + f(n - 1);
		}

	}

	public int fib(int N) {

		HashMap<Integer, Integer> cache = new HashMap<>();

		if (cache.containsKey(N)) {
			return cache.get(N);
		}

		int result;

		if (N == 0) {
			result = 0;
		} else if (N == 1) {
			result = 1;
		} else {
			result = fib(N - 1) + fib(N - 2);
		}

		cache.put(N, result);

		return result;

	}
	// time complexity: O(N), space complexity: O(N)
	public int fib3(int N) {
		
        if (N <= 1) {
            return N;
        }
        cache[0] = 0;
        cache[1] = 1;
        return memoize(N);
    }

    public int memoize(int N) {
      if (cache[N] != null) {
          return cache[N];
      }
      cache[N] = memoize(N-1) + memoize(N-2);
      return memoize(N);
    }
    
    //tail recursion
    //https://notfalse.net/9/recursion
    public int fib4(int n) {
        return fib4(n, 0, 1);
    }

    private int fib4(int n, int a, int b) {
        if (n == 0) return a;
        return fib4(n - 1, b, a + b);
    }

}
