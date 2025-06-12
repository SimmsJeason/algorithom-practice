package CM;

import java.util.Arrays;

public class CM66 {
    public int[] findSegment(int[] A, int n) {
        // write code here
        int [] res = new int[2];

        int [] sorted = new int[n];
        for(int i =0 ;i< n; i++){
            sorted[i] = A[i];
        }
        Arrays.sort(sorted);
        for(int i = 0; i< n; i++){
            if(A[i] != sorted[i]){
                res[0] = i;
                break;
            }
        }

        for(int i =n-1; i>=0; i--){
            if(A[i] != sorted[i]){
                res[1] = i;
                break;
            }
        }
        return res;
    }
}
