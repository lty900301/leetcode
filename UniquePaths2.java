/**
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 *  [0,0,0],
 *  [0,1,0],
 *  [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * 
 * Note: m and n will be at most 100.
 * 
 * @author joshluo
 * 
 */
public class UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        assert (obstacleGrid != null);
        int m = obstacleGrid.length;
        assert (m > 0);
        int n = obstacleGrid[0].length;
        assert (n > 0);
        int[] maxV = new int[n];
        maxV[n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            maxV[n - 1] = obstacleGrid[i][n - 1] == 0 ? maxV[n - 1] : 0;
            for (int j = n - 2; j >= 0; j--) {
                maxV[j] += maxV[j + 1];
                if (obstacleGrid[i][j] == 1) {
                    maxV[j] = 0;
                }
            }
        }
        return maxV[0];
    }

}
