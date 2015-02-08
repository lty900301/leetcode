import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in
 * complexity O(n).
 * 
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * 
 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string "".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * 
 * Reference: http://leetcode.com/2010/11/finding-minimum-window-in-s-which.html
 * 
 * @author joshluo
 * 
 */
public class MinimumWindowSubstring {

    public String minWindow(String S, String T) {
        assert (S != null && T != null);
        final Map<Character, Integer> needToFind = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            needToFind.put(c, needToFind.containsKey(c) ? needToFind.get(c) + 1 : 1);
        }
        final Map<Character, Integer> hasFound = new HashMap<Character, Integer>();
        int minWindowLen = Integer.MAX_VALUE, foundCount = 0, minWindowBegin = 0, minWindowEnd = T.length() - 1;
        for (int begin = 0, end = 0; end < S.length(); end++) {
            char c = S.charAt(end);
            if (needToFind.containsKey(c)) {
                hasFound.put(c, hasFound.containsKey(c) ? hasFound.get(c) + 1 : 1);
                if (hasFound.get(c) <= needToFind.get(c)) {
                    foundCount++;
                }
                // if window constraint is satisfied
                if (foundCount == T.length()) {
                    // advance begin index as far right as possible,
                    // stop when advancing breaks window constraint.
                    while (begin < end) {
                        char beginChar = S.charAt(begin);
                        if (needToFind.containsKey(beginChar)) {
                            if (hasFound.get(beginChar) > needToFind.get(beginChar)) {
                                hasFound.put(beginChar, hasFound.get(beginChar) - 1);
                            } else {
                                break;
                            }
                        }
                        begin++;
                    }
                    // update minWindow if a minimum length is met
                    int windowLen = end - begin + 1;
                    if (windowLen < minWindowLen) {
                        minWindowBegin = begin;
                        minWindowEnd = end;
                        minWindowLen = windowLen;
                    }
                }
            }
        }
        if (foundCount == T.length()) {
            return S.substring(minWindowBegin, minWindowEnd + 1);
        }
        return "";
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        System.out.println(solution.minWindow("ab", "b"));
    }
}
