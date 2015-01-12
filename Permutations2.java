import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * 
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 * 
 * Solution:
 * Basically Permutations solution. One additional heck is to add current level visited set. So to avoid re-visit same
 * num[i] in same level.
 * 
 * @author joshluo
 * 
 */
public class Permutations2 {

    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> branch = new ArrayList<Integer>(num.length);
        boolean[] visited = new boolean[num.length];
        permuteUniqueDFS(res, branch, visited, num);
        return res;
    }

    private void permuteUniqueDFS(List<List<Integer>> res, List<Integer> branch, boolean[] visited, int[] num) {
        if (branch.size() == num.length) { // reach leaf, completed one permute
            res.add(new ArrayList<Integer>(branch));
            return;
        }
        Set<Integer> currentLevelVisited = new HashSet<Integer>();
        for (int i = 0; i < num.length; i++) {
            if (!currentLevelVisited.contains(num[i]) && !visited[i]) {
                branch.add(num[i]);
                visited[i] = true;
                // calculate below levels
                permuteUniqueDFS(res, branch, visited, num);
                // back up to one level up
                branch.remove(branch.size() - 1);
                visited[i] = false;
                // This level already visited num[i]
                currentLevelVisited.add(num[i]);
            }
        }
    }

}
