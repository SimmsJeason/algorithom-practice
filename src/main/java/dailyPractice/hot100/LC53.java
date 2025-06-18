package dailyPractice.hot100;

import com.alibaba.fastjson.JSON;

/**
 * 最大子数组和
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组是数组中的一个连续部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 */
public class LC53 {

    //动态规划
    public int maxSubArray(int[] nums) {
        //f{i}表示 到i位置，加和最大值
        // f{i} = max(num[i],num[i] + f{i-1})
        int pre = 0, n = nums.length;
        int ans = Integer.MIN_VALUE;
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            if (i>0) {
                f[i] = Math.max(nums[i], nums[i] + pre);
            } else {
                f[i] = nums[i];
            }
            pre = f[i];
        }

        // 这个循环可以放上边
        for (Integer num : f) {
            ans = Math.max(ans, num);
        }
        return ans;
    }


    //滑动窗口，超时
    public int maxSubArray2(int[] nums) {

        int n = nums.length;
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                pre[i] = nums[i] + pre[i - 1];
            } else {
                pre[i] = nums[i];
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(pre[i], res);
            for (int j = i + 1; j < n; j++) {
                res = Math.max(pre[j], res);
                res = Math.max(pre[j] - pre[i], res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        LC53 lc53 = new LC53();
        System.out.println(JSON.toJSON(lc53.maxSubArray(nums)));
    }
}
