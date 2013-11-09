import java.util.Arrays;

/**
 * 3Sum Closest 
 * http://oj.leetcode.com/problems/3sum-closest/
 * 
 * Given an array S of n integers, find three integers in S such that the sum is closest 
 * to a given number, target. Return the sum of the three integers. You may assume that 
 * each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author joshluo
 *
 * Tow pointer method is used in the second loop. O(n^2) time, O(1) space. 
 */

public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (num.length<3) { // if less than three items then return 0
            return Integer.MAX_VALUE;
        }
        Arrays.sort(num);
        int res = num[0]+num[1]+num[2];
        for (int i=0; i<num.length-2; ++i) {
            if (i>0 && num[i]==num[i-1])  continue;
            int start = i+1, end = num.length-1;
            while (start<end) {
                int sum = num[i] + num[start] + num[end];
                if (Math.abs(sum-target) < Math.abs(res-target)) {
                    res = sum;
                }
                if (sum == target) {
                    return res;
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }//end-while
        }
        return res;
    }
}
