import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the
 * row below.
 * 
 * <code>
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * </code>
 * 
 * Note: Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the
 * triangle.
 * 
 * Reference: http://www.programcreek.com/2013/01/leetcode-triangle-java/
 * 
 * @author joshluo
 * 
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        assert (triangle != null && triangle.size() > 0);
        int n = triangle.size();
        int[] row = new int[n];
        // Initiate with the last row
        for (int i = 0; i < triangle.get(n - 1).size(); i++) {
            row[i] = triangle.get(n - 1).get(i);
        }
        // Update the above rows
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                row[j] = triangle.get(i).get(j) + Math.min(row[j], row[j + 1]);
            }
        }
        return row[0];
    }

}
