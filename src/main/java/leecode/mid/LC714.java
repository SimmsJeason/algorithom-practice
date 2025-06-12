package leecode.mid;

/**
 * dp[i][0] = Max(dp[i-1][1], dp[i][0] - prices[i])当天结束后，持有股票， 前一天持有； 当天买入
 * dp[i][1] = Max(dp[i-1][1], dp[i-1][0] + prices[i] -fee) 当天结束后，未持有股票， 前一天状态； 当天卖出
 * dp[0][0] = - prices[0]
 */

public class LC714 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        if(n == 0) return  0;
        int [][] dp = new int[n][2];
        dp[0][0] = -prices[0];


        for(int i = 1; i< n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i] -fee);
        }

        return dp[n-1][1];
    }
}
