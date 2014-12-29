import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than
 * [n/2] times.
 * 
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 * 
 * @author joshluo
 * 
 */
public class MajorityElement {

    /**
     * Runtime: O(n) Space: O(1)
     * Moore voting algorithm: We maintain a current candidate and a counter initialized to 0. As we iterate the array,
     * we look at the current element x:
     * If the counter is 0, we set the current candidate to x and the counter to 1.
     * If the counter is not 0, we increment or decrement the counter based on whether x is the current candidate.
     * After one pass, the current candidate is the majority element. Runtime complexity = O(n).
     */
    public int majorityElement(int[] num) {
        if (num == null || num.length < 1) {
            return Integer.MIN_VALUE;
        }
        int candidate = num[0];
        int counter = 0;
        for (int element : num) {
            if (counter == 0) {
                candidate = element;
                counter = 1;
            } else {
                counter += (candidate == element) ? 1 : -1;
            }
        }
        return candidate;
    }

    /**
     * Runtime: O(n), Space: O(n)
     * Hash table: Maintain a hash table of the counts of each element, then find the most common one.
     */
    public int majorityElement2(int[] num) {
        int lowerBound = num.length / 2;
        final Map<Integer, Integer> countForElement = new HashMap<Integer, Integer>();
        for (int element : num) {
            if (!countForElement.containsKey(element)) {
                countForElement.put(element, 1);
            } else {
                countForElement.put(element, countForElement.get(element) + 1);
            }
            if (countForElement.get(element) > lowerBound) {
                return element;
            }
        }
        return -1;
    }
}
