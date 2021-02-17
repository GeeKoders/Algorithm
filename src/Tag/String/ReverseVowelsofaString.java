package Tag.String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsofaString {
	/*
	 * 345. Reverse Vowels of a String (Easy)
	 * 
	 * https://leetcode.com/problems/reverse-vowels-of-a-string/
	 * 
	 * Runtime: 4 ms, faster than 60.86% of Java online submissions for Reverse Vowels of a String.
	 * Memory Usage: 38.9 MB, less than 80.62% of Java online submissions for Reverse Vowels of a String.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(k), k is the length of vowels
	 * 
	 * 
	 */
	public String reverseVowels(String s) {
		Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o',
				'u', 'A', 'E', 'I', 'O', 'U'));

		char[] arr = s.toCharArray();
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {

			while (left < right && !set.contains(arr[left])) {
				left++;
			}

			while (left < right && !set.contains(arr[right])) {
				right--;
			}

			swap(arr, left, right);

			left++;
			right--;
		}

		return new String(arr);

	}

	private void swap(char[] arr, int i, int j) {

		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}
}
