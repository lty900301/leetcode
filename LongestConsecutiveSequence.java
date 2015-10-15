import java.util.HashMap;
import java.util.Map;

/**
 * Longest Consecutive Sequence
 * 
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * 
 * For example, Given [100, 4, 200, 1, 3, 2],The longest consecutive elements sequence is [1, 2, 3, 4]. Return its
 * length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * Solution:
 * Use a hashmap to map a number to its longest consecutive sequence length, each time find a new consecutive sequence,
 * only the begin number and end number need to be modified.
 * https://leetcode.com/discuss/25812/o-n-hashmap-java-solution
 * 
 * @author Josh Luo
 * 
 */

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] num) {
        assert (num != null);
        int longest = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // MAP <-> Length
        for (int i = 0; i < num.length; i++) {
            if (map.containsKey(num[i]))
                continue;
            map.put(num[i], 1);
            int end = num[i];
            int begin = num[i];
            if (map.containsKey(num[i] + 1))
                end = num[i] + map.get(num[i] + 1);
            if (map.containsKey(num[i] - 1))
                begin = num[i] - map.get(num[i] - 1);
            longest = Math.max(longest, end - begin + 1);
            map.put(end, end - begin + 1);
            map.put(begin, end - begin + 1);
        }
        return longest;
    }

}
