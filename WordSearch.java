import java.util.Arrays;

/**
 * Word Search http://oj.leetcode.com/problems/word-search/
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
 * or vertically neighboring. The same letter cell may not be used more than once.
 * 
 * For example, Given board = [ ["ABCE"], ["SFCS"], ["ADEE"] ] word = "ABCCED", -> returns true, word = "SEE", ->
 * returns true, word = "ABCB", -> returns false.
 * 
 * @author Josh Luo
 * 
 */

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        assert (board != null);
        boolean res = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char current = board[i][j];
                if (current == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    res = findSubWord(board, visited, word.substring(1), i, j);
                    if (res)
                        return res;
                }
            }
        }
        return res;
    }

    public boolean findSubWord(char[][] board, boolean[][] visited, String subWord, int x, int y) {
        if (subWord.equals("EFS"))
            for (boolean[] row : visited)
                System.out.println(Arrays.toString(row));
        visited[x][y] = true;
        if (subWord.length() == 0)
            return true;
        boolean res = false;
        if (x - 1 >= 0 && !visited[x - 1][y] && board[x - 1][y] == subWord.charAt(0))
            if (findSubWord(board, visited, subWord.substring(1), x - 1, y))
                return true;
        if (x + 1 < board.length && !visited[x + 1][y] && board[x + 1][y] == subWord.charAt(0))
            if (findSubWord(board, visited, subWord.substring(1), x + 1, y))
                return true;
        if (y - 1 >= 0 && !visited[x][y - 1] && board[x][y - 1] == subWord.charAt(0))
            if (findSubWord(board, visited, subWord.substring(1), x, y - 1))
                return true;
        if (y + 1 < board[0].length && !visited[x][y + 1] && board[x][y + 1] == subWord.charAt(0))
            if (findSubWord(board, visited, subWord.substring(1), x, y + 1))
                return true;
        visited[x][y] = false; // very important
        return res;
    }
}
