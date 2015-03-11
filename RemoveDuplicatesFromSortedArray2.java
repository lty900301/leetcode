/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * 
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 * @author joshluo
 * 
 */
public class RemoveDuplicatesFromSortedArray2 {

    private static final int ALLOWED_DUPLICATES_COUNT = 2;

    public int removeDuplicates(int[] A) {
        assert (A != null);
        int lastIndex = 0, lastOccurance = Integer.MIN_VALUE, lastOccuranceCount = 0;
        for (int i = 0; i < A.length; i++) {
            int current = A[i];
            if (current == lastOccurance) {
                lastOccuranceCount++;
                if (lastOccuranceCount <= ALLOWED_DUPLICATES_COUNT) {
                    A[lastIndex] = current;
                    lastIndex++;
                }
            } else if (current > lastOccurance) {
                lastOccurance = current;
                lastOccuranceCount = 1;
                A[lastIndex] = current;
                lastIndex++;
            } else {
                throw new IllegalArgumentException("Array A is not sorted.");
            }
        }
        return lastIndex;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 2 };
        System.out.println(new RemoveDuplicatesFromSortedArray2().removeDuplicates(A));
        for (int i : A) {
            System.out.println(i);
        }
    }

}
