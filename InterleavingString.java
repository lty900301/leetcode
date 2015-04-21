import org.junit.Assert;
import org.junit.Test;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * 
 * @author joshluo
 * 
 */
public class InterleavingString {

    /**
     * 2D DP. Reference: http://blog.csdn.net/u011095253/article/details/9248073
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        assert (s1 != null && s2 != null && s3 != null);
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] match = new boolean[s1.length() + 1][s2.length() + 1];
        // init
        match[0][0] = true;
        for (int i = 1; i < match.length; i++) { // j == 0
            match[i][0] |= match[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j < match[0].length; j++) { // i == 0
            match[0][j] |= match[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        // compute
        for (int i = 1; i < match.length; i++) {
            for (int j = 1; j < match[0].length; j++) {
                match[i][j] |= match[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1);
                match[i][j] |= match[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1);
            }
        }
        return match[s1.length()][s2.length()];
    }

    /**
     * Recursive, exceed time limit.
     */
    public boolean isInterleave_recur(String s1, String s2, String s3) {
        assert (s1 != null && s2 != null && s3 != null);
        if (s1.isEmpty())
            return s2.equals(s3);
        if (s2.isEmpty())
            return s1.equals(s3);
        if (s3.isEmpty())
            return false;

        boolean result = false;
        char c = s3.charAt(0);
        if (c == s1.charAt(0))
            result |= isInterleave_recur(s1.substring(1), s2, s3.substring(1));
        if (c == s2.charAt(0))
            result |= isInterleave_recur(s1, s2.substring(1), s3.substring(1));
        return result;
    }

    @Test
    public void isInterleave_Test() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3_true = "aadbbcbcac";
        String s3_false = "aadbbbaccc";
        Assert.assertTrue(isInterleave(s1, s2, s3_true));
        Assert.assertFalse(isInterleave(s1, s2, s3_false));
    }

    @Test
    public void isInterleave_Test2() {
        String s1 = "cbcccbabbccbbcccbbbcabbbabcababbbbbbaccaccbabbaacbaabbbc";
        String s2 = "abcbbcaababccacbaaaccbabaabbaaabcbababbcccbbabbbcbbb";
        String s3 = "abcbcccbacbbbbccbcbcacacbbbbacabbbabbcacbcaabcbaaacbcbbbabbbaacacbbaaaabccbcbaabbbaaabbcccbcbabababbbcbbbcbb";
        Assert.assertTrue(isInterleave(s1, s2, s3));
    }
}
