/**
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 * 
 * @author joshluo
 * 
 */
public class SearchInRotatedSortedArray2 {

    public boolean search(int[] A, int target) {
        assert (A != null);
        int start = 0, end = A.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == A[mid]) {
                return true;
            } else if (A[start] < A[mid]) {
                // Left must be sorted
                if (target >= A[start] && target < A[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (A[start] > A[mid]) {
                // right must be sorted
                if (target > A[mid] && target <= A[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else { // skip duplicate one, A[start] == A[mid]
                start++;
            }
        }
        return false;
    }

}
