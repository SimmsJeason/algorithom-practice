package WrittenExamination.qushikeji;

import java.util.Arrays;

public class program2 {
    public static void main(String[] args) {
     /*   Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        int n = in.nextInt();*/
        program2 program2 = new program2();

      String str1 = "123456";
      int num = 3;
        String res = program2.solute(str1, num);
        System.out.println(res);
    }

    public String solute(String str, int n){
        char [] chars = str.toCharArray();
        char [] chars1 = str.toCharArray();

        Arrays.sort(chars);

        char[] rem = new char[n];

        boolean [] visited= new boolean[n];

        int q = 0;

        for(int i = chars.length-1; n> 0 ; i--,n--){
            rem [q] = chars[i];
            q++;
        }

        StringBuffer sb = new StringBuffer();

        boolean skip = false;
        for(int i =0; i< chars1.length; i++){

            for(int j = 0; j < n;j++){
                if(chars1[i] == rem[j] && !visited[j]){
                    visited[j] = true;
                    skip = true;
                }
            }
            if(skip){
                skip = false;
                continue;
            }
            sb.append(chars1[i]);
        }

        return sb.toString();
    }

}
