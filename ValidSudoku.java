/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * 
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * @author joshluo
 * 
 */
public class ValidSudoku {

    private static final char ONE = '1';
    private static final char EMPTY = '.';
    private static final int SODOKU_BLOCK_WIDTH_HEIGHT = 3;
    private static final int SODOKU_NUM_COUNT = 9;

    public boolean isValidSudoku(char[][] board) {
        // rowChecker[i][j]=true: j appears in row i
        boolean[][] rowChecker = new boolean[SODOKU_NUM_COUNT][SODOKU_NUM_COUNT];
        // columnChecker[i][j]=true: j appears in column i
        boolean[][] columnChecker = new boolean[SODOKU_NUM_COUNT][SODOKU_NUM_COUNT];
        // gridChecker[i][j]=true: j appears in grid i
        // numberring from left to right, then top to bottom
        boolean[][] gridChecker = new boolean[SODOKU_NUM_COUNT][SODOKU_NUM_COUNT];

        // One-pass scan in row-major manner
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == EMPTY)
                    continue;
                int val = board[row][col] - ONE;
                // Make sure it is a valid char
                if (val < 0 || val > 8) {
                    return false;
                }
                // Check for the corresponding row, column, and grid at the same time
                if (rowChecker[row][val] || columnChecker[col][val] || gridChecker[getBlockIndex(row, col)][val]) {
                    return false;
                }
                rowChecker[row][val] = columnChecker[col][val] = gridChecker[getBlockIndex(row, col)][val] = true;
            }
        }
        return true;
    }

    private int getBlockIndex(int row, int col) {
        return row / SODOKU_BLOCK_WIDTH_HEIGHT * SODOKU_BLOCK_WIDTH_HEIGHT + col / SODOKU_BLOCK_WIDTH_HEIGHT;
    }

}
