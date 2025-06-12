package WrittenExamination.qushikeji;

import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        Program1 program1 = new Program1();

        String res = program1.solute(str1, str2);
        System.out.println(res);
    }

    public String solute(String infix, String last){
        char[] chars1 = infix.toCharArray();
        char[] chars2 = last.toCharArray();


        return "";
    }

    private void build(char [] infix, int i, int j, char[] last, int m, int n, StringBuffer sb){
        if(n<m){
            return;
        }

        sb.append(last[n]);
        int k = i;

        while(infix[k] != last[n]){
            k++;
        }


    }
}
