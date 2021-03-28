package Tag.Array;

public class DotProductofTwoSparseVectors {

	
	/*
	 * 1570. Dot Product of Two Sparse Vectors (Medium)
	 * 
	 * https://leetcode.com/problems/dot-product-of-two-sparse-vectors/
	 * 
	 * solution: https://leetcode.com/problems/dot-product-of-two-sparse-vectors/solution/
	 * 
	 * Runtime: 2 ms, faster than 99.03% of Java online submissions for Dot Product of Two Sparse Vectors.
	 * Memory Usage: 53.8 MB, less than 56.02% of Java online submissions for Dot Product of Two Sparse Vectors.
	 * 
	 * Time complexity: O(N)
	 * Space complexity: O(1)
	 * 
	 * 
	 */
	private int[] array;

	SparseVector(int[] nums) {
		array = nums;
	}

	// Return the dotProduct of two sparse vectors
	public int dotProduct(SparseVector vec) {

		int res = 0;

		for (int i = 0; i < array.length; i++) {
			res += array[i] * vec.array[i];
		}

		return res;

	}
}
