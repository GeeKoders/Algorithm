package Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class MinimumIndexSumofTwoLists {
	/*
	 * https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1177/
	 * solution: https://leetcode.com/problems/minimum-index-sum-of-two-lists/solution/
	 * 
	 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
	 * 
	 * You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of
	 * them with no order requirement. You could assume there always exists an answer.
	 * 
	 * Example 1:
	 * Input:
	 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
	 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
	 * Output: ["Shogun"]
	 * Explanation: The only restaurant they both like is "Shogun".
	 * 
	 * Example 2:
	 * Input:
	 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
	 * ["KFC", "Shogun", "Burger King"]
	 * Output: ["Shogun"]
	 * Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
	 * 
	 * Note:
	 * 1.The length of both lists will be in the range of [1, 1000].
	 * 2.The length of strings in both lists will be in the range of [1, 30].
	 * 3.The index is starting from 0 to the list length minus 1.
	 * 4.No duplicates in both lists.
	 * 
	 */
	public static void main(String[] args) {
		MinimumIndexSumofTwoLists minimumIndexSumofTwoLists = new MinimumIndexSumofTwoLists() ;
		String []list1 = {"A","B","C","D"} ;
		String []list2 = {"D","C","B","A"} ;
		String[] result = minimumIndexSumofTwoLists.findRestaurant(list1, list2) ;
		
		for(String item: result){
			System.out.println(item);
		}
		
		
	}
	//your runtime beats 9.26% of java submissions.
	public String[] findRestaurant(String[] list1, String[] list2) {
        
        int minValue = Integer.MAX_VALUE ;
        int tmp = Integer.MAX_VALUE ;
        
        Stack<Integer> stack = new Stack<>() ;
        
        for(int i=0; i<list1.length; i++){
          
            for(int j=0; j<list2.length; j++){
                if(list1[i].equals(list2[j])){
                    minValue = i + j ; 
                    System.out.println("i:" + i + ",j:" + j);
                    System.out.println("minValue:" + minValue);
                    if(minValue <= tmp){
                        tmp = minValue ;
                        stack.push(i) ;
                    }
                }
            }
        }
       
        if (stack.isEmpty()) return new String[]{} ;
        
        int count = 0 ;
        String result[] = new String[stack.size()] ;
        while(!stack.isEmpty()){
            result[count++] = list1[stack.pop()] ;
        }
        
        return result ;
        
    }
	
	public String[] findRestaurant2(String[] list1, String[] list2) {
        
        int minValue = Integer.MAX_VALUE ;
        List<String> result = new ArrayList<>() ;
        
        Map<String, Integer> map = new HashMap<>() ;
        
        for(int i=0; i<list1.length; i++){
            map.put(list1[i], i) ;   
        }
        
        for(int j=0; j<list2.length; j++){
            
            Integer i = map.get(list2[j]) ;
            
            if(i != null && i+j <= minValue){
             
                if(i+j < minValue){
                    result.clear() ;
                    minValue = i + j ;
                }
                
                result.add(list2[j]) ;
                
            }
            
            
        }
        
        return result.toArray(new String[result.size()]) ;
        
    }

}
