package WrittenExamination.qushikeji;

import java.util.Arrays;

public class ppp {
    public static void main(String[] args) {
        String str = "123456";
        ppp ppp = new ppp();

        System.out.println(ppp.work(str,7));
    }
    public void solute(String str, int n){
        if(n == 0){
            System.out.println(str);
        }else {
            if(str.length() <= n){
                System.out.println("");
            }else {
                System.out.println(work(str,n));
            }
        }

    }
    public String work(String str, int n ){
        if(str.length() == 0 || str.length() >=n){
            return "";
        }
        if(n <= 0){
            return str;
        }
        char[] chars = str.toCharArray();
        char[] char1 = str.toCharArray();
        int len = chars.length-1;

        Arrays.sort(char1);
        StringBuffer sb = new StringBuffer();

        boolean hasrem = false;
        for(int i = 0; i< chars.length; i++){
            if(chars[i] == char1[len] && !hasrem){
                hasrem = true;
                continue;
            }
            sb.append(chars[i]);
        }
        return work(sb.toString(), n-1);
    }
}
