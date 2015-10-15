import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of
 * one or more dictionary words.
 * 
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * @author JoshLuo
 * 
 */
public class WordBreak {

    // Exceed time limit
    public boolean wordBreak2(String s, Set<String> wordDict) {
        assert (s != null && wordDict != null);
        if (s.isEmpty()) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            String firstWord = s.substring(0, i + 1);
            if (wordDict.contains(firstWord) && wordBreak(s.substring(i + 1), wordDict)) {
                return true;
            }
        }
        return false;
    }

    // Reference: http://fisherlei.blogspot.com/2013/11/leetcode-word-break-solution.html
    public boolean wordBreak(String s, Set<String> wordDict) {
        assert (s != null && wordDict != null);
        boolean[] t = new boolean[s.length() + 1];
        t[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int k = 0; k < i; k++) {
                t[i] = t[k] && wordDict.contains(s.substring(k, i));
                if (t[i]) {
                    break;
                }
            }
        }
        return t[s.length()];
    }

}
