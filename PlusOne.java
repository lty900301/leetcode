/**
 * Plus One
 * 
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * 
 * @author joshluo
 * 
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null)
            return digits;
        int carry = 1;
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1] += carry;
            return digits;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i] + carry;
            digits[i] = temp % 10;
            carry = temp / 10;
        }
        if (carry > 0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }
}
