package TypicalAlgorithm.DP.DivisionInteger;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC343 {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }

    /*********************************************/
    public int integerBreak2(int n) {
        int [] dp = new int[n+1];
        dp[2] = 1;
        dp[1] = 1;
        for(int i = 3; i<= n; i++){
            int half = i / 2;
            int max = -1;
            for(int j = 1; j <= half; j++){
                int tmp = Math.max(dp[j], j) * Math.max(dp[i-j], i-j);
                if(max < tmp ) max = tmp;
            }
            dp[i] = max;
        }


        return dp[n];
    }

}
