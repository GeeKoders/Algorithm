package recursionII;

import java.util.HashSet;
import java.util.Set;

import javafx.util.Pair;


public class RobotRoomCleaner {

	
	/*
	 * https://leetcode.com/problems/robot-room-cleaner/
	 * 
	 * soltuion: https://leetcode.com/problems/robot-room-cleaner/solution/
	 * 
	 * youtube: https://www.youtube.com/watch?v=y4izHfShEfU&ab_channel=M.C%E7%B1%B3%E5%BC%80%E6%9C%97%E5%9F%BA%E7%BD%97
	 * 
	 * 
		29 / 29 test cases passed.
		Status: Accepted
		Runtime: 3 ms (Your runtime beats 99.16 % of java submissions.)
		Memory Usage: 38.9 MB (Your memory usage beats 77.90 % of java submissions.)
	 * 
	 * 
	 */
	public static void main(String[] args) {
		
	}
	
	// going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
	int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	Set<Pair<Integer, Integer>> visited = new HashSet();
	Robot robot;

	public void backtrack() {
		robot.turnRight();
		robot.turnRight();
		robot.move();
		robot.turnRight();
		robot.turnRight();
	}

	public void dfs(int row, int col, int dir) {
		visited.add(new Pair(row, col));
		robot.clean();
		// going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
		for (int i = 0; i < 4; ++i) {
			int newDir = (dir + i) % 4;
			int newRow = row + directions[newDir][0];
			int newCol = col + directions[newDir][1];

			if (!visited.contains(new Pair(newRow, newCol)) && robot.move()) {
				dfs(newRow, newCol, newDir);
				backtrack();
			}
			// turn the robot following chosen direction : clockwise
			robot.turnRight();
		}
	}

	public void cleanRoom(Robot robot) {
		this.robot = robot;
		dfs(0, 0, 0);
	}

}
