import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 * 
 * Solution: compress the matrix to histogram (Accumulate column's 1). So that we can use the solution from {@link}
 * 
 * @author joshluo
 * 
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        assert (matrix != null);
        int m = matrix.length, n = (m == 0) ? 0 : matrix[0].length;
        int maxArea = 0;
        int[] histogram = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    histogram[j] = (i == 0) ? 1 : histogram[j] + 1;
                } else {
                    histogram[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, maxAreaInHistogram(histogram));
        }
        return maxArea;
    }

    private int maxAreaInHistogram(int[] height) {
        assert (height != null);
        Stack<Integer> incrementIndexes = new Stack<Integer>();
        int maxArea = 0;
        for (int i = 0; i <= height.length; i++) {
            // We add another bar in the end, which is height 0. So that we can clean indexes in stack in the end
            int currentHeight = i == height.length ? 0 : height[i];
            if (incrementIndexes.empty() || currentHeight > height[incrementIndexes.peek()]) {
                incrementIndexes.push(i);
            } else {
                int index = incrementIndexes.pop();
                // if all previous bar are higher than this one, width is i - 0
                // else we find the previous lower bar's height: previousLowBarHeight, width that meets current height
                // is (i - 1 - previousLowBarHeight)
                int widthForHeight = incrementIndexes.empty() ? i : (i - 1 - incrementIndexes.peek());
                maxArea = Math.max(maxArea, height[index] * widthForHeight);
                i--; // stay in here until we calculate all indexes in the stack
            }
        }
        return maxArea;
    }

}
