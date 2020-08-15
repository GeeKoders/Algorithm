package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class EvaluateReversePolishNotation {

	/*
	 * https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1394/
	 * 
	 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
	 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
	 * 
	 * Note:
	 * Division between two integers should truncate toward zero.
	 * The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
	 * 
	 * Example 1:
	 * Input: ["2", "1", "+", "3", "*"]
	 * Output: 9
	 * Explanation: ((2 + 1) * 3) = 9
	 * 
	 * Example 2:
	 * Input: ["4", "13", "5", "/", "+"]
	 * Output: 6
	 * Explanation: (4 + (13 / 5)) = 6
	 * 
	 * Example 3:
	 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
	 * Output: 22
	 * Explanation: 
	 * 	((10 * (6 / ((9 + 3) * -11))) + 17) + 5
	 * = ((10 * (6 / (12 * -11))) + 17) + 5
	 * = ((10 * (6 / -132)) + 17) + 5
	 * = ((10 * 0) + 17) + 5
	 * = (0 + 17) + 5
	 * = 17 + 5
	 * = 22
	 */
	
	public int evalRPN(String[] tokens) {
		
		Stack<Integer> s = new Stack<>() ;
		
		Map<String, String> map = new HashMap<String, String>() ;
		map.put("+", "+") ;
		map.put("-", "-") ;
		map.put("*", "*") ;
		map.put("/", "/") ;
		
		for(int i=0; i<tokens.length; i++){
			
			if(map.containsKey(tokens[i])){
				
				int num1 = s.pop() ;
				int num2 = s.pop() ;
				
				if(tokens[i].equals("+")){
					s.push(num2 + num1) ;
				}else if(tokens[i].equals("-")){
					s.push(num2 - num1) ;
				}else if(tokens[i].equals("*")){
					s.push(num2 * num1) ;
				}else{
					s.push(num2 / num1) ;
				}
				
			}else{
				s.push(Integer.parseInt(tokens[i])) ;
			}
			
		}
		
		return s.peek() ;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
