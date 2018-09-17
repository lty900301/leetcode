import java.util.Arrays;

import org.junit.Test;

/**
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * 
 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 * https://segmentfault.com/a/1190000003783283
 * 
 * Analysis:
 * if i is odd, nums[i] >= nums[i - 1]
 * if i is even, nums[i] <= nums[i - 1]
 * Go through array once, swap the nums[i] and nums[i - 1] if it didn't meet the condition.
 * Reason: if nums[i] > nums[i - 1], then after swap, nums[i] <= nums[i - 1]
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        assert (nums != null);
        for (int i = 1; i < nums.length; i++) {
            boolean conditionMet = i % 2 == 1 && nums[i] >= nums[i - 1];
            conditionMet |= i % 2 == 0 && nums[i] <= nums[i - 1];
            if (!conditionMet) {
                int tmp = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = tmp;
            }
        }
    }

    @Test
    public void test() {
        int[] nums = { 3, 5, 2, 1, 6, 4 };
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
