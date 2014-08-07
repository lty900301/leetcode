/**
 * Median of Two Sorted Arrays
 * 
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The
 * overall run time complexity should be O(log (m+n)).
 * 
 * @author Josh Luo
 * @reference http://gongxuns.blogspot.com/2012/12/leetcodemedian-of-two-sorted-arrays.html
 */

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = A.length, n = B.length;
        assert (m + n > 0);
        if (m == 0)
            return (n % 2 == 0) ? (B[n / 2 - 1] + B[n / 2]) / 2.0 : (double) B[n / 2];
        if (n == 0)
            return (m % 2 == 0) ? (A[m / 2 - 1] + A[m / 2]) / 2.0 : (double) A[m / 2];

        int firstMid = 0;
        int firstMidLoc = findKthInTwoSortedArrays(A, B, (m + n) / 2 + 1);
        if (firstMidLoc >= 0) {
            firstMid = A[firstMidLoc];
        } else {
            firstMidLoc = findKthInTwoSortedArrays(B, A, (m + n) / 2 + 1);
            firstMid = B[firstMidLoc];
        }

        if ((m + n) % 2 == 1)
            return (double) firstMid;

        int secondMid = 0;
        int secondMidLoc = findKthInTwoSortedArrays(A, B, (m + n) / 2);
        if (secondMidLoc >= 0) {
            secondMid = A[secondMidLoc];
        } else {
            secondMidLoc = findKthInTwoSortedArrays(B, A, (m + n) / 2);
            secondMid = B[secondMidLoc];
        }

        return (firstMid + secondMid) / 2.0;
    }

    int findKthInTwoSortedArrays(int A[], int B[], int k) {
        int start = 0, end = A.length - 1;
        while (start <= end) {
            int cur = (start + end) / 2;
            if (cur < k && k <= B.length + cur + 1 && (k == cur + 1 || A[cur] >= B[k - cur - 2])
                    && (k > cur + B.length || A[cur] <= B[k - cur - 1])) {
                return cur;
            } else if (cur >= k || (k <= cur + B.length && A[cur] > B[k - 1 - cur])) {
                end = cur - 1;
            } else {
                start = cur + 1;
            }
        }
        return -1;
    }
}
