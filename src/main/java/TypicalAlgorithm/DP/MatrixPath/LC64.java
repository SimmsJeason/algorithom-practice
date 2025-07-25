package TypicalAlgorithm.DP.MatrixPath;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC64 {

    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) return  0;
        int m = grid.length;
         int n = grid[0].length;
         int [][] dp = new int[m][n];
         for(int i = 0; i< m ;i ++){
             for(int j = 0; j< n; j++){
                 int tmp = Integer.MAX_VALUE;

                 if(i-1 >= 0) tmp = dp[i-1][j];
                 if(j -1 >= 0) tmp = tmp > dp[i][j-1]? dp[i][j-1] : tmp;

                 if(tmp == Integer.MAX_VALUE){
                     tmp = 0;
                 }
                 dp[i][j] = grid[i][j] + tmp;
             }
         }
         return dp[m-1][n-1];
    }
}
