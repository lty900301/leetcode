/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * 
 * click to show follow up.
 * 
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then
 * 1's and followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only constant space?
 * 
 * @author joshluo
 * 
 */
public class SortColors {

    public void sortColors(int[] A) {
        assert (A != null);
        int lastZero = 0, firstTwo = A.length - 1, i = 0;
        while (i <= firstTwo) {
            switch (A[i]) {
            case 0:
                swap(A, i, lastZero);
                lastZero++;
                i++;
                break;
            case 1:
                i++;
                break;
            case 2:
                swap(A, i, firstTwo);
                firstTwo--;
                break;
            default:
                throw new RuntimeException("The value: " + A[i] + " is not allowed");
            }
        }
    }

    private void swap(int[] A, int index1, int index2) {
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }

}
