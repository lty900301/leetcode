import java.util.ArrayList;
import java.util.List;

/**
 * Numbers can be regarded as product of its factors. For example,
 * 8 = 2 x 2 x 2;
 * = 2 x 4.
 * Write a function that takes an integer n and return all possible combinations of its factors.
 * Note:
 * Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
 * You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.
 * 
 * Examples: <code>
 *     input: 1
 *     output: 
 *     []
 *     input: 37
 *     output: 
 *     []
 *     input: 12
 *     output:
 *     [
 *       [2, 6],
 *       [2, 2, 3],
 *       [3, 4]
 *     ]
 *     input: 32
 *     output:
 *     [
 *       [2, 16],
 *       [2, 2, 8],
 *       [2, 2, 2, 4],
 *       [2, 2, 2, 2, 2],
 *       [2, 4, 4],
 *       [4, 8]
 *     ]
 * </code>
 */
public class FactorCombinations {

    // https://leetcode.com/discuss/51250/my-recursive-dfs-java-solution
    public List<List<Integer>> getFactors(int n) {
        assert (n > 0);
        List<List<Integer>> result = new ArrayList<>();
        dfsGetFactors(result, new ArrayList<Integer>(), n, 2);
        return result;
    }

    private void dfsGetFactors(List<List<Integer>> result, List<Integer> temp, int n, int start) {
        if (n <= 1) {
            if (temp.size() > 1)
                result.add(new ArrayList<Integer>(temp));
        } else {
            for (int i = start; i <= (int) Math.sqrt(n); i++) {
                if (n % i == 0) {
                    temp.add(i);
                    dfsGetFactors(result, temp, n / i, i);
                    temp.remove(temp.size() - 1);
                }
            }
            int i = n;
            temp.add(i);
            dfsGetFactors(result, temp, n / i, i);
            temp.remove(temp.size() - 1);
        }
    }

}
