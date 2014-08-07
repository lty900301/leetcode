import java.util.Stack;

/**
 * Reverse Integer
 * 
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * 
 * @author Josh Luo
 * 
 */

/**
 * Have you thought about this? Here are some good questions to ask before coding. Bonus points for you if you have
 * already thought through this!
 * 
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * 
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of
 * 1000000003 overflows. How should you handle such cases?
 * 
 * Throw an exception? Good, but what if throwing an exception is not an option? You would then have to re-design the
 * function (ie, add an extra parameter).
 * 
 * @author leetCode
 * 
 */

public class ReverseInteger {
    public int reverse(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (x == 0)
            return x;
        int sign = (x < 0) ? -1 : 1;
        return sign * reversePos(Math.abs(x));
    }

    int reversePos(int posNum) {
        Stack<Integer> reverse = new Stack<Integer>();
        while (posNum > 0) {
            reverse.push(posNum % 10);
            posNum /= 10;
        }
        int result = 0;
        int power = 1;
        while (!reverse.isEmpty()) {
            result += reverse.pop() * power;
            power *= 10;
        }
        return result;
    }
}
