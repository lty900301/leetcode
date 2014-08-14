import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending
 * order). The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand
 * column.
 * 1,2,3 ¡ú 1,3,2
 * 3,2,1 ¡ú 1,2,3
 * 1,1,5 ¡ú 1,5,1
 * 
 * @author joshluo
 * 
 *         Resulution example:
 *         7869872 -> 7872689
 *         0. n = A.length
 *         1. From A[n-1] to start, find the first A[i-1] = S < A[i], which means A[i] - A[n-1] are in descending order.
 *         2. From A[n-1] to A[i], find the first A[s] = T > S
 *         3. Swap S and T, then the array from A[i] to A[n-1] will be descending order
 *         4. Sort the values after A[i] to A[n-1] to ascending order. Divide and conquer to do swap.
 * 
 */
public class NextPermutation {

    public void nextPermutation(int[] num) {
        if (num == null || num.length <= 1) {
            return;
        }
        int n = num.length;
        // 1. From A[n-1] to start, find the first A[i-1] = S < A[i], which means A[i] - A[n-1] are in descending order.
        int indexS = -1;
        for (int i = n - 1; i > 0; i--) {
            if (num[i - 1] < num[i]) {
                indexS = i - 1;
                break;
            }
        }
        if (indexS >= 0) {
            // 2. From A[n-1] to A[i], find the first A[s] = T > S
            int indexT = -1;
            for (int i = n - 1; i > indexS; i--) {
                if (num[i] > num[indexS]) {
                    indexT = i;
                    break;
                }
            }
            // 3. Swap S and T
            if (indexT >= 0) {
                swapTwoNumbersInArray(num, indexS, indexT);
            }
        }
        reverseDescendingToAscending(num, indexS + 1, num.length - 1);
    }

    private void swapTwoNumbersInArray(int[] num, int index1, int index2) {
        int temp = num[index1];
        num[index1] = num[index2];
        num[index2] = temp;
    }

    private void reverseDescendingToAscending(int[] num, int startIndex, int endIndex) {
        if (startIndex >= endIndex || startIndex < 0 || endIndex > num.length - 1) {
            return;
        }
        swapTwoNumbersInArray(num, startIndex, endIndex);
        reverseDescendingToAscending(num, startIndex + 1, endIndex - 1);
    }

    public static void main(String[] args) {
        NextPermutation testCLass = new NextPermutation();
        int[] testCase = { 1, 2 };
        testCLass.nextPermutation(testCase);
        System.out.println(Arrays.toString(testCase));
    }
}
