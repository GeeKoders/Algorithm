package Hash;

import java.util.ArrayList;
import java.util.List;

public class MyHashSet {
	
	/*
	 * https://leetcode.com/explore/learn/card/hash-table/182/practical-applications/1139/
	 * 
	 * Design a HashSet without using any built-in hash table libraries.
	 * 
	 * To be specific, your design should include these functions:
	 * 
	 * add(value): Insert a value into the HashSet. 
	 * contains(value) : Return whether the value exists in the HashSet or not.
	 * remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
	 * 
	 * Example:
	 * MyHashSet hashSet = new MyHashSet();
	 * hashSet.add(1);   
	 * hashSet.add(2);    
	 * hashSet.contains(1);    // returns true
	 * hashSet.contains(3);    // returns false (not found)
	 * hashSet.add(2);     
	 * hashSet.contains(2);    // returns true
	 * hashSet.remove(2);
	 * hashSet.contains(2);    // returns false (already removed)
	 * 
	 * Note:
	 * All values will be in the range of [0, 1000000].
	 * The number of operations will be in the range of [1, 10000].
	 * Please do not use the built-in HashSet library.
	 * 
	 */

	public static void main(String[] args) {
		MyHashSet obj = new MyHashSet();
		obj.add(1) ;
		obj.add(2) ;
		System.out.println(obj.contains(1)) ;
		System.out.println(obj.contains(3)) ;
		obj.add(2) ;
		System.out.println(obj.contains(2)) ;
		obj.remove(2);
		System.out.println(obj.contains(2)) ;
		
	}
	
	public List<Integer> data ;

    /** Initialize your data structure here. */
    public MyHashSet() {
        data = new ArrayList<>() ;
    }
    
    public void add(int key) {
    	
    	boolean flag = true ;
    	
    	for(int i=0; i< data.size(); i++){
        	if(data.get(i) == key){
        		flag = false ;
            }
        }
    	
    	if(flag) data.add(key) ;
        
    }
    
    public void remove(int key) {
        if(data.isEmpty()){
            return ;
        }
        
        for(int i=0; i< data.size(); i++){
        	if(data.get(i) == key){
        		data.remove(i) ;
            }
        }
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(data.isEmpty()){
            return false ;
        }    
        for(int i=0; i<data.size(); i++){
        	
        	if(data.get(i) == key){
                return true ;
            }
        }
        
        return false;
    }

}
