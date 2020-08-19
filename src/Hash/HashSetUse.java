package Hash;

import java.util.HashSet;
import java.util.Set;

public class HashSetUse {

	public static void main(String[] args) {

		Set<Integer> hashSet = new HashSet<>() ;
		
		hashSet.add(3) ;
		hashSet.add(2) ;
		hashSet.add(1) ;
		
		hashSet.remove(2) ;
		
		if(!hashSet.contains(2)){
			 System.out.println("Key 2 is not in the hash set.");
		}
		
		System.out.println("The size of has set is: " + hashSet.size());
		
		for(Integer i: hashSet){
			System.out.println(i + " ");
		}
		
		hashSet.clear();
		
		if(hashSet.isEmpty()){
			System.out.println("hash set is empty now!");
		}
		
		
		
		
	}

}
