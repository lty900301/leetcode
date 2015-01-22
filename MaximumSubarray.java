/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * 
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * 
 * click to show more practice.
 * 
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which
 * is more subtle.
 * 
 * Solution reference: http://fisherlei.blogspot.com/2012/12/leetcode-maximum-subarray.html
 * 
 * @author joshluo
 * 
 */
public class MaximumSubarray {

    public int maxSubArray(int[] A) {
        assert (A != null && A.length > 0);
        int start = 0, end = A.length - 1;
        return maxSubArray(A, start, end);
    }

    private int maxSubArray(int[] A, int start, int end) {
        if (start > end) {
            return Integer.MIN_VALUE;
        }
        int mid = (start + end) / 2;
        int leftMax = maxSubArray(A, start, mid - 1);
        int rightMax = maxSubArray(A, mid + 1, end);
        // get the max around A[mid]
        int midMax = A[mid], sum = A[mid];
        for (int i = mid - 1; i >= start; i--) {
            sum += A[i];
            if (sum > midMax) {
                midMax = sum;
            }
        }
        sum = midMax;
        for (int i = mid + 1; i <= end; i++) {
            sum += A[i];
            if (sum > midMax) {
                midMax = sum;
            }
        }
        int maxOfLeftAndRight = Math.max(leftMax, rightMax);
        return Math.max(maxOfLeftAndRight, midMax);
    }

    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();
        int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(solution.maxSubArray(A));
    }
}
