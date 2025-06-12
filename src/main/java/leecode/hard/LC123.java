package leecode.hard;


/**
 * dp[i][0][0] 第 i 天结束时， 第一次交易 持有股票
 * dp[i][0][1] 第 i 天结束时， 第一次交易 不持有股票
 * dp[i][1][0] 第 i 天结束时， 第二次交易 持有股票
 * dp[i][1][1] 第 i 天结束时， 第二次交易 不持有股票
 *
 * 第一次交易：
 * dp[i][0][0] = Max(dp[i-1][0][0],  - prices[i]) 前一天的状态， 当天买入
 * dp[i][0][1] = Max(dp[i-1][0][1], dp[i-1][0][0] + prices[i] 前一天状态, 当天卖
 *
 * 第二次交易;
 * dp[i][1][0] = Max(dp[i-1][1][0],dp[i][0][1] - prices[i]) //上一个状态，第一次交易结束当天买入
 * dp[i][1][1] = Max(dp[i-1][1][1], dp[i-1][1][0] + prices[i])//上一个状态， 当天卖出
 *
 * base值
 *
 * dp[0][0][0] = - prices[0];
 * dp[0][0][1] = 0;
 * dp[0][1][0] = Integer.MIN_VALUE 因为该值无意义
 */
public class LC123 {
    public static void main(String[] args) {
        LC123 lc123 = new LC123();
        int [] array = {1,7,4,2};
        System.out.println(lc123.maxProfit(array));
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 1) return 0;

        int [][][]dp = new int[n][2][2];

        dp[0][0][0] = - prices[0];
        dp[0][1][0] = Integer.MIN_VALUE;

        for(int i = 1; i < n; i++){
            dp[i][0][0] = Math.max(dp[i-1][0][0], - prices[i]);
            dp[i][0][1] = Math.max(0, dp[i-1][0][0] + prices[i]);

            if(dp[i-1][0][1] != 0){
                dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][0][1] - prices[i]);
            }else {
                dp[i][1][0] = Integer.MIN_VALUE;
            }
            if(dp[i-1][1][0] != Integer.MIN_VALUE){
                dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i-1][1][0] + prices[i]);
            }else {
                dp[i][1][1] = dp[i-1][1][1];
            }

        }

        if(n < 4) {
            return dp[n-1][0][1];
        }else {
            return dp[n-1][1][1];

        }
    }
}
