/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * 
 * Reference:
 * http://yucoding.blogspot.com/2013/08/leetcode-question-133-palindrome.html
 * http://www.programcreek.com/2014/04/leetcode-palindrome-partitioning-ii-java/
 * https://leetcode.com/discuss/9476/solution-does-not-need-table-palindrome-right-uses-only-space
 * 
 * @author JoshLuo
 * 
 */
public class PalindromePartitioning2 {

    public int minCut(String s) {
        assert (s != null);
        int[] cut = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            cut[i] = Integer.MAX_VALUE;
        }
        cut[s.length()] = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            // odd length palindrome
            for (int a = i, b = i; a >= 0 && b < s.length() && s.charAt(a) == s.charAt(b); a--, b++)
                cut[a] = Math.min(cut[a], 1 + cut[b + 1]);
            // even length palindrome
            for (int a = i, b = i + 1; a >= 0 && b < s.length() && s.charAt(a) == s.charAt(b); a--, b++)
                cut[a] = Math.min(cut[a], 1 + cut[b + 1]);
        }
        return cut[0];
    }

}
