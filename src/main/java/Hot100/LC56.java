package Hot100;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间
 */
public class LC56 {

    public int[][] merge(int[][] intervals) {
        //我的思路：先按end排序,然后依次判断，当前区间的end是否在下一个区间内，如果在则合并
        //题解:按左端点排序，merge记录结果
        //如果当前区间的左端点在数组 merged 中最后一个区间的右端点之后，那么它们不会重合，我们可以直接将这个区间加入数组 merged 的末尾；
        //否则，它们重合，我们需要用当前区间的右端点更新数组 merged 中最后一个区间的右端点，将其置为二者的较大值
        if (intervals.length == 0) {
            return new int[0][2];
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> merged = new ArrayList<>();
        for (int[] arr: intervals){
            int l = arr[0]; int r = arr[1];
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < l) {//不重合，直接追加
                merged.add(arr);
            } else {
                r = Math.max(merged.get(merged.size() - 1)[1], r);
                int[] newArr = new int[]{merged.get(merged.size() - 1)[0], r};
                merged.set(merged.size() - 1, newArr);
            }
        }
        int[][]res = new int[merged.size()][2];
        for(int i = 0; i<merged.size(); i++){
            res[i] = merged.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        LC56 lc56 = new LC56();
        System.out.println(JSON.toJSON(lc56.merge(nums)));
    }
}
