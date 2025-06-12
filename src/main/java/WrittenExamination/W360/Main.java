package WrittenExamination.W360;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    int cnt = 0;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
             /*   int a = 10;//物品总数
        int b = 3;//隔板数
        int k = 2;//箱子最多分成k个空间
        int v = 1;//每个隔间最多放的数量*/

        Main test = new Main();
        List<String> input = new ArrayList<>();


        while(in.hasNextInt()){
            String str = in.nextLine();
            input.add(str);
        }

        int [][] nums = new int[input.size()][4];

        for(int i = 0; i < input.size(); i++){
            String [] strings = input.get(i).split(" ");
            int [] num = new int[4];
            for(int j = 0; j < 4; j ++){
                num[j] = Integer.valueOf(strings[j]);
            }
            nums[i] = num;
        }

        for(int i = 0 ; i < nums.length; i++){
            System.out.println(test.solve(nums[i][0], nums[i][1], nums[i][2], nums[i][3] ));

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
            if(k-1  < b){
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
}
