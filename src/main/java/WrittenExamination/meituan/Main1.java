package WrittenExamination.meituan;

public class Main1 {
    public static void main(String[] args) {
        Main1 test = new Main1();
        System.out.println(test.solute(3,1,1));
    }

    //dp[i] = dp[i-1] + 1; ... dp[i

    public int solute(int n, int k, int d){

        if(d > n || k < d || n <2){
            return 0;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;

        for(int i = 2; i <= n; i++){
            for(int j = i-1; j >0; j--){
                dp[i] += dp[j] +1;
            }
        }

        return dp[n];
    }
}
