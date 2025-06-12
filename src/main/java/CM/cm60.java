package CM;

public class cm60 {

    public int count(int[] A, int n) {
        // write code here
        if(n-1 < 0){
            return 0;
        }

        int count = 0;
        for(int i = n-2; i>=0; i--){
            if(A[n-1] < A[i]){
                count++;
            }
        }
        return count + count(A, n-1);
    }
}
