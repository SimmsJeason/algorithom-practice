package TypicalAlgorithm.Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * 注意:
 *
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 *
 * 输入: [ [1,2], [1,2], [1,2] ]
 *
 * 输出: 2
 *
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 *
 * 输入: [ [1,2], [2,3] ]
 *
 * 输出: 0
 *
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC435 {
    /**
     * 先计算最多能组成的不重叠区间个数，然后用区间总个数减去不重叠区间的个数。
     *
     * 在每次选择中，区间的结尾最为重要，选择的区间结尾越小，留给后面的区间的空间越大，那么后面能够选择的区间个数也就越大。
     *
     * 按区间的结尾进行排序，每次选择结尾最小，并且和前一个区间不重叠的区间。
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int cnt = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            cnt++;
        }
        return intervals.length - cnt;
    }




    public int eraseOverlapIntervals2(int[][] intervals) {
        int count = 0;
       Arrays.sort(intervals, new Comparator<int[]>() {
           @Override
           public int compare(int[] o1, int[] o2) {
               if(o1[0] == o2[0]){
                   return o1[1] -o2[1];
               }else {
                   return o1[0] - o2[0];
               }
           }
       });

       int start = Integer.MAX_VALUE;
       int end = Integer.MIN_VALUE;

       boolean flag = false;

       for(int i = 0; i< intervals.length; i++){
           if(start > intervals[i][0]){
               start = intervals[i][0];
               flag = true;
           }
           if(end < intervals[i][1]){
               end = intervals[i][1];
               flag = true;
           }

           if(intervals[i][0] >= start && intervals[i][1] <= end && !flag) count ++;
       }

       return count;
    }
}

