package WrittenExamination.Qianxin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Main test = new Main();
        int n = in.nextInt();
        System.out.println(test.solve(n));
    }

    public int solve(int n) {
        int [] dp = new int[n+1];
        dp[0] = 1;
        for(int i= 1; i <= n; i++){
            for(int j = i; j >=0; j--){
                dp[i] += dp[j];
            }
        }
        return dp[n];
    }
}
