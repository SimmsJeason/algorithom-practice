package dailyPractice.hot100;

import com.alibaba.fastjson.JSON;

public class LC48 {


    /**
     * 2,0 1,0 0,0
     * 2,1 1,1 0.1
     * 2.2 1,2 0,2
     * n * n
     * 0,0 -> 0,2   0,1 -> 1,2  0,2 -> 2,2
     * {i, j} -> {j, n - i}
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = res[i][j];
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        LC48 lc48 = new LC48();
        lc48.rotate(nums);
        System.out.println(JSON.toJSON(nums));
    }
}
