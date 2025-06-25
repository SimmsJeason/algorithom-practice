package Hot100;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 */
public class LC54 {
    /**
     * 3 * 3
     * 1 2 3 4 5 6 7 8 9
     * 1.1 1.2 1.3
     *
     * @param matrix
     * @return
     */

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int total = m * n;
        boolean[][] visited = new boolean[m][n];
        // 每次转向的行列变化情况
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        List<Integer> res = new ArrayList<>();
        int row = 0, col = 0;
        for (int i = 0; i < total; i++) {
            res.add(matrix[row][col]);
            visited[row][col] = true;

            int nextRow = row + directions[directionIndex][0], nextcol = col + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= m || nextcol < 0 || nextcol >= n || visited[nextRow][nextcol]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            col += directions[directionIndex][1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        LC54 lc54 = new LC54();
        System.out.println(JSON.toJSON(lc54.spiralOrder(nums)));
    }

}
