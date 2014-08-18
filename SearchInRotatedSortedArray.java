/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * 
 * @author joshluo
 */
public class SearchInRotatedSortedArray {

    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int leftIndex = 0, rightIndex = A.length - 1;
        while (leftIndex <= rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;

            int left = A[leftIndex];
            int right = A[rightIndex];
            int middle = A[middleIndex];
            if (target > middle) {
                if (middle <= right) {
                    if (target < right) {
                        leftIndex = middleIndex + 1;
                    } else if (target > right) {
                        rightIndex = middleIndex - 1;
                    } else {
                        return rightIndex;
                    }
                } else {
                    leftIndex = middleIndex + 1;
                }
            } else if (target < middle) {
                if (left <= middle) {
                    if (target > left) {
                        rightIndex = middleIndex - 1;
                    } else if (target < left) {
                        leftIndex = middleIndex + 1;
                    } else {
                        return leftIndex;
                    }
                } else {
                    rightIndex = middleIndex - 1;
                }
            } else {
                return middleIndex;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = { 4, 5, 6, 7, 8, 1, 2, 3 };
        int target = 8;
        SearchInRotatedSortedArray testObject = new SearchInRotatedSortedArray();
        System.out.println(testObject.search(A, target));
    }
}
