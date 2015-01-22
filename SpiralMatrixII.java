/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * 
 * For example,
 * Given n = 3, You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * @author joshluo
 * 
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        assert (n >= 0);
        int[][] matrix = new int[n][n];
        int[] xIncrement = { 0, 1, 0, -1 };// direction 0=right, 1=down, 2=left, 3=up
        int[] yIncrement = { 1, 0, -1, 0 };
        int x = 0, y = 0, direction = 0, rowVisited = 0, colVisited = 0, visited = 0;
        for (int i = 1; i <= n * n; i++) {
            int toVisit = (direction == 0 || direction == 2) ? n - colVisited : n - rowVisited;
            matrix[x][y] = i;
            visited++;
            if (visited == toVisit) {
                direction = (direction + 1) % 4;
                rowVisited += Math.abs(xIncrement[direction]);
                colVisited += Math.abs(yIncrement[direction]);
                visited = 0;
            }
            x += xIncrement[direction];
            y += yIncrement[direction];
        }
        return matrix;
    }

}
