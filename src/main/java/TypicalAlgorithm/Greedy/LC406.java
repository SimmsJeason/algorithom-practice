
package TypicalAlgorithm.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC406 {

    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0 || people[0].length == 0){
            return new int[0][0];
        }

        /**
         * 为了使插入操作不影响后续的操作，身高较高的学生应该先做插入操作，
         * 否则身高较小的学生原先正确插入的第 k 个位置可能会变成第 k+1 个位置。
         *
         * 身高 h 降序、个数 k 值升序，然后将某个学生插入队列的第 k 个位置中。
         */

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else {
                    return o2[0] - o1[0];
                }
            }
        });

        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }

        return queue.toArray(new int[queue.size()][]);
    }
}
