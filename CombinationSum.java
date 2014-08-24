import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate
 * numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 * 
 * @author joshluo
 * 
 *         Solution: DFS search
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        assert (candidates.length > 0 && target > 0);
        // Process the array and create a new set holding all candidates
        Arrays.sort(candidates);
        // calculate all combinations
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        List<Integer> combination = new ArrayList<Integer>();
        int startIndex = 0;
        getCombinations(candidates, target, startIndex, combination, combinations);
        return combinations;
    }

    private void getCombinations(final int[] candidates, final int target, final int startIndex,
            final List<Integer> combination, final List<List<Integer>> combinations) {
        if (target > 0) {
            for (int i = startIndex; i < candidates.length; i++) {
                if (target - candidates[i] < 0) {
                    return;
                }
                combination.add(candidates[i]);
                getCombinations(candidates, target - candidates[i], i, combination, combinations);
                combination.remove(combination.size() - 1);
            }
        } else {
            combinations.add(new ArrayList<Integer>(combination));
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        System.out.println(combinationSum.combinationSum(candidates, target));
    }
}
