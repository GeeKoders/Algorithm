package Tag.Stack;

import java.util.List;
import java.util.Stack;

public class FlattenNestedListIterator {
	
	
	/*
	 * 341. Flatten Nested List Iterator (Medium)
	 * 
	 * https://leetcode.com/problems/flatten-nested-list-iterator/
	 * 
	 * solution: https://leetcode.com/problems/flatten-nested-list-iterator/solution/
	 * 
	 * reference: https://www.youtube.com/watch?v=sL-pte3XxlU&ab_channel=IllyaBailey
	 * 
	 * 
	 * 
	 * Runtime: 2 ms, faster than 98.22% of Java online submissions for Flatten Nested List Iterator.
	 * Memory Usage: 41.4 MB, less than 71.65% of Java online submissions for Flatten Nested List Iterator.
	 * 
	 * 
	 */
	private Stack<NestedInteger> stack = new Stack<>();

	public NestedIterator(List<NestedInteger> nestedList) {
		prepareStack(nestedList);
	}

	@Override
	public Integer next() {
		if (!hasNext())
			return null;
		return stack.pop().getInteger();
	}

	@Override
	public boolean hasNext() {

		while (!stack.isEmpty() && !stack.peek().isInteger()) {
			List<NestedInteger> list = stack.pop().getList();
			prepareStack(list);
		}

		return !stack.isEmpty();

	}

	private void prepareStack(List<NestedInteger> nestedList) {

		for (int i = nestedList.size() - 1; i >= 0; i--) {
			stack.push(nestedList.get(i));
		}

	}
}
