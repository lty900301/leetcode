/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of
 * the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of
 * "ABCDE" while "AEC" is not).
 * 
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
 * 
 * Reference: http://www.cs.cmu.edu/~yandongl/distinctseq.html
 * 
 * @author joshluo
 * 
 */
public class DistinctSubsequences {

    /*
     * Define the subproblem
     * 
     * We define the computation structure to be C[i][j] indicating the number of solutions for S[0...i-1] and
     * T[0...j-1]. i/j in C represents #chars in the substring. It's easier if we include 0 in the structure to
     * accommodate the case when there's no chars(empty string) considered. In order to expand this structure, when
     * updating C[i][j] we have two options:
     * 
     * C[i][j] = C[i-1][j]. No matter what current char of S is we simply don't use it. We will only use chars
     * [0,...i-2] from S no matter how many solutions there are to cover T[0...j-1]
     * But if current char of S is same to current of T (S[i-1]==T[j-1]) then we have another choice: we can use all the
     * solutions of C[i-1][j-1] to increment the solution C[i][j]. Therefore C[i][j]+=C[i-1][j-1]
     */

    /**
     * Realization in code
     */
    public int numDistinct_1(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] matrix = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++)
            matrix[i][0] = 1;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                matrix[i][j] = matrix[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    matrix[i][j] += matrix[i - 1][j - 1];
                }
            }
        }
        return matrix[m][n];
    }

    /**
     * Space optimization
     * 
     * If you try to solve this by hand you'll quickly realize what you do is simply fill out a table. The rows are
     * chars from S, and columns are chars from T. You update in row-wise fashion each time (the inner loop). For each
     * cell you first drag what's directly above current cell (C[i][j]=C[i-1][j]). And if chars are same, you increment
     * it by its top-left neighbor(C[i][j]+=C[i-1][j-1]). So all computation can be done with the storage of a vector
     * instead of a table. There is one problem however, which is in 2nd case we need C[j-1] (when reduced to 1-d
     * vector, i ignored) but C[j-1] might be updated before reaching C[j]. The workaround is to use a temporary var to
     * hold its value.
     */
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[] row = new int[n + 1];
        row[0] = 1;
        for (int i = 1; i < m + 1; i++) {
            int upperLeft = row[0];
            for (int j = 1; j < n + 1; j++) {
                int cur = row[j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    row[j] += upperLeft;
                }
                upperLeft = cur;
            }
        }
        return row[n];
    }

}
