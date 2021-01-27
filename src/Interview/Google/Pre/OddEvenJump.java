package Interview.Google.Pre;

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJump {
	
	
	
	public static void main(String[] args) {
		
		int [] A = {10,15,12,14,13} ;
		
		int n = A.length ;
		TreeMap<Integer, Integer> treeMap = new TreeMap() ;
		
		boolean [] odd = new boolean[n] ;
		boolean [] even = new boolean[n] ;
		
		odd[n - 1] = true ;
		even[n - 1] = true ;
		treeMap.put(A[n-1], n - 1) ;
		
		
		//http://tw.gitbook.net/java/util/treemap_ceilingentry.html
		for(Map.Entry map: treeMap.entrySet()){
			System.out.println(map.getKey() + ":" + map.getValue());
		}
		
		
		for(int i = n-2; i>=0 ; i--){
		
			Map.Entry oddEntry = treeMap.ceilingEntry(A[i]), evenEntry = treeMap.floorEntry(A[i]) ;
			if(oddEntry != null){
				System.out.println("i:" + i + ",keyOdd:" + oddEntry.getKey() + ",valueOdd:" + oddEntry.getValue());
			}
			
		}
		
	}

	/*
	 * 975. Odd Even Jump
	 * 
	 * https://leetcode.com/problems/odd-even-jump/
	 * 
	 * https://leetcode.com/problems/odd-even-jump/solution/
	 * 
	 * reference
	 * 
	 * https://www.youtube.com/watch?v=Z-MjnodQH3w&feature=youtu.be&ab_channel=happygirlzt
	 * 
	 * https://www.youtube.com/watch?v=r2I7KIqHTPU&ab_channel=NickWhite
	 * 
	 * brute-force (Time Limit Exceeded)
	 * 
	 * Time complexity: O(N^2)
	 * Space complexity: O(1)
	 * 
	 */
	public int oddEvenJumps(int[] A) {

		int n = A.length;
		if (n < 1)
			return 0;
		int res = 0;

		for (int i = 0; i < n; i++) {
			if (i == n - 1) {
				res++;
				break;
			}

			int value = A[i];
			int index = i;

			while (index < n) {

				value = A[index];
				index = findGreater(A, value, index + 1, n);
				if (index == n - 1) {
					res++;
					break;
				} else if (index == -1)
					break;

				value = A[index];
				index = findSmaller(A, value, index + 1, n);

				if (index == n - 1) {
					res++;
					break;
				} else if (index == -1)
					break;
			}

		}

		return res;

	}

	private int findGreater(int[] A, int value, int from, int to) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;

		for (int i = from; i < to; i++) {

			if (A[i] == value) {
				return A[i];
			}

			if (A[i] > value && min > A[i]) {
				min = A[i];
				minIndex = i;
			}
		}

		return minIndex;
	}

	private int findSmaller(int[] A, int value, int from, int to) {

		int max = Integer.MIN_VALUE;
		int maxIndex = -1;

		for (int i = from; i < to; i++) {
			if (A[i] == value) {
				return i;
			}

			if (A[i] < value && max < A[i]) {
				max = A[i];
				maxIndex = i;
			}

		}

		return maxIndex;

	}
	/*
	 * Approach2: TreeMap
	 * 
	 * 
	 * 
	 *  64 / 64 test cases passed.
		Status: Accepted
		Runtime: 51 ms (Your runtime beats 97.96 % of java submissions.)
		Memory Usage: 46.4 MB
	 * 
	 * 
	 * Time complexity: O(NlogN) 
	 * Space complexity: O(N)
	 * 
	 * discuss: https://leetcode.com/problems/odd-even-jump/discuss/217981/JavaC%2B%2BPython-DP-using-Map-or-Stack
	 * 
	 */
	public int oddEvenJumps2(int[] A) {
		
		int n = A.length ;
		TreeMap<Integer, Integer> treeMap = new TreeMap() ;
		
		boolean [] odd = new boolean[n] ;
		boolean [] even = new boolean[n] ;
		
		odd[n - 1] = true ;
		even[n - 1] = true ;
		treeMap.put(A[n-1], n - 1) ;
		
		for(int i = n-2; i>=0 ; i--){
		
			Map.Entry oddEntry = treeMap.ceilingEntry(A[i]), evenEntry = treeMap.floorEntry(A[i]) ;
					
			if(oddEntry != null){
				odd[i] = even[(int) oddEntry.getValue()] ;
			}
			
			if(evenEntry != null){
				even[i] = odd[(int) evenEntry.getValue()] ;
			}
			
			
			treeMap.put(A[i], i) ;
		}
		
		int res = 0 ;
		for(boolean b: odd){
			if(b) res ++ ;
		}
			
		return res ;
		
		
	}
}
