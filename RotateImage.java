/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up:
 * Could you do this in-place?
 * 
 * Note: Please pay attention to the rotate limit and four points' coordinates.
 * 
 * @author joshluo
 * 
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        assert (matrix != null);
        int n = matrix.length;
        for (int depth = 0; depth < n / 2; depth++) {
            for (int i = depth; i < n - depth - 1; i++) {
                // four points that need to swap are:
                // (depth, i), (i, n-1-depth), (n-1-depth, n-1-i), (n-1-i, depth)
                int temp = matrix[n - 1 - i][depth]; // store (n-1-i, depth)
                matrix[n - 1 - i][depth] = matrix[n - 1 - depth][n - 1 - i];
                matrix[n - 1 - depth][n - 1 - i] = matrix[i][n - 1 - depth];
                matrix[i][n - 1 - depth] = matrix[depth][i];
                matrix[depth][i] = temp;
            }
        }
    }
}
