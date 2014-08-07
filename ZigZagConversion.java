/**
 * ZigZag Conversion
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to
 * display this pattern in a fixed font for better legibility)
 * 
 * P A H N A P L S I I G Y I R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a number of rows:
 * 
 * string convert(string text, int nRows);
 * 
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * @author Josh Luo
 * 
 */

public class ZigZagConversion {
    public String convert(String s, int nRows) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (nRows == 0 || s.equals(""))
            return "";
        if (nRows == 1)
            return s;
        int col = (s.length() / (2 * nRows - 2) + 1) * 2;
        char[][] matrix = new char[nRows][col];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }

        col = 0;
        int index = 0;
        while (col < matrix[0].length && index < s.length()) {
            if (col % 2 == 1) {
                if (matrix.length > 2) {
                    int row = matrix.length - 2;
                    while (row > 0 && index < s.length()) {
                        matrix[row--][col] = s.charAt(index++);
                    }
                }
            } else {
                int row = 0;
                while (row < matrix.length && index < s.length()) {
                    matrix[row++][col] = s.charAt(index++);
                }
            }
            col++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    sb.append(matrix[i][j]);
                }
            }
        }
        return new String(sb);
    }
}
