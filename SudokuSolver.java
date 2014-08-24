import java.util.Arrays;
import java.util.Stack;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 * 
 * Sudoku example and valid resolution.
 * http://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-
 * 20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png
 * http://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Sudoku-by-L2G-
 * 20050714_solution.svg/250px-Sudoku-by-L2G-20050714_solution.svg.png
 * 
 * @author joshluo
 */
public class SudokuSolver {

    private static final int BLOCK_SIZE = 9;
    private static final int BLOCK_WIDTH_HEIGHT = 3;
    private static final char EMPTY = '.';
    private static final char ZERO = '0';

    public void solveSudoku(char[][] board) {
        final boolean[][] cellSetByRowIndex = new boolean[BLOCK_SIZE][BLOCK_SIZE + 1];
        final boolean[][] cellSetByColIndex = new boolean[BLOCK_SIZE][BLOCK_SIZE + 1];
        final boolean[][] cellSetByBlkIndex = new boolean[BLOCK_SIZE][BLOCK_SIZE + 1];
        processSudoku(board, cellSetByRowIndex, cellSetByColIndex, cellSetByBlkIndex);
        solveSudoku(board, cellSetByRowIndex, cellSetByColIndex, cellSetByBlkIndex);
    }

    private void processSudoku(final char[][] board, final boolean[][] cellSetByRowIndex,
            final boolean[][] cellSetByColIndex, final boolean[][] cellSetByBlkIndex) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                char cellChar = board[row][col];
                final int cellVal = cellChar - ZERO;
                if (cellVal >= 1 && cellVal <= BLOCK_SIZE) {
                    cellSetByRowIndex[row][cellVal] = true;
                    cellSetByColIndex[col][cellVal] = true;
                    cellSetByBlkIndex[getBlockIndexByRowCol(row, col)][cellVal] = true;
                } else if (cellChar == EMPTY) {
                    continue;
                } else {
                    throw new IllegalArgumentException("The sudoku board is malformed.");
                }
            }
        }
    }

    private int getBlockIndexByRowCol(final int row, final int col) {
        return row / BLOCK_WIDTH_HEIGHT * BLOCK_WIDTH_HEIGHT + col / BLOCK_WIDTH_HEIGHT;
    }

    private void solveSudoku(final char[][] board, final boolean[][] cellSetByRowIndex,
            final boolean[][] cellSetByColIndex, final boolean[][] cellSetByBlkIndex) {
        final Stack<Integer> processStackRow = new Stack<Integer>();
        final Stack<Integer> processStackCol = new Stack<Integer>();
        int attemptStart = 0;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                final char cellChar = board[row][col];
                if (cellChar == EMPTY) {
                    final int attemptResult = fillBoardAttempt(attemptStart, row, col, cellSetByRowIndex,
                            cellSetByColIndex, cellSetByBlkIndex);
                    attemptStart = 0;
                    if (attemptResult > 0) {
                        board[row][col] = (char) (attemptResult + ZERO);
                        processStackRow.push(row);
                        processStackCol.push(col);
                    } else {
                        do {
                            row = processStackRow.pop();
                            col = processStackCol.pop();
                            attemptStart = board[row][col] - ZERO;
                            resetCellToEmpty(board, row, col, attemptStart, cellSetByRowIndex, cellSetByColIndex,
                                    cellSetByBlkIndex);
                        } while (attemptStart >= BLOCK_SIZE);
                        col--;
                    }
                } else {
                    continue;
                }
            }
        }
    }

    private boolean isNotInSet(final int target, final int index, final boolean[][] set) {
        return !set[index][target];
    }

    private int fillBoardAttempt(final int attemptStart, final int row, final int col,
            final boolean[][] cellSetByRowIndex, final boolean[][] cellSetByColIndex,
            final boolean[][] cellSetByBlkIndex) {
        for (int attempt = attemptStart + 1; attempt <= BLOCK_SIZE; attempt++) {
            boolean valid = true;
            valid &= isNotInSet(attempt, row, cellSetByRowIndex);
            valid &= isNotInSet(attempt, col, cellSetByColIndex);
            valid &= isNotInSet(attempt, getBlockIndexByRowCol(row, col), cellSetByBlkIndex);
            if (valid) {
                cellSetByRowIndex[row][attempt] = true;
                cellSetByColIndex[col][attempt] = true;
                cellSetByBlkIndex[getBlockIndexByRowCol(row, col)][attempt] = true;
                return attempt;
            }
        }
        return 0;
    }

    private void resetCellToEmpty(final char[][] board, final int row, final int col, final int val,
            final boolean[][] cellSetByRowIndex, final boolean[][] cellSetByColIndex,
            final boolean[][] cellSetByBlkIndex) {
        cellSetByRowIndex[row][val] = false;
        cellSetByColIndex[col][val] = false;
        cellSetByBlkIndex[getBlockIndexByRowCol(row, col)][val] = false;
        board[row][col] = EMPTY;
    }

    public static void main(String[] args) {
        char[][] board = new char[BLOCK_SIZE][BLOCK_SIZE];
        String[] testInput = { "..9748...", "7........", ".2.1.9...", "..7...24.", ".64.1.59.", ".98...3..",
                "...8.3.2.", "........6", "...2759.." };
        for (int i = 0; i < testInput.length; i++) {
            board[i] = testInput[i].toCharArray();
        }
        final SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.solveSudoku(board);
        printBoard(board);
    }

    private static void printBoard(final char[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
