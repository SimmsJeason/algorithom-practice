package Hot100;

import com.alibaba.fastjson.JSON;

/**
 * 除自身以外数组的乘积
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 * <p>
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 */
public class LC238 {

    public int[] productExceptSelf(int[] nums) {
        // ans[i] * nums[i] = N
        // ans[i] = left[i-1] * right[i+1]
        int n = nums.length;
        int [] left = new int[n];
        int [] right = new int[n];
        int [] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                left[i] = nums[i];
            } else {
                left[i] = nums[i] * left[i-1];
            }
        }
        for (int i = n-1; i >=0; i--) {
            if (i == n-1) {
                right[i] = nums[i];
            } else {
                right[i] = nums[i] * right[i+1];
            }
        }

        for(int i = 0; i< n; i++) {
            if (i == 0) {
                ans[i] = right[i+1];
            } else if ( i == n-1){
                ans[i] = left[i-1];
            } else {
                ans[i] = left[i-1] * right[i+1];
            }
        }
        return ans;
    }


    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int cur = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    cur *= nums[j];
                }
            }
            ans[i] = cur;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        LC238 lc238 = new LC238();

        System.out.println(JSON.toJSON(lc238.productExceptSelf(nums)));
    }
}
