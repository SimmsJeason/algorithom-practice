package WrittenExamination.W360;

import java.util.*;

public class Main2 {
    int cnt = 0;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
             /*   int a = 10;//物品总数
        int b = 3;//隔板数
        int k = 2;//箱子最多分成k个空间
        int v = 1;//每个隔间最多放的数量*/

        Main2 test = new Main2();

        while(in.hasNextInt()){
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();
            int v = in.nextInt();
            System.out.println(test.solve(a, b, k, v));
        }

    }

    public int  solve(int a, int b, int k, int v){
        cnt = 0;
        work(a, b, k ,v);
        return cnt;
    }

    public void work(int a, int b, int k, int v){
        if(a <= 0){
            return;
        }

        if(b>0){
            //剩余隔板数够
            if(k-1  <= b){
                int canPut = k*v;
                cnt ++;
                work(a - canPut, b+1 - k, k, v);

            }else {//不够
                int canPut = (b+1) * v;
                cnt  ++;
                work(a- canPut, 0, k ,v);
            }

        }else {
            int canPut = v;
            cnt ++;
            work(a - canPut, 0, k, v);
        }
    }

    /*public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int m = in.nextInt();
            int n = in.nextInt();
            int c = in.nextInt();
            System.out.println("m =" + m + "n = " + n + " c = " + c);
        }
    }

    public int solve(int start, int end, int [][] graph){
        if(start > end){
            int tmp = start;
            start = end;
            end = tmp;
        }


        return 0;
    }

    public void backTracking(List<Integer> cur, List<List<Integer>> res, int start, int aim){
        if(start == aim){
            res.add(new ArrayList<>(cur));
            return;
        }


    }*/
}
