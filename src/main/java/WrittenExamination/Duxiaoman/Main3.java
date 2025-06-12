package WrittenExamination.Duxiaoman;

import javafx.util.Pair;

import java.util.*;

public class Main3 {

    int ans = 0;
    List<Integer> anss = new ArrayList<Integer>();
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
       String [] strings = new String[m];

       //处理
        char[][] chars = new char[m][n];
        for(int i = 0 ; i < m ; i++){
            chars[i] = strings[i].toCharArray();
        }


    }

    public int solve(char [][] map, int m, int n){
        boolean [][] visited = new boolean[m][n];


        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == '@') {

                    break;
                }
            }
        }

        return 0;
    }

    public int bfs (char [][] map, int r, int c, boolean[][] visited ){
        int m = map.length;
        int n = map[0].length;

        int [][] directions = {{0,1},{0,-1}, {1,0}, {-1, 0}};

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        queue.add(new Pair<>(r,c));

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size -- > 0){

                Pair<Integer, Integer> cur = queue.poll();
                int cr = cur.getKey();
                int cc = cur.getValue();
                if(map[cr][cc] == '#'){
                    continue;
                }

            }



        }

        return 0;
    }
}
