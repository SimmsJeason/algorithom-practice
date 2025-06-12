package CM;

import java.util.Arrays;

public class CM70 {
    public int countPairs(int[] A, int n, int sum) {
        // write code here
        Arrays.sort(A);
        int k = -1;
        for(int i = n-1; i>=0; i--){
            if(A[i] < sum){
                k = i;
                break;
            }
        }

        if(k == -1){
            return 0;
        }

        int count = 0;
        for(int i =0 ;i< k; i++){
            for(int j = i+1; j<=k ;j++){
                if(A[i] + A[j] == sum){
                    count++;
                }
            }
        }
        return count;
    }
}
