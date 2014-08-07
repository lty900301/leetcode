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
}
