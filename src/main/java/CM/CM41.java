package CM;

public class CM41 {

    /*//超时
    public int countWays(int[][] map, int x, int y) {
        // write code here

        if(x <= 0 || y <= 0){//出界
            return 0;
        }

        if(map[x-1][y-1] != 1){
            return 0;
        }

        if(x == 1 && y == 1){//当只有一个方格的时候
            return 1;
        }

        return countWays(map, x-1, y) %1000000007 + countWays(map, x, y-1) %1000000007;
    }*/

    public int countWays(int[][] map, int x, int y) {
        int[][] dp = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(map[i][j] != 1){
                    dp[i][j] = 0;
                }else {
                    if (i == 0 && j == 0) {
                        dp[i][j] = 1;
                    }else if(i != 0 && j== 0){//最左边一列
                        dp[i][j] = dp[i-1][j];
                    }else if(i == 0 && j!=0){
                        dp[i][j] = dp[i][j-1];//最上边一行
                    }else {
                        dp[i][j] = dp[i-1][j] %1000000007 + dp[i][j-1] %1000000007;
                    }
                }
            }
        }

        return dp[x-1][y-1];
    }
}
