package CM;

public class CM48 {
    public int countWays(int n) {
        // write code here
        int []coins={1,5,10,25};
        int []dp= new int[100001];

        dp[0] = 1;

        for(int i = 0;i < 4;++i){
            for(int j = coins[i];j <= n;++j){
                dp[j] =(dp[j]+dp[j-coins[i]])%1000000007;
            }
        }
        return dp[n];
    }

}
