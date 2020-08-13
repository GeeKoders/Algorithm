package Stack;

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

}
