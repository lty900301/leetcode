import java.util.ArrayList;

/**
 * Generate Parentheses http://oj.leetcode.com/problems/generate-parentheses/
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is: "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * @author Josh Luo
 * 
 */

public class GenerateParenthese {
    public ArrayList<String> generateParenthesis(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        assert (n >= 0);
        if (n == 0)
            return new ArrayList<String>();
        return generateParenthesis(n, 0, 0, new StringBuffer());
    }

    // DFS
    public ArrayList<String> generateParenthesis(int n, int l, int r, StringBuffer buff) {
        ArrayList<String> result = new ArrayList<String>();
        if (l > n || r > n)
            return result;
        if (r == n) {
            result.add(buff.toString());
            return result;
        }
        if (l < n) {
            StringBuffer newBuf = new StringBuffer(buff);
            newBuf.append("(");
            result.addAll(generateParenthesis(n, l + 1, r, newBuf));
        }
        if (r < l) {
            StringBuffer newBuf = new StringBuffer(buff);
            newBuf.append(")");
            result.addAll(generateParenthesis(n, l, r + 1, newBuf));
        }
        return result;
    }
}
