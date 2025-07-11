package TypicalAlgorithm.DP.StockExchange;

/**
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * 示例 1:
 *
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 注意:
 *
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC714 {
    /**
     *f[i]表示第 i 天结束的最大收益
     *
     *f[i][0] 表示持有股票时的最大收益
     * f[i][1] 表示不持有股票时的最大收益
     *
     * f[0][0] = - prices[0];
     *
     * 第 i 天 ：
     * f[i][0] 可以是今天刚买， 或者是前一天的状态
     * f[i][0] = max(f[i-1][0], f[i-1][1] - prices[i])
     *
     * f[i][1] 可以是今天刚卖出，卖出需要交手续费； 也可能是前一天也没买
     *
     * f[i][1] = max(f[i-1][0] + prices[i] - free, f[i-1][1])
     *
     * 最后结果为 f[n-1][1]
     *
     */
    public int maxProfit(int[] prices, int fee) {

        if(prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int [][] f= new int[n][2];
        f[0][0] = - prices[0];

        for(int i = 1; i< n; i++){
            f[i][0] = Math.max(f[i-1][0], f[i-1][1] - prices[i]);
            f[i][1] = Math.max(f[i-1][0] + prices[i] - fee, f[i-1][1]);
        }

        return f[n-1][1];
    }
}
