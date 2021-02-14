package Tag.String;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DifferentWaystoAddParentheses {

	/*
	 * 241. Different Ways to Add Parentheses (Medium)
	 * 
	 * https://leetcode.com/problems/different-ways-to-add-parentheses/
	 * 
	 * discuss:
	 * 
	 * https://leetcode.com/problems/different-ways-to-add-parentheses/discuss/66328/A-recursive-Java-solution-(284-ms)
	 * 
	 * reference:
	 * 
	 * https://www.youtube.com/watch?v=binXv9-uT3A&ab_channel=codebix
	 * 
	 * Runtime: 8 ms, faster than 7.18% of Java online submissions for Different Ways to Add Parentheses.
	 * 
	 * Memory Usage: 40 MB, less than 9.28% of Java online submissions for Different Ways to Add Parentheses.
	 * 
	 * 
	 * 
	 * 
	 */
	public List<Integer> diffWaysToCompute(String input) {

		List<Integer> ret = new LinkedList<Integer>();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '-' || input.charAt(i) == '*'
					|| input.charAt(i) == '+') {
				String part1 = input.substring(0, i);
				String part2 = input.substring(i + 1);
				List<Integer> part1Ret = diffWaysToCompute(part1);
				List<Integer> part2Ret = diffWaysToCompute(part2);
				for (Integer p1 : part1Ret) {
					for (Integer p2 : part2Ret) {
						int c = 0;
						switch (input.charAt(i)) {
						case '+':
							c = p1 + p2;
							break;
						case '-':
							c = p1 - p2;
							break;
						case '*':
							c = p1 * p2;
							break;
						}
						ret.add(c);
					}
				}
			}
		}
		if (ret.size() == 0) {
			ret.add(Integer.valueOf(input));
		}
		return ret;
	}
	
	/*
	 * memoization
	 * 
	 * Runtime: 3 ms, faster than 24.26% of Java online submissions for Different Ways to Add Parentheses.
	 * Memory Usage: 38.9 MB, less than 64.66% of Java online submissions for Different Ways to Add Parentheses.
	 * 
	 */
	private Map<String, List<Integer>> map = new HashMap<>() ;
    
    public List<Integer> diffWaysToCompute2(String input) {
        
    List<Integer> ret = new LinkedList<Integer>();
        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) == '-' ||
                input.charAt(i) == '*' ||
                input.charAt(i) == '+' ) {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);
                List<Integer> part1Ret = map.getOrDefault(part1, diffWaysToCompute2(part1));
                List<Integer> part2Ret = map.getOrDefault(part2, diffWaysToCompute2(part2));
                for (Integer p1 :   part1Ret) {
                    for (Integer p2 :   part2Ret) {
                        int c = 0;
                        switch (input.charAt(i)) {
                            case '+': c = p1+p2;
                                break;
                            case '-': c = p1-p2;
                                break;
                            case '*': c = p1*p2;
                                break;
                        }
                        ret.add(c);
                    }
                }
            }
        }
        if (ret.size() == 0) {
            ret.add(Integer.valueOf(input));
        }
        
        map.put(input, ret) ;
        return ret;
    }
}
