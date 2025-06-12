package WrittenExamination.Tongcheng58;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Main2 test = new Main2();
        System.out.println(test.solve(n));
    }

    public String solve(int n ){
        int [] array = new int[n+1];
        for(int i = 0 ; i <= n ; i++){
            array[i] = count(i);
        }

        return Arrays.toString(array);
    }

    private int count ( int n){
        int cnt = 0;
        while(n>0){
            if(n%2 == 1){
                cnt++;
            }

            n = n >> 1;
        }
        return cnt;
    }
}
