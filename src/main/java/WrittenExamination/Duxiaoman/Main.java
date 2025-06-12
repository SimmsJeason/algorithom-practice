package WrittenExamination.Duxiaoman;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main test = new Main();
        Scanner in = new Scanner(System.in);

        String str1 = in.nextLine();
        String str2 = in.nextLine();
        System.out.println(test.solve(str1,str2));
    }

    public int solve(String str1, String str2){
        char [] chars1 = str1.toCharArray();
        char [] chars2 = str2.toCharArray();

        int cnt = 0;
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        int l = 0;
        int r = 0;
        for(; l < chars1.length && r < chars2.length; ){
            if(chars1[l] == chars2[r]){
                l++;
                r++;
                cnt ++;
            }else if(chars1[l] > chars2[r]){
                r++;
            } else if(chars1[l] < chars2[r]){
                l++;
            }
        }
        return cnt;
    }
}
