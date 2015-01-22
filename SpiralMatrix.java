import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * 
 * For example,
 * Given the following matrix:
 * 
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 * 
 * Solution Reference: http://fisherlei.blogspot.com/2013/01/leetcode-spiral-matrix.html
 * 
 * @author joshluo
 * 
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        assert (matrix != null);
        List<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int[] xIncrement = { 0, 1, 0, -1 };
        int[] yIncrement = { 1, 0, -1, 0 };
        // define direction: 0 means right, 1 means down, 2 means left, 3 means up
        int visitedRowCount = 0, visitedColCount = 0, row = matrix.length, col = matrix[0].length;
        int direction = 0, x = 0, y = 0, visited = 0;
        while (true) {
            int toVisitCount = (direction == 0 || direction == 2) ? col - visitedColCount : row - visitedRowCount;
            if (toVisitCount <= 0) {
                break;
            }
            result.add(matrix[x][y]);
            visited++;
            if (toVisitCount == visited) {
                direction = (direction + 1) % 4;
                visitedRowCount += Math.abs(xIncrement[direction]);
                visitedColCount += Math.abs(yIncrement[direction]);
                visited = 0;
            }
            x += xIncrement[direction];
            y += yIncrement[direction];
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix solution = new SpiralMatrix();
        int[][] matrix = { { 1 } };
        System.out.println(solution.spiralOrder(matrix));
    }
}
