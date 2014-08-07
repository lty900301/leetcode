import java.util.ArrayList;

/**
 * Permutations http://oj.leetcode.com/problems/permutations/
 * 
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * @author joshluo
 * 
 */

public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        boolean[] visited = new boolean[num.length];
        permuteImp(res, tmp, num, visited);
        return res;
    }

    // DFS
    private void permuteImp(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp, int[] num, boolean[] visited) {
        if (tmp.size() == num.length) { // Hit the leaf
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (!visited[i]) {
                tmp.add(num[i]);
                visited[i] = true;
                permuteImp(res, tmp, num, visited);
                visited[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
