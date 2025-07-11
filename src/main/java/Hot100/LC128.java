package Hot100;

import java.util.*;

/**
 * 128. 最长连续序列
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * 示例 3：
 *
 * 输入：nums = [1,0,1,2]
 * 输出：3
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class LC128 {
    /**
     * 散列表
     */
    public int longestConsecutive(int[] nums) {
       Set<Integer> set = new HashSet<>();
       for (int num : nums) {
           set.add(num);
       }
       int max = 0;
       for (int num : set) {
           if (!set.contains(num -1)) {
               int cur = num;
               int length = 0;
               while (set.contains(cur)) {
                   length ++;
                   cur++;
               }
               max = Math.max(max, length);
           }
       }
       return max;
    }

    public static void main(String[] args) {
        int [] nums = new int[] {9,1,4,7,3,-1,0,5,8,-1,6};
        LC128 lc128 = new LC128();
        System.out.println(lc128.longestConsecutive(nums));
    }
}
