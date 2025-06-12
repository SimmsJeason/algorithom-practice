package CM;

public class CM6 {
    /**
     第一步：先将矩阵以次对角线互换 （如果是逆时针则为主对角线）
     第二步：交换第i行到第n-i-1行
     */
    public int[][] transformImage(int[][] mat, int n) {
        for(int i = 0; i< n-1; i++){
            for(int j = 0; j< n - 1 -i;j++){
                int tmp = mat[i][j];
                mat[i][j] = mat[n-1-j][n-1-i];
                mat[n-1-j][n-1-i] = tmp;
            }
        }

        for(int i = 0; i<n / 2;i++){
            for(int j = 0; j< n; j++){
                int tmp = mat[i][j];
                mat[i][j] = mat[n-i-1][j];
                mat[n-i-1][j] = tmp;
            }
        }

        return mat;
    }
}
