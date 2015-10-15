import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid
 * dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 * 
 * Reference: http://www.programcreek.com/2014/03/leetcode-word-break-ii-java/
 * @author JoshLuo
 * 
 */
public class WordBreak2 {

    @SuppressWarnings("unchecked")
    public List<String> wordBreak(String s, Set<String> wordDict) {
        assert (s != null && wordDict != null);
        // 1. Construct the array of word bank where words[i] holds all words that can end at index i.
        List<String>[] words = new ArrayList[s.length() + 1];
        words[0] = new ArrayList<String>();
        words[0].add("");
        for (int i = 1; i < s.length() + 1; i++) {
            List<String> listOfWords = new ArrayList<String>();
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                if (!words[j].isEmpty() && wordDict.contains(word)) {
                    listOfWords.add(word);
                }
            }
            words[i] = listOfWords;
        }
        // 2. From the end. DFS find all combinations.
        List<String> result = new ArrayList<String>();
        dfs(result, words, s.length(), new ArrayList<String>());
        return result;
    }

    public void dfs(List<String> result, List<String>[] words, int end, ArrayList<String> pathWords) {
        if (end == 0) {
            String path = pathWords.get(pathWords.size() - 1);
            for (int i = pathWords.size() - 2; i >= 0; i--) {
                path += " " + pathWords.get(i);
            }
            result.add(path);
            return;
        }
        for (String word : words[end]) {
            pathWords.add(word);
            dfs(result, words, end - word.length(), pathWords);
            pathWords.remove(pathWords.size() - 1);
        }
    }

    @Test
    public void test1() {
        Set<String> expected = new HashSet<String>(Arrays.asList(new String[] { "cats and dog", "cat sand dog" }));

        String s = "catsanddog";
        Set<String> wordDict = new HashSet<String>(Arrays.asList(new String[] { "cat", "cats", "and", "sand", "dog" }));
        Set<String> actual = new HashSet<String>(new WordBreak2().wordBreak(s, wordDict));

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        Set<String> expected = new HashSet<String>(Arrays.asList(new String[] {}));

        String s = "a";
        Set<String> wordDict = new HashSet<String>(Arrays.asList(new String[] {}));
        Set<String> actual = new HashSet<String>(new WordBreak2().wordBreak(s, wordDict));

        Assert.assertEquals(expected, actual);
    }

}
