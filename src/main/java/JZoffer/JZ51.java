package JZoffer;

public class JZ51 {
    public int[] multiply(int[] A) {

        int[] B = new int[A.length];
        if(A == null || A.length == 0){
            return B;
        }


        for(int i = 0; i< B.length; i++){
            B[i] = 1;

            for(int j = 0; j< A.length; j++){
                if(j != i){
                    B[i] *= A[j];
                }
            }
        }
        return B;
    }
}
