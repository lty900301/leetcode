import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your
 * method will be called repeatedly many times with different parameters. How would you optimize it?
 * 
 * Design a class which receives a list of words in the constructor, and implements a method that takes two words word1
 * and word2 and return the shortest distance between these two words in the list.
 * 
 * For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = “coding”, word2 = “practice”, return 3. Given word1 = "makes", word2 = "coding", return 1.
 * 
 * Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class ShortestWordDistance2 {

    public class WordDistance {

        Map<String, List<Integer>> map;

        public WordDistance(String[] words) {
            assert (words != null);
            map = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (!map.containsKey(word)) {
                    map.put(word, new ArrayList<Integer>());
                }
                map.get(word).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            if (!map.containsKey(word1) || !map.containsKey(word2)) {
                return -1;
            }
            List<Integer> pos1s = map.get(word1);
            List<Integer> pos2s = map.get(word2);
            int i = 0, j = 0, distance = Integer.MAX_VALUE;
            while (i < pos1s.size() && j < pos2s.size()) {
                int pos1 = pos1s.get(i), pos2 = pos2s.get(j);
                if (pos1 > pos2) {
                    distance = Math.min(distance, pos1 - pos2);
                    j++;
                } else if (pos2 > pos1) {
                    distance = Math.min(distance, pos2 - pos1);
                    i++;
                } else {
                    return 0;
                }
            }
            return distance;
        }
    }
}
