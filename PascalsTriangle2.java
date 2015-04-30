import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3,
 * Return [1,3,3,1].
 * 
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 * Reference: http://blog.csdn.net/linhuanmars/article/details/23311629
 * 
 * @author joshluo
 * 
 */
public class PascalsTriangle2 {

    public List<Integer> getRow(int rowIndex) {
        assert (rowIndex >= 0);
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = result.size() - 1; j > 0; j--) { // from back to front
                result.set(j, result.get(j) + result.get(j - 1));
            }
            result.add(1);
        }
        return result;
    }

}
