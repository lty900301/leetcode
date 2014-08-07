/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * 
 * Follow up: Did you use extra space? A straight forward solution using O(mn) space is probably a bad idea. A simple
 * improvement uses O(m + n) space, but still not the best solution.
 * 
 * Could you devise a constant space solution?
 * 
 * @author Josh Luo
 * 
 */

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        assert (matrix != null);

        // Search if there is 0 in first row and first column
        boolean firstRow0 = false;
        for (int col = 0; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0)
                firstRow0 = true;
        }
        boolean firstCol0 = false;
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0)
                firstCol0 = true;
        }

        // Use first row and first column to recode the 0 coordinates
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        // Set Zeros according to first row and column
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[row].length; col++) {
                if (matrix[0][col] == 0 || matrix[row][0] == 0)
                    matrix[row][col] = 0;
            }
        }

        // Set Zeros for the first row and first column
        if (firstRow0) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[0][col] = 0;
            }
        }
        if (firstCol0) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }
    }
}
