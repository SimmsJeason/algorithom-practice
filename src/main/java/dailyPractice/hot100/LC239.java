package dailyPractice.hot100;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 滑动窗口最大值
 * https://leetcode.cn/problems/sliding-window-maximum/?envType=study-plan-v2&envId=top-100-liked
 */
public class LC239 {

    /**
     * 优先队列
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int []> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
               return o1[0] != o2 [0] ? o2[0] - o1[0] : o2[1] - o1[1];//值和下标
            }
        });

        int [] ans = new int[n - k + 1];

        //把前k个元素入队
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(new int[]{nums[i], i});
        }
        ans[0] = priorityQueue.peek()[0]; //前k个元素最大值

        for (int i = k; i < n; i++){
            priorityQueue.offer(new int[]{nums[i], i}); //入队
            int[] max = priorityQueue.peek();
            while(priorityQueue.peek()[1] < i- k + 1) {//最大值所在下标如果出了左边界，那就出队
                priorityQueue.poll();
            }
            ans[i-k+1] = priorityQueue.peek()[0];
        }
        return ans;
    }


    //超时
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length <= k) {
            Arrays.sort(nums);
            return new int[]{nums[nums.length - 1]};
        }

        int[] res = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i - k+1; j <= i; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i - k+1] = max;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        LC239 lc239 = new LC239();
        System.out.println(JSON.toJSON(lc239.maxSlidingWindow(nums, 3)));
    }
}
