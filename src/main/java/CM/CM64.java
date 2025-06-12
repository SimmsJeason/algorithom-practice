package CM;

import java.util.ArrayList;

public class CM64 {
    public int[] calcResult(String A, String guess) {
        // write code here
        int [] res = new int[2];
        ArrayList<Character> deleted = new ArrayList<>();
        StringBuffer sb = new StringBuffer(A);
        StringBuffer sb2 = new StringBuffer(guess);

        int k =0;
        for(int i = 0; i < A.length(); i++){
            if(sb.charAt(i-k) == sb2.charAt(i-k)){
                res[0] ++;
                if(deleted.contains(sb.charAt(i-k))){
                    deleted.add(sb.charAt(i-k));
                }
                sb.deleteCharAt(i-k);
                sb2.deleteCharAt(i-k);
                k++;
            }
        }

        int length1 = sb.length();
        int length2 = sb2.length();
        k=0;
        for(int i = 0; i< length1; i++){
            for(int j = 0; j <length2 - k ; j++){
                if(sb.charAt(i-k) == sb2.charAt(j) && !deleted.contains(sb.charAt(i-k))){
                    res[1]++;
                    sb.deleteCharAt(i-k);
                    sb2.deleteCharAt(j);
                    k++;
                    break;
                }
            }
        }
        return res;
    }

}
