package WrittenExamination.Wanmeishijie;

import java.util.Scanner;

public class    Main4 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();

        Main4 test  = new Main4();

        System.out.println(test.solve(m, n));
    }

    public int solve(int m, int n ){
        if(m == 0 || n == 1){
            return 1;
        }
        if(n > m){
            return solve(m,m);
        }else {
            return solve(m,n-1) + solve(m-n,n);
        }
    }
}
