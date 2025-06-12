package WrittenExamination.Qianxin;

import java.util.LinkedList;
import java.util.Queue;

public class Main2 {
    public static void main(String[] args) {
        int [] array = {1,1,1,2,3,3,3};

        Main2 test = new Main2();
        System.out.println(test.leastWorkTime(array, 2));
    }
    /**
     *
     * @param tasks int整型一维数组 待加工的零件
     * @param n int整型 n的值
     * @return int整型
     */
    public int leastWorkTime (int[] tasks, int n) {
        // write code here

        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;
        int fill = Integer.MAX_VALUE;

        int len = tasks.length;
        boolean [] visited = new boolean[len];

        while(!allVisited(visited)){
            int size = queue.size();
            boolean needPoll = false;
            if(size == n){
                needPoll = true;
            }

            for(int i = 0 ; i < len; ){
                if(!visited[i]){
                    if(queue.contains(tasks[i])){
                        queue.add(fill);
                    }else {
                        queue.add(tasks[i]);
                        i++;
                        visited[i] = true;
                    }
                    cnt++;

                }else {
                    i++;
                    continue;
                }
            }

            if(needPoll){
                queue.poll();
            }
        }

        return cnt;
    }

    public boolean allVisited(boolean [] visited){
        for(int i = 0 ; i < visited.length; i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
}
