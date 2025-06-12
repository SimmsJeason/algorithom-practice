package CM;

public class CM59 {
    public int[] getRankOfNumber(int[] A, int n) {
        int[] result = new int[n];
        for(int i=1;i<n;i++){
            int count =0;
            for(int j=0;j<i;j++){
                if(A[j]<A[i]){
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }

}
