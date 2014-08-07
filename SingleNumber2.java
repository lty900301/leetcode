/**
 * Single Number II http://oj.leetcode.com/problems/single-number-ii/
 * 
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 * @author joshluo
 * 
 */

public class SingleNumber2 {
    public int singleNumber(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        assert (A != null);
        int[] counts = new int[32];
        int result = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++) {
                if (((A[j] >> i) & 1) == 1) {
                    counts[i] = (counts[i] + 1) % 3;
                }
            }
            result |= (counts[i] << i);
        }
        return result;
    }
}
