package leecode.mid;

public class LC322 {

    public static void main(String[] args) {
        int [] array = {1,3,5};
        LC322 lc322 = new LC322();
        System.out.println(lc322.coinChange(array, 11));
    }
    /**
     *dp[i] 为 构成i 的最少硬币数
     * dp[i] = Min (dp[i- coins[0], ..., dp[i - coins[k]) + 1;
     */

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    // coins 硬币面值 ； rest 剩余钱数 ； count 用来记录之前的计算结果
    public int coinChange(int [] coins, int rest, int [] count){
        if(rest < 0) return -1;//剩余钱数 小于 硬币面值
        if(rest == 0) return 0;//刚刚好够

        if(count[rest-1]!=0) return count[rest-1];

        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < coins.length; i++){
            int res = coinChange(coins, rest - coins[i], count);
           if(res >= 0 && res < min){
               min = res +1;
           }
        }

        //记录当面金额需要的最少硬币数
        count[rest -1] = (min == Integer.MAX_VALUE) ? -1 : min;

        return count[rest-1];
    }


    private int coinChange2(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }


        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

}
