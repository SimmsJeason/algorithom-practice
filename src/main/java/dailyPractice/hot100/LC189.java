package dailyPractice.hot100;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 轮转数组
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 */
public class LC189 {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

    //使用队列
    public void rotate2(int[] nums, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            queue.add(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            queue.add(queue.poll());
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            nums[i] = queue.poll();
        }
        return;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        LC189 lc189 = new LC189();
        lc189.rotate(nums, 3);
        System.out.println(JSON.toJSON(nums));
    }
}
