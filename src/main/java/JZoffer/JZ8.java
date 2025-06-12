package JZoffer;

public class JZ8 {


    /*
    说白了 就是 斐波那契数列
     */
    //动态规划
    public int jumpFloor2(int target){
        if ( target == 1) {
            return 1;
        }
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i -2];
        }
        return dp[target];

    }
}
