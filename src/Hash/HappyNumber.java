package Hash;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isHappy(int n) {
		
		Set<Integer> set = new HashSet<>() ;
		
		while(n!=1){
			
			int tmp = n ;
			int sum = 0 ;
			
			while(tmp > 0){
				int digit = tmp % 10 ;
				tmp += digit * digit ;
				tmp /= 10 ;
			}
			
			n = sum ;
			
			if(set.contains(n)){
				return false ;
			}else{
				set.add(n) ;
			}
		}
		
		return true ;
		
	}

}
