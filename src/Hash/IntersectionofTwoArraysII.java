package Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IntersectionofTwoArraysII {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		IntersectionofTwoArraysII intersectionofTwoArraysII = new IntersectionofTwoArraysII() ;
		int []result = intersectionofTwoArraysII.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}) ;

	}
	
	public int[] intersect(int[] nums1, int[] nums2) {
        
        
		HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums1){
            int freq = map.getOrDefault(i, 0);
            map.put(i, freq + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
        	System.out.println(entry.getKey() + "," + entry.getValue());
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : nums2){
            if(map.get(i) != null && map.get(i) > 0){
                list.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        int[] ret = new int[list.size()]; 
        for(int i = 0; i < list.size();i++){
            ret[i] = list.get(i);
            System.out.println(ret[i]);
        }
        return ret;
        
        
    }

}
