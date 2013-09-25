/**
 * Palindrome Number
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author Josh Luo
 *
 */

/**
 * Some hints:
 * 
 * Could negative integers be palindromes? (ie, -1)
 * 
 * If you are thinking of converting the integer to string, note the restriction 
 * of using extra space.
 * 
 * You could also try reversing an integer. However, if you have solved the 
 * problem "Reverse Integer", you know that the reversed integer might overflow. 
 * How would you handle such case?
 * 
 * There is a more generic way of solving this problem.
 * 
 * @author leetcode
 *
 */

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x < 0) return false;
        else if(x < 10) return true;
        
        int len = 0;
        int calcEnd = x;
        while(calcEnd > 0){
            len++;
            calcEnd /= 10;
        }
        
        //reverse the integer
        int power = pow10(len - 1);
        
        int reverse = x;
        int newx = 0;
        while(reverse > 0){
            newx += (reverse % 10) * power;
            power /= 10;
            reverse /= 10;
        }
        
        
        if(newx == x) return true;
        return false;
    }
    
    public int pow10(int factor){
        return (int) Math.pow((double) 10, (double) factor);
    }
}
