import java.util.Arrays;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * 
 * @author joshluo
 */
public class SearchForARange {

    public int[] searchRange(int[] A, int target) {
        int[] result = { -1, -1 };
        if (A == null || A.length == 0) {
            return result;
        }
        int leftIndex = 0, rightIndex = A.length - 1;
        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            if (target > A[midIndex]) {
                leftIndex = midIndex + 1;
            } else if (target < A[midIndex]) {
                rightIndex = midIndex - 1;
            } else {
                result[0] = searchLeft(A, target, leftIndex, midIndex);
                result[1] = searchRight(A, target, midIndex, rightIndex);
                return result;
            }
        }
        return result;
    }

    private int searchLeft(int[] A, int target, int leftIndex, int rightIndex) {
        assert (target == A[rightIndex]);
        if (target == A[leftIndex]) {
            return leftIndex;
        }
        int midIndex = (leftIndex + rightIndex) / 2;
        if (midIndex == leftIndex) {
            return rightIndex;
        }
        if (target == A[midIndex]) {
            if (target > A[midIndex - 1]) {
                return midIndex;
            } else {
                return searchLeft(A, target, leftIndex, midIndex);
            }
        } else {
            return searchLeft(A, target, midIndex, rightIndex);
        }
    }

    private int searchRight(int[] A, int target, int leftIndex, int rightIndex) {
        assert (target == A[leftIndex]);
        if (target == A[rightIndex]) {
            return rightIndex;
        }
        int midIndex = (leftIndex + rightIndex) / 2;
        if (target == A[midIndex]) {
            if (target < A[midIndex + 1]) {
                return midIndex;
            } else {
                return searchRight(A, target, midIndex, rightIndex);
            }
        } else {
            return searchRight(A, target, leftIndex, midIndex);
        }
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 3 };
        int target = 2;
        final SearchForARange testClass = new SearchForARange();
        System.out.println(Arrays.toString(testClass.searchRange(A, target)));
    }

}
