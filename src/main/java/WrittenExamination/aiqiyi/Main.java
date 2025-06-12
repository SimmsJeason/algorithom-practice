package WrittenExamination.aiqiyi;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        //String str = "abcdab";
        Main test = new Main();
        System.out.println(test.solute(str));
    }

    /**
     *dp[i] = max;
     *
     */
    public int solute(String str){
        int max = 0;
        int len = str.length();
        if(len == 0) return 0;

        boolean [] word = new boolean[226];

        int [] dp = new int[len +1];

        int cnt = 0;
        for(int i = 0; i< len; i++){
            char cur = str.charAt(i);
            if(word[Integer.valueOf(cur)]){
                max = Math.max(max, cnt);
                cnt = 0;
                Arrays.fill(word, false);
            }else {
                word[Integer.valueOf(cur)] = true;
                cnt ++;
            }
        }

        return max;
    }
}
