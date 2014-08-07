import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 4Sum http://oj.leetcode.com/problems/4sum/
 * 
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all
 * unique quadruplets in the array which gives the sum of target.
 * 
 * Note: Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ¡Ü b ¡Ü c ¡Ü d) The solution set must
 * not contain duplicate quadruplets.
 * 
 * @author joshluo
 * 
 *         My solution is to first store all possible tow sum. Then 4sum is the combination of two 2sum. So to store,
 *         you need O(n^2) to find all combination. Now you have O(n^2) space to store these tow sums. In this O(n^2)
 *         space, you need to go through them all to find 4sum. Therefore, this finding process also takes O(n^2)
 * 
 *         Time: O(n^2), Space: O(n^2)
 * 
 *         fourSum2 shows the O(n^2 * log(n)) algorithm. which only taks O(n) space.
 */

public class FourSum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        assert (num != null);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num.length < 4)
            return res;

        // O(n^2)
        HashMap<Integer, ArrayList<ArrayList<Integer>>> twoSumMap = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int sum = num[i] + num[j];
                if (!twoSumMap.containsKey(sum)) {
                    twoSumMap.put(sum, new ArrayList<ArrayList<Integer>>());
                }
                ArrayList<ArrayList<Integer>> combinations = twoSumMap.get(sum);
                ArrayList<Integer> oneComb = new ArrayList<Integer>();
                oneComb.add(i);
                oneComb.add(j);
                combinations.add(oneComb);
                twoSumMap.put(sum, combinations);
            }
        }

        // O(n^2)
        // Go through all possible 2sum results.
        HashSet<ArrayList<Integer>> resultSet = new HashSet<ArrayList<Integer>>();
        Iterator<Integer> iter = twoSumMap.keySet().iterator();
        while (iter.hasNext()) {
            int firstTwoSum = iter.next();
            ArrayList<ArrayList<Integer>> firstCombination = twoSumMap.get(firstTwoSum);
            Integer[] oneRes = new Integer[4];

            while (firstCombination.size() > 0) {
                ArrayList<Integer> firstTwo = firstCombination.remove(0);
                oneRes[0] = num[firstTwo.get(0)];
                oneRes[1] = num[firstTwo.get(1)];

                if (twoSumMap.containsKey(target - firstTwoSum)) {
                    ArrayList<ArrayList<Integer>> secondCombination = twoSumMap.get(target - firstTwoSum);
                    for (ArrayList<Integer> secondTwo : secondCombination) {
                        int thirdIndex = secondTwo.get(0);
                        int fourthIndex = secondTwo.get(1);
                        // make sure there is no duplicates.
                        if (thirdIndex == firstTwo.get(0) || thirdIndex == firstTwo.get(1))
                            continue;
                        if (fourthIndex == firstTwo.get(0) || fourthIndex == firstTwo.get(1))
                            continue;

                        oneRes[2] = num[thirdIndex];
                        oneRes[3] = num[fourthIndex];

                        // you cannot change the value of oneRes[0] and oneRes[1]
                        // Therefore deep copy the array
                        Integer[] newRes = Arrays.copyOf(oneRes, oneRes.length);
                        Arrays.sort(newRes);
                        resultSet.add(new ArrayList<Integer>(Arrays.asList(newRes)));
                    }
                } else
                    break; // you can not make 4sum using this 2sum
            }
        }
        res.addAll(resultSet);
        return res;
    }

    public ArrayList<ArrayList<Integer>> fourSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        Arrays.sort(num);

        for (int i = 0; i < num.length - 3; i++) {
            for (int j = i + 1; j < num.length - 2; j++) {
                int k = j + 1, l = num.length - 1;
                while (k < l) {
                    if (num[i] + num[j] + num[k] + num[l] == target) {
                        ArrayList<Integer> result = new ArrayList<Integer>();
                        result.add(num[i]);
                        result.add(num[j]);
                        result.add(num[k]);
                        result.add(num[l]);
                        set.add(result);
                        k++;
                        l--;
                    } else if (num[i] + num[j] + num[k] + num[l] > target) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        list.addAll(set);
        return list;
    }
}
