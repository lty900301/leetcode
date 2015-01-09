/**
 * Add Binary http://oj.leetcode.com/problems/add-binary/
 * 
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 * 
 * @author joshluo
 * 
 */

public class AddBinary {

    /**
     * 215 ms
     */
    public String addBinary(String a, String b) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (a == null || b == null)
            return null;
        int m = a.length();
        int n = b.length();
        if (m == 0 || n == 0)
            return null;
        int carry = 0;
        String rl = "";
        for (int i = 0; i < Math.max(m, n); i++) {
            int p = (i < m) ? a.charAt(m - 1 - i) - '0' : 0;
            int q = (i < n) ? b.charAt(n - 1 - i) - '0' : 0;
            int temp = carry + p + q;
            rl = temp % 2 + rl;
            carry = temp / 2;
        }
        return (carry == 0) ? rl : "1" + rl;
    }

    /**
     * 211 ms
     */
    public String addBinary2(String a, String b) {
        assert (a != null && b != null);
        int loopLimit = Math.min(a.length(), b.length());
        int carry = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < loopLimit; i++) {
            int digitA = a.charAt(a.length() - 1 - i) - '0';
            int digitB = b.charAt(b.length() - 1 - i) - '0';
            int digitResult = digitA + digitB + carry;
            carry = digitResult / 2;
            result.append(digitResult % 2);
        }
        result = result.reverse();
        a = a.substring(0, a.length() - loopLimit);
        b = b.substring(0, b.length() - loopLimit);
        if (carry > 0) {
            result.insert(0, addBinary("1", a.length() > 0 ? a : b));
        } else {
            result.insert(0, a.length() > 0 ? a : b);
        }
        return result.toString();
    }
}
