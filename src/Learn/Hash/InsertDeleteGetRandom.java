package Hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class InsertDeleteGetRandom {

	
	/*
	 * https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1141/
	 * 
	 * Design a data structure that supports all following operations in average O(1) time.
	 * 1. insert(val): Inserts an item val to the set if not already present.
	 * 2. remove(val): Removes an item val from the set if present.
	 * 3. getRandom: Returns a random element from current set of elements (it's guaranteed that at least one element exists when this method
	 *    is called). Each element must have the same probability of being returned.
	 *    
	 */
	public static void main(String[] args) {
		RandomizedSet obj = new RandomizedSet();
		boolean param_1 = obj.insert(1);
		boolean param_2 = obj.remove(2);
		int param_3 = obj.getRandom();
		System.out.println(param_1);
		System.out.println(param_2);
		System.out.println(param_3);
	}

}

class RandomizedSet {

    
    Set<Integer> set = new HashSet<>() ;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        
        if(set.isEmpty()){
            set.add(val) ;
            return true ;
        }else{
            if(!set.contains(val)){
                set.add(val) ;
                return true;
            }
        }
        
        return false ;
        
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(set.isEmpty()){
            return false ;
        }else{
            if(set.contains(val)){
                set.remove(val) ;
                return true ;
            }
            
            return false ;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        
        Random rand = new Random() ;
        int index = rand.nextInt(set.size()) ;
        
//        List<Integer> list = new ArrayList<>() ;
//        
//        for(Integer item: set){
//            list.add(item) ;
//        }
        
        Integer[] result = set.toArray(new Integer[0]);
        
        
        return result[index] ;
        
    }
    
}
