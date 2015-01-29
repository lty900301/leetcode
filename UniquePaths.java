/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * https://oj.leetcode.com/problems/unique-paths/
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 * 
 * Note: m and n will be at most 100.
 * 
 * Reference: http://leetcode.com/2010/11/unique-paths.html
 * 
 * @author joshluo
 * 
 */
public class UniquePaths {

    /**
     * http://leetcode.com/2010/11/unique-paths.html
     * Combination Solution. Smartest
     */
    public int uniquePaths(int m, int n) {
        assert (m > 0 && n > 0);
        if (m == 1 || n == 1) {
            return 1;
        }
        return choose(m + n - 2, m - 1).intValue();
    }

    private Long choose(int n, int k) {
        Long result = Long.valueOf(1);
        if (n == k) {
            return result;
        }
        k = Math.min(n - k, k);
        for (int i = 1; i <= k; n--, i++) {
            result = result * n / i;
        }
        return result;
    }

    /**
     * http://fisherlei.blogspot.com/2013/01/leetcode-unique-paths.html
     * Very smart. Saves lot of space. 200 ms
     */
    public int uniquePaths3(int m, int n) {
        int[] maxV = new int[n];
        maxV[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                maxV[j] = maxV[j - 1] + maxV[j];
            }
        }
        return maxV[n - 1];
    }

    /*
     * http://leetcode.com/2010/11/unique-paths.html
     * 187 ms
     */
    private static final int M_MAX = 100;
    private static final int N_MAX = 100;

    public int uniquePaths2(int m, int n) {
        int matrix[][] = new int[M_MAX + 2][N_MAX + 2];
        matrix[m][n + 1] = 1;
        for (int x = m; x >= 1; x--) {
            for (int y = n; y >= 1; y--) {
                matrix[x][y] = matrix[x + 1][y] + matrix[x][y + 1];
            }
        }
        return matrix[1][1];
    }

    /**
     * Runtime too long. Not going to pass solution.uniquePaths1(23, 12)
     */
    public int uniquePaths1(int m, int n) {
        int startX = 0;
        int startY = 0;
        int endX = m - 1;
        int endY = n - 1;
        return uniquePaths(startX, startY, endX, endY);
    }

    private int uniquePaths(int startX, int startY, int endX, int endY) {
        if (startX > endX || startY > endY) {
            return 0;
        } else if (startX == endX && startY == endY) {
            return 1;
        } else {
            return uniquePaths(startX + 1, startY, endX, endY) + uniquePaths(startX, startY + 1, endX, endY);
        }
    }

    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();
        System.out.println(solution.uniquePaths(23, 12));
    }

}
