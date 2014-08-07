import java.util.*;

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
 * @author Josh Luo
 * 
 */

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 1;
        for (int i : num) {
            if (map.containsKey(i))
                continue;
            map.put(i, 1);
            if (map.containsKey(i - 1)) {
                max = Math.max(max, merge(map, i - 1, i));
            }
            if (map.containsKey(i + 1)) {
                max = Math.max(max, merge(map, i, i + 1));
            }
        }
        return max;
    }

    private int merge(HashMap<Integer, Integer> map, int left, int right) {
        int upper = right + map.get(right) - 1;
        int lower = left - map.get(left) + 1;
        int len = upper - lower + 1;
        map.put(upper, len);
        map.put(lower, len);
        return len;
    }
}
