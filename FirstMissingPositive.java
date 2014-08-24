import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * @author joshluo
 * 
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }
        int smallestPositive = Integer.MAX_VALUE;
        final Set<Integer> set = new HashSet<Integer>();
        for (int a : A) {
            set.add(a);
            if (a > 0) {
                smallestPositive = Math.min(a, smallestPositive);
            }
        }
        int firstMissingPositive = smallestPositive > 1 ? 1 : Integer.MAX_VALUE;
        for (int a : A) {
            if (!set.contains(a + 1) && a + 1 > 0) {
                firstMissingPositive = Math.min(a + 1, firstMissingPositive);
            }
        }
        return firstMissingPositive;
    }

    public static void main(String[] args) {
        int[] A = { 2 };
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println(firstMissingPositive.firstMissingPositive(A));
    }

}
