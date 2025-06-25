package Hot100;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class LC46 {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs(nums, len, 0, visited, path, res);
        return res;
    }


    public void dfs(int[] nums, int len, int depth, boolean[] visited, List<Integer> path, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for ( int i = 0; i < len; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.add(nums[i]);
                dfs(nums, len, depth+1, visited, path, res);
                visited[i] = false;
                path.remove(path.size() - 1);// 回溯
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        LC46 solution = new LC46();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(JSON.toJSON(lists));
    }

}
