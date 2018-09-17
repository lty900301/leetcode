import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * Word Ladder http://oj.leetcode.com/problems/word-ladder/
 * 
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to
 * end, such that: 1. Only one letter can be changed at a time 2. Each intermediate word must exist in the dictionary
 * 
 * For example,
 * 
 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"]
 * 
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
 * 
 * Note: Return 0 if there is no such transformation sequence. All words have the same length. All words contain only
 * lowercase alphabetic characters.
 * 
 * @author joshluo
 * 
 */

public class WordLadder {

    // BFS
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (wordList == null || wordList.size() == 0 || beginWord.length() != endWord.length())
            return 0;
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();
        Set<String> visited = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        return ladderLength(wordList, visited, beginSet, endSet, 1);
    }

    private int ladderLength(Set<String> wordList, Set<String> visited, Set<String> beginSet, Set<String> endSet,
            int level) {
        if (beginSet.isEmpty())
            return 0;
        if (beginSet.size() > endSet.size())
            return ladderLength(wordList, visited, endSet, beginSet, level);
        visited.addAll(beginSet);
        visited.addAll(endSet);
        // the set for next level
        Set<String> set = new HashSet<String>();
        // for each string in the current level
        for (String s : beginSet) {
            for (int i = 0; i < s.length(); i++) {
                char[] chars = s.toCharArray();
                // change letter at every position
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    String word = new String(chars);
                    // found the word in other end(set)
                    if (endSet.contains(word)) {
                        return level + 1;
                    }
                    // if not, add to the next level
                    if (wordList.contains(word) && !visited.contains(word)) {
                        set.add(word);
                    }
                }
            }
        }
        return ladderLength(wordList, visited, set, endSet, level + 1);
    }

    @Test
    public void test() {
        Set<String> wordList = new HashSet<>(Arrays.asList("hot", "dog", "dot"));
        System.out.println(ladderLength("hot", "dog", wordList));
    }

}
