/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * 
 * Consider the following matrix:
 * 
 * [
 * [1, 3, 5, 7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * 
 * @author joshluo
 * 
 */
public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        assert (matrix != null);
        int m = matrix.length;
        int n = matrix[0].length;
        // find row index
        int start = 0, end = m - 1, rowIndex = -1;
        while (start >= 0 && end < m && start <= end) {
            int mid = (start + end) / 2;
            if (target < matrix[mid][0]) {
                end = mid - 1;
            } else if (target > matrix[mid][n - 1]) {
                start = mid + 1;
            } else {
                rowIndex = mid;
                break;
            }
        }
        if (rowIndex != -1) {
            start = 0;
            end = n - 1;
            while (start >= 0 && end < n && start <= end) {
                int mid = (start + end) / 2;
                if (target < matrix[rowIndex][mid]) {
                    end = mid - 1;
                } else if (target > matrix[rowIndex][mid]) {
                    start = mid + 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchA2DMatrix solution = new SearchA2DMatrix();
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
        System.out.println(solution.searchMatrix(matrix, 51));
    }
}
