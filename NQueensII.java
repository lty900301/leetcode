/**
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 * 
 * @author joshluo
 * 
 */
public class NQueensII {

    int result = 0;

    public int totalNQueens(int n) {
        assert (n > 0);
        int[] colByRow = new int[n];
        totalNQueensDFS(colByRow, 0, n);
        return result;
    }

    private void totalNQueensDFS(int[] colByRow, int currentRow, int boardSize) {
        if (currentRow == boardSize) {
            result++;
        } else {
            for (int col = 0; col < boardSize; col++) {
                colByRow[currentRow] = col;
                if (validPosition(colByRow, currentRow)) {
                    totalNQueensDFS(colByRow, currentRow + 1, boardSize);
                }
            }
        }
    }

    private boolean validPosition(int[] colByRow, int currentRow) {
        for (int row = 0; row < currentRow; row++) {
            if (colByRow[row] == colByRow[currentRow]
                    || Math.abs(colByRow[row] - colByRow[currentRow]) == currentRow - row) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        NQueensII solution = new NQueensII();
        System.out.println(solution.totalNQueens(1));
    }

}
