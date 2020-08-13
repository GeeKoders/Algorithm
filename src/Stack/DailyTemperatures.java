package Stack;

import java.util.Stack;

public class DailyTemperatures {

	/*
	 * https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1363/
	 * 
	 * solution: https://leetcode.com/problems/daily-temperatures/solution/
	 * 
	 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
	 * 
	 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
	 * 
	 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
	 * 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] dailyTemperatures(int[] T) {

		int[] result = new int[T.length];

		for (int i = 0; i < T.length; i++) {

			for (int j = i + 1; j < T.length; j++) {

				if (T[i] < T[j]) {
					result[i] = j - i;
					break;
				}

			}

		}

		// T[T.length - 1] = 0 ;

		return result;
	}
	
	public int[] dailyTemperatures2(int[] T) {
        
        for(int i=0; i<T.length; i++){
            
            int count = 0 ;
            
            for(int j=i+1; j<T.length ; j++){
                      
                if(T[i] < T[j]){
                    T[i] = j - i ;
                    break ;
                }else{
                    count++ ;
                    
                    if(i+count == T.length - 1){
                        T[i] = 0;
                    }
                }
                
            }
        
        }
        
        T[T.length - 1] = 0 ;
        
        return T ;
    }
	// https://www.youtube.com/watch?v=WGm4Kj3lhRI&t=129s
	public int[] dailyTemperatures3(int[] T) {
		
		int [] result = new int[T.length] ;
		
		Stack<Integer> stack = new Stack<>() ;
		
		for(int i=T.length-1; i>=0 ; i--){
			
			
			while(!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop() ;
			result[i] = stack.isEmpty() ? 0 : stack.peek() - i ;
			stack.push(i) ;
			
		}
		
		return result ;
		
	}

}
