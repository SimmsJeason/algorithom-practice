package Hot100;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 矩阵置零
 */
public class LC73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<int []> zero = new ArrayList<>();
        for (int i = 0 ; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j] == 0) {
                    zero.add(new int[]{i, j});
                }
            }
        }

        if (zero.size() == 0) {
            return;
        } else {
            for (int[] cur: zero) {
                for(int i = 0; i < n; i++) {
                    matrix[cur[0]][i] = 0;
                }
                for (int i = 0; i < m; i++) {
                    matrix[i][cur[1]] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        LC73 lc73 = new LC73();
        lc73.setZeroes(nums);
        System.out.println(JSON.toJSON(nums));
    }
}
