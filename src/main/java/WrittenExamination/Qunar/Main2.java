package WrittenExamination.Qunar;


import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String tmp2 = in.nextLine();
        String sortS1 = in.nextLine();
        String sortS2 = in.nextLine();
       /* int n = 7;
        String sortS1 = "a b c d e f g";
        String sortS2 = "b d a c f g e";*/
         String [] chars1 = sortS1.split(" ");
         String [] chars2 = sortS2.split(" ");
         Main2 test = new Main2();
        System.out.println(test.solve(n, chars1, chars2));
    }

    private int solve(int n, String[] sort1, String[] sort2 ){
        int len = sort1.length;
        int [][] dp = new int[len+1][len+1];

        for(int i = 1 ; i <= len; i ++){
            for(int j = 1; j <= len; j++){
                if(sort1[i-1].equals(sort2[j-1])){

                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

      return dp[len][len];
    }
}
