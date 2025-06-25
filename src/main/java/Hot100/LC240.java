package Hot100;

import com.alibaba.fastjson.JSON;

/**
 * 搜索二维矩阵 II
 * <p>
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 */
public class LC240 {

    //二分查找
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int index = search(row, target);
            if (index >= 0) {
                return true;
            }
        }
        return false;
    }

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    //dfs 不行
    public boolean searchMatri3(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = 0;
        boolean [][] visited = new boolean[m][n];
        boolean exsist = false;
        dfs(matrix, target, visited, 0, 0, exsist);
        return exsist;
    }

    public void dfs(int[][] matrix, int target, boolean [][] visited, Integer i, Integer j, boolean exist) {
        if (i >= matrix.length || j >= matrix[0].length || visited[i][j] || exist) {
            return;
        }
        if (matrix[i][j] == target) {
            exist = true;
            return;
        } else {
            visited[i][j] = true;
            if (matrix[i][j] < target) {
                j++;
                dfs(matrix, target, visited, i, j, exist);
                j--;
                i++;
                dfs(matrix, target, visited, i, j, exist);
                i--;
                visited[i][j] = false;
            }
        }
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (matrix[i][j] == target) {
                return true;
            } else {
                int next = i + 1 >= m? matrix[i][j] : matrix[i + 1][j];
                int down = j + 1 >= n? matrix[i][j] : matrix[i][j + 1];
                if (next == target || down == target) {
                    return true;
                } else if (next < target && down < target) {
                    if (target - next <= target - down) {
                        i++;
                    } else {
                        j++;
                    }
                } else if (next > target && down > target) {
                    return false;
                } else {
                    if (next > target) {
                        j++;
                    } else {
                        i++;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,3,5,7,9},{2,4,6,8,10},{11,13,15,17,19},{12,14,16,18,20},{21,22,23,24,25}};
        LC240 lc240 = new LC240();
        System.out.println(JSON.toJSON(lc240.searchMatrix(nums, 13)));
    }

}
