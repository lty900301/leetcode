import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of
 * substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
 * 
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * 
 * You should return the indices: [0,9].
 * (order does not matter).
 * 
 * @author joshluo
 * 
 */
public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<Integer>();
        if (L == null || L.length == 0 || L[0].length() == 0 || S == null || S.length() == 0) {
            return result;
        }

        int wordsCount = L.length;
        int wordLength = L[0].length();

        Map<String, Integer> wordCountByWordMap = new HashMap<String, Integer>();
        for (String word : L) {
            if (wordCountByWordMap.containsKey(word)) {
                wordCountByWordMap.put(word, wordCountByWordMap.get(word) + 1);
            } else {
                wordCountByWordMap.put(word, 1);
            }
        }

        Map<String, Integer> wordCountByWordMapWorkingCopy = new HashMap<String, Integer>();
        for (int startIndex = 0; startIndex <= S.length() - wordLength * wordsCount; startIndex++) {
            resetWordCountByWordMap(wordCountByWordMapWorkingCopy, wordCountByWordMap);
            for (int index = startIndex; index <= S.length() - wordLength; index += wordLength) {
                String subS = S.substring(index, index + wordLength);
                if (wordCountByWordMapWorkingCopy.containsKey(subS)) {
                    int count = wordCountByWordMapWorkingCopy.get(subS);
                    if (count == 1) {
                        wordCountByWordMapWorkingCopy.remove(subS);
                    } else {
                        wordCountByWordMapWorkingCopy.put(subS, --count);
                    }
                    if (wordCountByWordMapWorkingCopy.size() == 0) {
                        // Found a combination
                        result.add(startIndex);
                        resetWordCountByWordMap(wordCountByWordMapWorkingCopy, wordCountByWordMap);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return result;
    }

    private static void resetWordCountByWordMap(Map<String, Integer> mapCopy, Map<String, Integer> originalMap) {
        mapCopy.clear();
        mapCopy.putAll(originalMap);
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords testClass = new SubstringWithConcatenationOfAllWords();
        String S = "barfoothefoobarman";
        String[] L = { "foo", "bar" };
        System.out.println(testClass.findSubstring(S, L));
    }
}
