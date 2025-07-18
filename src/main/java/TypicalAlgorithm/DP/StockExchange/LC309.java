package TypicalAlgorithm.DP.StockExchange;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class LC309 {
    /**
     *用 f[i] 表示第 i 天 [结束之后] 的「累计最大收益」
     * 会有三种状态：
     * 我们目前持有一支股票，对应的「累计最大收益」记为 f[i][0]；
     *
     * 我们目前不持有任何股票，并且处于冷冻期中，对应的「累计最大收益」记为 f[i][1]；
     *
     * 我们目前不持有任何股票，并且不处于冷冻期中，对应的「累计最大收益」记为 f[i][2]。
     *
     * 这里的「处于冷冻期」指的是在第 i 天结束之后的状态。也就是说：如果第 i 天结束之后处于冷冻期，那么第 i+1 天无法买入股票。
     *
     * 如何进行状态转移呢？在第 i 天时，我们可以在不违反规则的前提下进行「买入」或者「卖出」操作，此时第 i 天的状态会从第 i−1 天的状态转移而来；
     * 我们也可以不进行任何操作，此时第 i 天的状态就等同于第 i−1 天的状态。那么我们分别对这三种状态进行分析：
     *
     * 对于 f[i][0]，我们目前持有的这一支股票可以是在第 i−1 天就已经持有的，对应的状态为 f[i−1][0]；
     * 或者是第 i 天买入的，那么第 i-1 天就不能持有股票并且不处于冷冻期中，对应的状态为 f[i−1][2] 加上买入股票的负收益 prices[i]。因此状态转移方程为：
     *
     * f[i][0]=max(f[i−1][0],f[i−1][2]−prices[i])
     *
     * 对于 f[i][1]，我们在第 i 天结束之后处于冷冻期的原因是在当天卖出了股票，那么说明在第 i−1 天时我们必须持有一支股票，
     * 对应的状态为 f[i-1][0] 加上卖出股票的正收益 prices[i]。因此状态转移方程为：
     *
     * f[i][1]=f[i−1][0] + prices[i]
     *
     * 对于 f[i][2]，我们在第 i 天结束之后不持有任何股票并且不处于冷冻期，说明当天没有进行任何操作，即第 i−1 天时不持有任何股票：
     * 如果处于冷冻期，对应的状态为 f[i-1][1]；如果不处于冷冻期，对应的状态为 f[i−1][2]。因此状态转移方程为：
     *
     * f[i][2]=max(f[i−1][1],f[i−1][2])
     *
     * 这样我们就得到了所有的状态转移方程。如果一共有 n 天，那么最终的答案即为：
     *
     * max(f[n−1][0],f[n−1][1],f[n−1][2])
     *
     * 注意到如果在最后一天（第 n-1天）结束之后，手上仍然持有股票，那么显然是没有任何意义的。因此更加精确地，
     * 最终的答案实际上是f[n−1][1] 和 f[n−1][2] 中的较大值，即：
     *
     * max(f[n−1][1],f[n−1][2])
     *
     * 细节
     *
     * 我们可以将第 0 天的情况作为动态规划中的边界条件：
     *
     *
     * f[0][0] = - prices[0]
     * f[0][1] = 0
     * f[0][2] = 0
     *
     *
     * 在第 0 天时，如果持有股票，那么只能是在第 0 天买入的，对应负收益 −prices[0]；
     * 如果不持有股票，那么收益为零。注意到第 0 天实际上是不存在处于冷冻期的情况的，
     * 但我们仍然可以将对应的状态 f[0][1] 置为零，这其中的原因留给读者进行思考。
     *
     * 这样我们就可以从第 1 天开始，根据上面的状态转移方程进行进行动态规划，直到计算出第 n-1 天的结果。
     *
     */
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
