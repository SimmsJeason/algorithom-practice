package WrittenExamination.aiqiyi;

import java.util.ArrayList;
import java.util.List;

public class Main4 {
    int [][] directions = {{1,0}, {0,1}};
    int m;
    int n;

    public static void main(String[] args) {
        int [] [] graph = {{2,3,1},{2,5,3},{4,2,1}};
        Main4 test = new Main4();
        int res = test.solve(graph);
        System.out.println(res);
    }

    public int solve(int [][] graph){
        m = graph.length;
        n = graph[0].length;

        List<Integer> res = new ArrayList<>();
        backTracing(res, new ArrayList<>(), graph, 0, 0);
        int max = 0;
        for(Integer tmp : res){
            max = Math.max(max, tmp);
        }
        return max;
    }

    public void backTracing(List<Integer> res, List<Integer> cur, int [][] graph, int i, int j) {
        if(cur.size() == (m+n -1)){
            int sum = 0;
            for(Integer num : cur){
                sum += num;
            }
            res.add(sum);
            return;
        }

        if(i >= m || j >= n){
            return;
        }

        for(int[] direction : directions){
            cur.add(graph[i][j]);
            backTracing( res, cur, graph, i + direction[0], j + direction[1]);
            cur.remove(cur.size()-1);
        }
    }
}
