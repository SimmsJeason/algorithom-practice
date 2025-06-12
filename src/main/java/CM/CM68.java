package CM;

public class CM68 {
    public int getMaxSum(int[] A, int n) {
        // write code here
        int res = A[0];
        for(int i = 1; i< A.length; i++){
            A[i] += Math.max(A[i-1], 0);
            res = Math.max(res, A[i]);
        }
        return res;
    }

   /* public int maxSubNuM(int [] values){
        int res = 0;
        for(int i = 1; i< values.length; i++){
            values[i] = Math.max(values[i-1], 0);
            res = Math.max(res, values[i]);
        }
    }*/

}
