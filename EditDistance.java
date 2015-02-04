/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation
 * is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * 
 * Reference:
 * http://en.wikipedia.org/wiki/Wagner-Fischer_algorithm
 * http://en.wikipedia.org/wiki/Edit_distance
 * http://www.cs.helsinki.fi/u/ukkonen/InfCont85.PDF
 * 
 * Runtime: O (m * n) Space: O( min(m, n) )
 * 
 * @author joshluo
 * 
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        assert (word1 != null && word2 != null);
        final String shortWord = word1.length() < word2.length() ? word1 : word2; // x-axis
        final String longWord = word1.length() < word2.length() ? word2 : word1; // y-axis
        int[] distance = new int[shortWord.length() + 1];
        for (int i = 0; i <= shortWord.length(); i++) {
            distance[i] = i;
        }
        for (int i = 1; i <= longWord.length(); i++) {
            int diagnal = distance[0];
            distance[0] = i;
            for (int j = 1; j <= shortWord.length(); j++) {
                if (longWord.charAt(i - 1) == shortWord.charAt(j - 1)) {
                    int above = distance[j];
                    distance[j] = diagnal;
                    diagnal = above;
                } else {
                    int above = distance[j];
                    int left = distance[j - 1];
                    distance[j] = Math.min(diagnal, Math.min(left, above)) + 1;
                    diagnal = above;
                }
            }
        }
        return distance[distance.length - 1];
    }

    public static void main(String[] args) {
        EditDistance solution = new EditDistance();
        System.out.println(solution.minDistance("Sunday", "Saturday"));
    }
}
