
/**
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 * 
 * @author tianyil
 */
public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        return isMatch(s, p, false);
    }

    private boolean isMatch(String s, String p, boolean isOnlyFrontPartialMatch) {
        assert (s != null && p != null);
        if ((s.length() == 0 && p.length() == 0) || (p.length() == 1 && p.charAt(0) == '*')) {
            return true;
        }
        if (p.indexOf('*') == -1 && p.length() > s.length()) {
            return false;
        }
        while (s.length() > 0 && p.length() > 0) {
            if (p.charAt(0) == '*') {
                if (p.length() == 1) {
                    return true;
                } else {
                    String reversedS = new StringBuilder(s).reverse().toString();
                    String reversedP = new StringBuilder(p.substring(1)).reverse().toString();
                    return isMatch(reversedS, reversedP, true);
                }
            } else {
                if (isMatch(s.charAt(0), p.charAt(0))) {
                    s = s.substring(1);
                    p = p.substring(1);
                } else {
                    return false;
                }
            }
        }
        if (isOnlyFrontPartialMatch) {
            return p.length() == 0;
        }
        return (s.length() == 0 && p.length() == 0) || (p.length() == 1 && p.charAt(0) == '*');
    }

    private boolean isMatch(char s, char p) {
        if (p == '?' || p == '*') {
            return true;
        } else {
            return s == p;
        }
    }

    public static void main(String[] args) {
        String s = "babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab";
        String p = "***bba**a*bbba**aab**b";
        final WildcardMatching wildcardMatching = new WildcardMatching();
        long startTime = System.currentTimeMillis();
        System.out.println(wildcardMatching.isMatch(s, p));
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
