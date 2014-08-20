/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it
 * would be if it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * [1,3,5,6], 5 ¡ú 2
 * [1,3,5,6], 2 ¡ú 1
 * [1,3,5,6], 7 ¡ú 4
 * [1,3,5,6], 0 ¡ú 0
 * 
 * @author joshluo
 */
public class SearchInsertPosition {

    public int searchInsert(int[] A, int target) {
        if (A == null) {
            return -1;
        } else if (A.length == 0) {
            return 0;
        }
        int start = 0, end = A.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == A[mid]) {
                return mid;
            } else if (target > A[mid]) {
                if (mid == A.length - 1) {
                    return A.length;
                } else {
                    start = mid + 1;
                }
                continue;
            } else {
                if (mid == 0 || target > A[mid - 1]) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        final int[] A = { 1, 2, 3, 5, 6 };
        final int target = 0;
        final SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        System.out.println(searchInsertPosition.searchInsert(A, target));
    }
}
