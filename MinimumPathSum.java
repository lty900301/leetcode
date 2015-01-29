/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the
 * sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time. Similar to UniquePaths and UniquePaths2
 * 
 * @author joshluo
 * 
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        assert (grid != null && grid.length > 0 && grid[0].length > 0);
        int m = grid.length;
        int n = grid[0].length;
        int[] sums = new int[n];
        for (int row = m - 1; row >= 0; row--) {
            sums[n - 1] = grid[row][n - 1] + ((row == m - 1) ? 0 : sums[n - 1]);
            for (int col = n - 2; col >= 0; col--) {
                sums[col] = grid[row][col] + ((row == m - 1) ? sums[col + 1] : Math.min(sums[col], sums[col + 1]));
            }
        }
        return sums[0];
    }

}
