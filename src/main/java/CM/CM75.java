package CM;

import java.lang.management.ManagementFactory;
import java.util.Arrays;

public class CM75 {
    public int[] findNext(int[] A, int n) {
        // write code here
        int []res = new int [n];
        if(n == 0){
            return res;
        }
        res[n-1] = -1;
        if(n == 1){
            return res;
        }

        for(int i =0; i < n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = i+1; j<n; j++){
                if(A[i]< A[j] ){
                    min = Math.min(min, A[j]);
                }
            }
           if(min != Integer.MAX_VALUE){
               res[i] = min;
           }else {
               res[i] = -1;
           }
        }
        return res;
    }

}
