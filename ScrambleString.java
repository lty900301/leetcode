import java.util.Arrays;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * 
 * Below is one possible representation of s1 = "great": <br>
 * <code>
 *      great
 *     /     \
 *    gr     eat
 *   /  \   /   \
 *  g    r e     at
 *              /  \ 
 *             a    t
 * </code> <br>
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * 
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat". <br>
 * <code>
 *     rgeat
 *    /     \
 *   rg     eat
 *  / \    /   \
 * r   g  e     at
 *             /  \
 *            a    t
 * </code> <br>
 * We say that "rgeat" is a scrambled string of "great".
 * 
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae". <br>
 * <code>
 *     rgtae
 *    /     \
 *   rg     tae
 *  / \    /   \
 * r   g  ta    e
 *       /  \
 *      t    a
 * </code><br>
 * We say that "rgtae" is a scrambled string of "great".
 * 
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * 
 * Reference: http://www.blogjava.net/sandy/archive/2013/05/22/399605.html
 * Reference:
 * http://blog.unieagle.net/2012/10/23/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9Ascramble-string%EF%BC%8C%E4%B8%89%E7
 * %BB%B4%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92/
 * 
 * @author joshluo
 * 
 */
public class ScrambleString {

    /**
     * Recursive method
     */
    public boolean isScramble(String s1, String s2) {
        assert (s1 != null && s2 != null);

        // Some pre-check
        int len = s1.length();
        if (len != s2.length())
            return false;
        if (len == 0 || s1.equals(s2))
            return true;
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if (!String.valueOf(c1).equals(String.valueOf(c2)))
            return false;

        // Split two strings and use recursive
        for (int i = 1; i < len; i++) {
            // seporate s1 as [0,i - 1],[i, s1.size() - 1]
            String a1 = s1.substring(0, i);
            String a2 = s1.substring(i);
            {// see if forward order is ok
                String b1 = s2.substring(0, i);
                String b2 = s2.substring(i);
                if (isScramble(a1, b1) && isScramble(a2, b2)) {
                    return true;
                }
            }
            {// see if reverse order is ok
                String b1 = s2.substring(len - i);
                String b2 = s2.substring(0, len - i);
                if (isScramble(a1, b1) && isScramble(a2, b2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * DP
     */
    public boolean isScramble2(String s1, String s2) {

        // Some pre-check
        int len = s1.length();
        if (len != s2.length()) {
            return false;
        }
        if (len == 0) {
            return true;
        }
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();

        boolean[][][] result = new boolean[len][len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                result[0][i][j] = (c1[i] == c2[j]);
            }
        }

        for (int k = 2; k <= len; ++k) {
            for (int i = len - k; i >= 0; --i) {
                for (int j = len - k; j >= 0; --j) {
                    boolean r = false;
                    for (int m = 1; m < k && !r; ++m) {
                        r = (result[m - 1][i][j] && result[k - m - 1][i + m][j + m])
                                || (result[m - 1][i][j + k - m] && result[k - m - 1][i + m][j]);
                    }
                    result[k - 1][i][j] = r;
                }
            }
        }

        return result[len - 1][0][0];
    }

    public static void main(String args[]) {
        String s1 = "ab";
        String s2 = "ba";
        System.out.println(new ScrambleString().isScramble(s1, s2));
    }
}
