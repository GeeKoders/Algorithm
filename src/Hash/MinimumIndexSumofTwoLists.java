package Hash;

import java.util.Stack;

public class MinimumIndexSumofTwoLists {

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

}
