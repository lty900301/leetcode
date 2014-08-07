import java.util.ArrayList;

/**
 * Combinations http://oj.leetcode.com/problems/combinations/
 * 
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * 
 * For example,
 * 
 * If n = 4 and k = 2, a solution is: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * 
 * @author joshluo
 * 
 */

public class Combinations {
    // DFS
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (n < k)
            return res;
        if (k == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        while (n > 0) {
            ArrayList<ArrayList<Integer>> comb = combine(n - 1, k - 1);
            for (ArrayList<Integer> subComb : comb) {
                subComb.add(n);
                res.add(subComb);
            }
            n--;
        }
        return res;
    }
}
