package String;

public class AddBinary {

	
	/*
	 * https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1160
	 * 
	 * Given two binary strings, return their sum (also a binary string).
	 * 
	 * The input strings are both non-empty and contains only characters 1 or 0.
	 * 
	 * Example 1:
	 * Input: a = "11", b = "1"
	 * Output: "100"
	 * 
	 * Example 2:
	 * Input: a = "1010", b = "1011"
	 * Output: "10101"
	 * 
	 * Constraints:
	 * Each string consists only of '0' or '1' characters.
	 * 1 <= a.length, b.length <= 10^4
	 * Each string is either "0" or doesn't contain any leading zero.
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		
		AddBinary addBinary = new AddBinary() ;
		System.out.println(addBinary.addBinary1("1001", "1101")) ;
	}
	
	/*
	 * 1.Intialize i & j index for a and from last character index of a & b
	 * 2.Loop over for both index until anyone reach 0, add last bit of both string along with
	 *   carry intilized with 0. reminder from 2 is the new bit and divide by 2 is carry.
	 * 3.check if i >= 0 repeat for string a
	 * 4.check if j >= 0 repeat for string b
	 * 5.check if carry != 0 - add carry in sb.
	 * 6.return reverse of sb.
	 */
	
	public String addBinary1(String a, String b) {
		
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int sum = 0;
        while(i >= 0 && j >= 0) {
            sum = a.charAt(i--) - '0' + b.charAt(j--) - '0' + carry;
            System.out.println("sum:" + sum);
            sb.append(sum % 2);
            carry = sum / 2;
        }
        
        while(i >= 0) {
            sum = a.charAt(i--) - '0' + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        
        while(j >= 0) {
            sum = b.charAt(j--) - '0' + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        
        if(carry != 0) sb.append(carry);
        
        return sb.reverse().toString();
    }
	
	public String addBinary2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
			if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        
        return sb.reverse().toString();
    }
	

}
