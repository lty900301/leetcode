/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 
 * @author joshluo
 *         http://leetcodenotes.wordpress.com/2013/10/20/leetcode-multiply-strings-%E5%A4%A7%E6%95%B4%E6%95%B0%E7%9A%84%
 *         E5%AD%97%E7%AC%A6%E4%B8%B2%E4%B9%98%E6%B3%95/
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        assert (num1 != null && num2 != null && num1.length() > 0 && num2.length() > 0);
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        // max length is num1.length + num2.length
        // eg. 9999*9999= 99980001 8 digits, only 10000*10000 would be 9 digits
        int[] d = new int[num1.length() + num2.length()];
        // eg. 385*97=5*7 + 10*(8*7+9*5) + 100*(3*7+8*9) + 1000*(3*9)
        for (int i = 0; i < num1.length(); i++) {
            int a = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int b = num2.charAt(j) - '0';
                d[i + j] += a * b; // i+j can represent how many 0s following 1xxx
            }
        }
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < d.length; i++) {
            int number = d[i] + carry;
            int digit = number % 10;
            carry = number / 10;
            result.append(digit);
        }
        result = result.reverse();
        // trim starting zeros
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String num1 = "1000";
        String num2 = "1000";
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        System.out.println(multiplyStrings.multiply(num1, num2));
    }
}
