package Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandom2 {

	public static void main(String[] args) {
		RandomizedSet2 obj = new RandomizedSet2();
		obj.insert(1);
		obj.insert(2);
		obj.insert(3);
		System.out.println(obj.remove(2));
	}

}
class RandomizedSet2 {
    List<Integer> list;
    Map<Integer, Integer> map;
    Random rand = new Random();
    
    
    /** Initialize your data structure here. */
    public RandomizedSet2() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        System.out.println("list.size():" + list.size());
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (! map.containsKey(val)) return false;
        int lastElement = list.get(list.size() - 1);
        System.out.println("lastElement:" + lastElement);
        int index = map.get(val);
        System.out.println("index:" + index);
        list.set(index, lastElement);
        map.put(lastElement, index);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}