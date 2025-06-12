package leecode.mid;

/**
 * 两个及以上状态就要用二维数组或者多维数组
 *
 * dp[i][0] 表示当天结束时 持有股票，股票刚刚买入或者一直没卖 的最大收入
 * dp[i][1] 表示当天结束时，不持有股票， 也不处于冷冻期 的最大收入
 * dp[i][2] 表示当天结束时，为冻结期，的最大收入
 *
 * dp[0][0] = - prices[0] 第一天买入是负收入
 *
 * dp[i][0] = Max(dp[i-1][1] - prices[i], dp[i-1][0]) 要么是刚买， 要么是之前买的没卖
 * dp[i][1] = Max(dp[i-1][1], dp[i-1][2]) 不处于冷冻期不持有股票， 处于冷冻期不持有股票
 * dp[i][2] = dp[i-1][0] + prices[i] 当天卖出， 进入冻结期
 *
 */
public class LC309 {

    public static void main(String[] args) {
        LC309 lc309 = new LC309();
        int [] array = {1,2,3,0,2};
        System.out.println(lc309.maxProfit1(array));
    }

    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if(len == 0) return 0;
        int [] [] dp = new int[len][3];
        dp[0][0] = - prices[0];

        for(int i = 1; i < len ;i++){
            dp[i][0] = Math.max(dp[i-1][1] - prices[i], dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][1] , dp[i-1][2]);
            dp[i][2] = dp[i-1][0] + prices[i];
        }

        return  Math.max(dp[len-1][1], dp[len-1][2]);
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }
}
