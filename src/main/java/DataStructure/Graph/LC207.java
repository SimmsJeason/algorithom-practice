package DataStructure.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 *
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 *
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *  
 *
 * 提示：
 *
 * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 1 <= numCourses <= 10^5
 *
 *
 */
public class LC207 {
    //拓扑排序,说白了就是检验是否是有向无环图
    //BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //入度表
        int[] indegrees = new int[numCourses];

        //邻接表
        List<List<Integer>> adjacency = new ArrayList<>();

        //入度为 0 的入队
        Queue<Integer> queue = new LinkedList<>();

        //初始化邻接表
        for(int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());

        // Get the indegree and adjacency of every course.
        for(int[] cp : prerequisites) {
            // 图的方向为： cp[1] -> cp[0]
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }

        // Get all the courses with the indegree of 0.
        for(int i = 0; i < numCourses; i++)
            if(indegrees[i] == 0) queue.add(i);

        // BFS TopSort.
        while(!queue.isEmpty()) {
            //出队课程即为要删除的课程
            int pre = queue.poll();
            numCourses--;//删除课程

            for(int cur : adjacency.get(pre))
                if(--indegrees[cur] == 0) queue.add(cur);
        }
        return numCourses == 0;
    }

}
