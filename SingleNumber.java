/**
 * Single Number
 * http://oj.leetcode.com/problems/single-number/
 * 
 * Given an array of integers, every element appears twice except for one. 
 * Find that single one.
 * 
 * Note: 
 * Your algorithm should have a linear runtime complexity. 
 * Could you implement it without using extra memory?
 * 
 * @author joshluo
 *
 */

public class SingleNumber {
	public int singleNumber(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        assert(A != null);
        int res = 0;
        for(int i = 0; i < A.length; i++) {
            res ^= A[i];
        }
        return res;
    }
}
