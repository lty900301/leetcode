/**
 * String to Integer (atoi)
 * 
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself
 * what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to
 * gather all the input requirements up front.
 * 
 * @author joshluo
 * 
 */

/**
 * Requirements for atoi:
 * 
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is
 * found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical
 * digits as possible, and interprets them as a numerical value.
 * 
 * The string can contain additional characters after those that form the integral number, which are ignored and have no
 * effect on the behavior of this function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence
 * exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of
 * representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * 
 * @author leetcode
 * 
 */
public class StringToIntegerATOI {
    public int atoi(String str) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (str.length() == 0)
            return 0;

        // remove all the spaces ahead
        str = str.trim();

        // remove all the 0s ahead
        int index = 0;
        while (str.charAt(index) == '0') {
            index++;
        }
        str = str.substring(index);

        // find out if it's positive or negative
        int sign = 0;
        if (str.charAt(0) == '-') {
            sign = -1;
        } else if (str.charAt(0) == '+' || (str.charAt(0) >= '1' && str.charAt(0) <= '9')) {
            sign = 1;
        } else {
            sign = 0;
        }

        // remove the sign and 0s ahead
        if (str.charAt(0) == '+' || str.charAt(0) == '-')
            str = str.substring(1);
        index = 0;
        while (str.charAt(index) == '0') {
            index++;
        }
        str = str.substring(index);

        // find the valid number
        index = 0;
        while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            index++;
        }
        str = str.substring(0, index);

        // convert string to integer
        if (str.length() > 10) {
            if (sign > 0) {
                return Integer.MAX_VALUE;
            } else if (sign < 0) {
                return Integer.MIN_VALUE;
            }
        }
        int num = 0;
        int power = 1;
        while (str.length() > 0) {
            int addNum = (str.charAt(str.length() - 1) - '0') * power;
            if (((~0 ^ (1 << 31)) - num) < addNum) {
                if (sign > 0) {
                    num = ~0 ^ (1 << 31);
                } else if (sign < 0) {
                    num = 1 << 31;
                }
                break;
            }
            num += addNum;
            power *= 10;
            str = str.substring(0, str.length() - 1);
        }

        // return the result
        return num * sign;
    }
}
