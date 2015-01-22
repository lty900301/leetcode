import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/n-queens/
 * 
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each
 * other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a
 * queen and an empty space respectively.
 * 
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * 
 * [
 *  [".Q..", // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * 
 *  ["..Q.", // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 
 * Solution reference: http://blog.csdn.net/u011095253/article/details/9158473
 * 
 * @author joshluo
 * 
 */
public class NQueens {

    public List<String[]> solveNQueens(int n) {
        assert (n > 0);
        List<String[]> resList = new ArrayList<String[]>();
        int[] locByRow = new int[n];
        solveNQueensDFS(resList, locByRow, 0, n);
        return resList;
    }

    private void solveNQueensDFS(List<String[]> resList, int[] locByRow, int rowIndex, int boardSize) {
        if (rowIndex == boardSize) {
            printBoard(resList, locByRow, boardSize);
        } else {
            for (int i = 0; i < boardSize; i++) {
                locByRow[rowIndex] = i;
                if (validLoc(locByRow, rowIndex)) {
                    solveNQueensDFS(resList, locByRow, rowIndex + 1, boardSize);
                }
            }
        }
    }

    private boolean validLoc(int[] locByRow, int rowIndex) {
        for (int i = 0; i < rowIndex; i++) {
            if (locByRow[i] == locByRow[rowIndex] || Math.abs(locByRow[i] - locByRow[rowIndex]) == rowIndex - i) {
                return false;
            }
        }
        return true;
    }

    private void printBoard(List<String[]> resList, int[] locByRow, int boardSize) {
        assert (locByRow.length == boardSize);
        String[] board = new String[boardSize];
        for (int i = 0; i < boardSize; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < boardSize; j++) {
                row.append(j == locByRow[i] ? "Q" : ".");
            }
            board[i] = row.toString();
        }
        resList.add(board);
    }

    public static void main(String args[]) {
        NQueens solution = new NQueens();
        List<String[]> result = solution.solveNQueens(4);
        for (String[] strings : result) {
            for (String string : strings) {
                System.out.println(string);
            }
            System.out.print("\n\n");
        }
    }
}
