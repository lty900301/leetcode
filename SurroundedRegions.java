/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * 
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * Solution Reference:
 * http://blog.csdn.net/ojshilu/article/details/22600449
 * 
 * @author JoshLuo
 * 
 */
public class SurroundedRegions {

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) { // left and right border
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }
        for (int i = 0; i < n; i++) { // top and bottom border
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[m - 1][i] == 'O') {
                dfs(board, m - 1, i);
            }
        }
        for (int i = 0; i < m; i++) { // Remark escaped to 'O' others to 'X'
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (board[i][j] == '#') {
            return;
        }
        // Mark escaped position #
        board[i][j] = '#';
        if (i > 1 && board[i - 1][j] == 'O') {
            dfs(board, i - 1, j);
        }
        if (i < board.length - 1 && board[i + 1][j] == 'O') {
            dfs(board, i + 1, j);
        }
        if (j > 1 && board[i][j - 1] == 'O') {
            dfs(board, i, j - 1);
        }
        if (j < board[0].length - 1 && board[i][j + 1] == 'O') {
            dfs(board, i, j + 1);
        }
    }

}
