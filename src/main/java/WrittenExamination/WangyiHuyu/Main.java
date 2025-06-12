package WrittenExamination.WangyiHuyu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main test = new Main();

        int C = in.nextInt();
        for(int i = 0; i < C; i++){
            int N = in.nextInt();
            int M = in.nextInt();
            int [][] nums = new int[M][2];
            for(int j = 0 ; j < M; j++){
                nums[j][0] = in.nextInt();
                nums[j][1] = in.nextInt();
            }

            test.solve(N, M, nums);
        }

      /*  int N = 7;
        int M = 3;
        int [] []array ={ {1}};*/


    }

    public void solve(int N, int M, int [][] positions){
        int [][] map = new int[N][N];
        buildMap(N, 0, 1, map, true);
        for(int [] position : positions){
            int r = position[0];
            int c = position[1];
            System.out.println(map[r][c]);
        }
    }

    public void buildMap (int N, int current, int cnt, int [][] map, boolean shun){
        if(current >= N-1){
            return;
        }

       if(shun){
           //上
           for(int i = current; i < N-current; i++){
               map[current][i] = cnt;
               cnt++;
           }
           //右
           for(int i = current+1; i< N-current; i++){
               map[i][N-1-current] = cnt;
               cnt++;
           }
           //下
           for(int i = N-1-current-1; i >= current; i--){
               map[N-1-current][i] = cnt;
               cnt++;
           }
           //左
           for(int i = N-1-current -1; i > current; i--){
               map[i][current] = cnt;
               cnt++;
           }

       }else {
           //左
           for(int i = current; i < N-current; i++){
               map[i][current] = cnt;
               cnt++;
           }
           //下
           for(int i = current +1; i <N-current; i++){
               map[N-1-current][i] = cnt;
               cnt++;
           }
           //右
           for(int i = N-1-current-1; i>= current; i--){
               map[i][N-1-current] = cnt;
               cnt++;
           }
           //上
           for(int i = N-1-current-1; i > current; i--){
               map[current][i] = cnt;
               cnt++;
           }
       }
       buildMap(N, current+1, cnt, map, !shun);
    }
}
