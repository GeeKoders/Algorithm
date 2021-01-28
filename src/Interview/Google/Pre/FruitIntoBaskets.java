package Interview.Google.Pre;

public class FruitIntoBaskets {

	/*
	 * 904. Fruit Into Baskets (Medium)
	 * 
	 * https://leetcode.com/problems/fruit-into-baskets/
	 * 
	 * https://leetcode.com/problems/fruit-into-baskets/solution/
	 * 
	 * reference: 
	 * 
	 * https://www.youtube.com/watch?v=s_zu2dOkq80&ab_channel=NickWhite
	 * 
	 * https://www.youtube.com/watch?v=za2YuucS0tw&ab_channel=KevinNaughtonJr.
	 * 
	 * Runtime: 18 ms, faster than 72.28% of Java online submissions for Fruit Into Baskets.
	 * 
	 * Memory Usage: 85 MB, less than 10.23% of Java online submissions for Fruit Into Baskets.
	 *
	 *    input[3,3,3,1,2,1,1,2,3,3,4]
	 * curr_max 1 2 3 4 2 3 4 5 2 3 3
	 *      max 1 2 3 4 4 4 4 5 5 5 5
	 * 
	 * Time complexity: O(N) 
	 * Space complexity: O(1)
	 * 
	 * sliding window
	 */
	public int totalFruit(int[] tree) {

		int last_fruit = -1;
		int second_last_fruit = -1;
		int last_fruit_count = 0;
		int current_max = 0;
		int max = 0;

		for (Integer fruit : tree) {

			if (fruit == last_fruit || fruit == second_last_fruit) {
				current_max += 1;
			} else {
				current_max = last_fruit_count + 1;
			}

			if (fruit == last_fruit) {
				last_fruit_count++;
			} else {
				last_fruit_count = 1;
			}
			// update
			if (fruit != last_fruit) {
				second_last_fruit = last_fruit;
				last_fruit = fruit;
			}

			max = Math.max(current_max, max);
		}

		return max;

	}
}
