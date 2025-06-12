package WrittenExamination.Kuaishou;

public class Main {
    public static void main(String[] args) {
        Main test = new Main();
        int [] array = {7,6,4,3,1};
        System.out.println(test.solve(array));
    }

    public int solve(int [] array){
        int len = array.length;

        int [][] dp =  new int[len][2];
        dp[0][0] = - array[0];
        dp[0][1] = 0;
        for(int i = 1; i < len; i++){
            dp[i][0] = Math.max(dp[i-1][0], - array[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + array[i]);
        }
        return dp[len-1][1];
    }

}
