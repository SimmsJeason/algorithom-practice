package CM;

public class CM57 {
    //找出以元素i结尾的最长递增子序列

    public int getHeight(int[] men, int n) {
        // write code here
        if(n < 1){
            return 0;
        }
        int [] dp = new int[men.length];
        dp[0] = 1;

        int result = 0;

        //dp[i] = 0 -> m[i-1] 中 小于 m[i] 元素的值对应的dp最大值加1
        for(int i = 1; i < n ;i++){
            int j =0 ;
            int max = 0;
            while(j < i){
                if(men[j] < men[i]){
                    max = Math.max(max, dp[j]);
                }
                j++;
            }
            dp[i] = max +1;
            if(result < dp[i]){
                result = dp[i];
            }
        }

        return result;
    }
}
