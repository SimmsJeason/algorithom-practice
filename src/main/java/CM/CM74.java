package CM;

public class CM74 {
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
            for(int j = i+1; j<n; j++){
                if(A[i]< A[j] ){
                    res[i] = A[j];
                    break;
                }
            }
            if(res[i] == 0){
                res[i] = -1;
            }
        }
        return res;
    }
}
