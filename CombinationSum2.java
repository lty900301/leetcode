import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the
 * candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 * A solution set is:
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 * @author joshluo
 */
public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        assert (candidates.length > 0 && target > 0);
        // Process the array and create a new set holding all candidates
        Arrays.sort(candidates);
        // calculate all combinations
        Set<List<Integer>> combinations = new HashSet<List<Integer>>();
        List<Integer> combination = new ArrayList<Integer>();
        int startIndex = 0;
        getCombinations(candidates, target, startIndex, combination, combinations);
        return new ArrayList<List<Integer>>(combinations);
    }

    private void getCombinations(final int[] candidates, final int target, final int startIndex,
            final List<Integer> combination, final Set<List<Integer>> combinations) {
        if (target > 0) {
            for (int i = startIndex; i < candidates.length; i++) {
                if (target - candidates[i] < 0) {
                    return;
                }
                combination.add(candidates[i]);
                getCombinations(candidates, target - candidates[i], i + 1, combination, combinations);
                combination.remove(combination.size() - 1);
            }
        } else {
            combinations.add(new ArrayList<Integer>(combination));
        }
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        System.out.println(combinationSum2.combinationSum2(candidates, target));
    }

}
