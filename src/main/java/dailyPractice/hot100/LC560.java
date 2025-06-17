package dailyPractice.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为 K 的子数组
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * <p>
 * 子数组是数组中元素的连续非空序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 */
public class LC560 {
    /**
     * pre[i] 表示 0~i 所有数之和 pre[i] = pre[i-1] + nums[i]
     * j~i 之和 = pre[i]-pre[j] == k
     * 用map key = pre[i]的值，key = 出现的次数
     * 用map.get(pre - k) + count  即为结果
     */

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> valueCount = new HashMap<>();
        valueCount.put(0, 1); //初始化，当没有进入循环前，需要一个和为0
        int count = 0;
        int pre = 0;
        for (Integer num : nums) {
            pre += num;
            count += valueCount.getOrDefault(pre - k, 0);
            int co = valueCount.getOrDefault(pre, 0);
            valueCount.put(pre, co + 1);
        }
        return count;
    }

    /**
     * 枚举法，超时
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i == j && nums[j] == k) {
                    res++;
                    continue;
                }
                int cur = 0;
                for (int l = i; l <= j; l++) {
                    cur += nums[l];
                }
                if (cur == k) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0};
        LC560 lc560 = new LC560();
        System.out.println(lc560.subarraySum(nums, 0));
    }
}
