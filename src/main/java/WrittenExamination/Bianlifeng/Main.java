package WrittenExamination.Bianlifeng;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String array = in.nextLine();

        Random random = new Random();
        int num = random.nextInt(3);
     /*   for(int i = 0; i < 10 ;i++){
            System.out.println(random.nextInt(2));
        }*/
        if(num == 1){
            System.out.println('Y');
        }else {
            System.out.println('N');
        }

    }
    public boolean solve(int[][] edges){
        int [][] graph = new int[10000][10000];
        boolean[][] visited = new boolean[10000][10000];

        int len = edges.length;

        for(int k= 0; k < len ;k++){
            int i = edges[k][0];
            int j = edges[k][1];

            graph[i][j] = 1;
            graph[j][i] = 1;
        }

        for(int i = 0; i < len; i++){

        }

        return false;
    }

    public int dfs ( int [][] graph, int from, int to, boolean [][] visited){
        return 0;
    }
}
