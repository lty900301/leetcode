/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * Solution:
 * This question is equivalent to Fibonacci
 * DP f(n) = f(n - 1) + f(n - 2)
 * 
 * @author joshluo
 * 
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        assert (n > 0);
        if (n <= 2) {
            return n;
        }
        int fn_1 = 1, fn = 2;
        for (int i = 2; i < n; i++) {
            int temp = fn;
            fn += fn_1;
            fn_1 = temp;
        }
        return fn;
    }
}
