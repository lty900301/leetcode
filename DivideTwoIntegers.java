/**
 * Divide Two Integers http://oj.leetcode.com/problems/divide-two-integers/
 * 
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * @author JoshLuo
 * 
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        int res = 0;
        if (dividend == Integer.MIN_VALUE) {
            res = 1;
            dividend += Math.abs(divisor);
        }
        if (divisor == Integer.MIN_VALUE) {
            return res;
        }
        boolean isNeg = (dividend > 0) ^ (divisor > 0);
        // Saving result negative or not and using positive parameters to do calc
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int digit = 0;
        while (divisor <= (dividend >> 1)) {
            divisor <<= 1;
            digit++;
        }
        while (digit >= 0) {
            if (dividend >= divisor) {
                dividend -= divisor;
                res += 1 << digit;
            }
            divisor >>= 1;
            digit--;
        }
        return isNeg ? -res : res;
    }

    public static void main(String args[]) {
        DivideTwoIntegers test = new DivideTwoIntegers();
        System.out.println(test.divide(1, 2));
    }
}
