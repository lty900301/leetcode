/**
 * This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the
 * list.
 * word1 and word2 may be the same and they represent two individual words in the list.
 * 
 * For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = “makes”, word2 = “coding”, return 1. Given word1 = "makes", word2 = "makes", return 3.
 * 
 * Note: You may assume word1 and word2 are both in the list.
 */
public class ShortestWordDistance3 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        assert (words != null && word1 != null && word2 != null);
        int dist = Integer.MAX_VALUE, pos1 = -1, pos2 = -1;
        boolean same = word1.equals(word2);
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                if (same) {
                    pos1 = pos2;
                    pos2 = i;
                } else {
                    pos1 = i;
                }
            } else if (word2.equals(words[i])) {
                pos2 = i;
            }
            dist = Math.min(dist, Math.abs(pos1 - pos2));
        }
        return dist;
    }
}
