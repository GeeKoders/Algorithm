package recursionII;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {

	
	public static void main(String[] args) {
		
		LetterCombinationsofaPhoneNumber test = new LetterCombinationsofaPhoneNumber();
		List<String> res = test.letterCombinations("23") ;
		
		for(String item: res){
			System.out.println(item);
		}
		
	}
	/*
	 * 17. Letter Combinations of a Phone Number (Medium)
	 * 
	 * https://leetcode.com/explore/learn/card/recursion-ii/507/beyond-recursion/2905/
	 * 
	 * solution: https://leetcode.com/problems/letter-combinations-of-a-phone-number/solution/
	 * 
	 * reference:
	 * 
	 * https://www.youtube.com/watch?v=Dyj8EeupuiA&feature=youtu.be&ab_channel=happygirlzt
	 * 
	 * https://www.youtube.com/watch?v=a-sMgZ7HGW0&ab_channel=BackToBackSWE
	 * 
	 * 
	 *  25 / 25 test cases passed.
		Status: Accepted
        Runtime: 0 ms (Your runtime beats 100.00 % of java submissions.)
		Memory Usage: 37.7 MB (Your memory usage beats 89.15 % of java submissions.)
		
	 * 
	 */
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList();

		if (digits.length() == 0)
			return res;

		String[] mapping = { "", "", "acb", "def", "ghi", "jkl", "mno", "pqrs",
				"tuv", "wxyz" };
		helper(res, "", digits, mapping, 0);

		return res;
	}

	private void helper(List<String> res, String cur, String digits,
			String[] mapping, int index) {

		if (index == digits.length()) {
			res.add(cur);
			return;
		}
		// pos: [2, 3]
		int pos = (int) (digits.charAt(index) - '0');
		// candidates: ["acb", "def"]
		String candidates = mapping[pos];
		for (int i = 0; i < candidates.length(); i++) {
			helper(res, cur + candidates.substring(i, i + 1), digits, mapping,
					index + 1);
		}

	}

}
