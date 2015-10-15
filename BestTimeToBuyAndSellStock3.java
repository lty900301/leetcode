/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * 
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * 
 * Solution: Comparing to I and II, III limits the number of transactions to 2. This can be solve by
 * "devide and conquer". We use left[i] to track the maximum profit for transactions before i, and use right[i] to track
 * the maximum profit for transactions after i. You can use the following example to understand the Java solution:
 * 
 * Reference: http://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-iii-java/
 * 
 * @author joshluo
 * 
 */
public class BestTimeToBuyAndSellStock3 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        int[] left = new int[n];
        int[] right = new int[n];
        // from left to right
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(prices[i] - min, left[i - 1]);
        }
        // from right to left
        right[n - 1] = 0;
        int max = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(max - prices[i], right[i + 1]);
        }
        // merge both
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(left[i] + right[i], result);
        }
        return result;
    }

}
