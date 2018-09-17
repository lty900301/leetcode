/**
 * Given two sparse matrices A and B, return the result of AB.
 * You may assume that A's column number is equal to B's row number.
 * 
 * Example: <code>
 * A = [
 *       [ 1, 0, 0],
 *       [-1, 0, 3]
 *     ]
 * 
 * B = [
 *       [ 7, 0, 0 ],
 *       [ 0, 0, 0 ],
 *       [ 0, 0, 1 ]
 *     ]
 * 
 *      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 * AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 *                   | 0 0 1 |
 * </code>
 */
public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        assert (A != null && B != null);
        int mA = A.length, nA = A[0].length, mB = B.length, nB = B[0].length;
        assert (nA == mB);
        int[][] result = new int[mA][nB];
        for (int i = 0; i < mA; i++) {
            for (int j = 0; j < nA; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < nB; k++) {
                        if (B[j][k] != 0)
                            result[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
        return result;

    }
}
