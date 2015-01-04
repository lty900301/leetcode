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
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * 
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the
 * reversed integer might overflow. How would you handle such case?
 * 
 * There is a more generic way of solving this problem.
 * 
 * @author leetcode
 * 
 */

public class PalindromeNumber {

    /**
     * Better solution because of the update for Reverse Integer.
     */
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        return reverse(x) == x;
    }

    /**
     * {@link ReverseInteger#reverse(int)}
     */
    public int reverse(int x) {
        int result = 0;
        for (; x != 0; x /= 10) {
            long attemptResult = (long) result * 10 + x % 10;
            if (attemptResult > Integer.MAX_VALUE || attemptResult < Integer.MIN_VALUE) {
                return 0;
            }
            result = (int) attemptResult;
        }
        return result;
    }

    public boolean isPalindrome2(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (x < 0)
            return false;
        else if (x < 10)
            return true;

        int len = 0;
        int calcEnd = x;
        while (calcEnd > 0) {
            len++;
            calcEnd /= 10;
        }

        // reverse the integer
        int power = pow10(len - 1);

        int reverse = x;
        int newx = 0;
        while (reverse > 0) {
            newx += (reverse % 10) * power;
            power /= 10;
            reverse /= 10;
        }

        if (newx == x)
            return true;
        return false;
    }

    public int pow10(int factor) {
        return (int) Math.pow((double) 10, (double) factor);
    }
}
