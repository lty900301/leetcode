/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * 
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * 
 * Solution Reference:
 * http://www.programcreek.com/2014/03/leetcode-best-time-to-buy-and-sell-stock-iv-java/
 * http://www.cnblogs.com/grandyang/p/4295761.html
 * 
 * @author JoshLuo
 * 
 */
public class BestTimeToBuyAndSellStock4 {

    public int maxProfit(int k, int[] prices) {
        assert (prices != null);
        if (prices.length == 0) {
            return 0;
        }
        if (k >= prices.length) {
            return maxProfit(prices);
        }
        int[] global = new int[k + 1];
        int[] local = new int[k + 1];
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            for (int j = k; j >= 1; j--) {
                local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
                global[j] = Math.max(local[j], global[j]);
            }
        }
        return global[k];
    }

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                max += prices[i + 1] - prices[i];
            }
        }
        return max;
    }

}
