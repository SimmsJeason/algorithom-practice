package WrittenExamination.Youzan;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main test = new Main();
        int [] A = {1,1};
        int [] B ={2,2};
        int [] res = test.fairCandySwap(A, B);
        System.out.println(Arrays.toString(res));
    }
    public int[] fairCandySwap (int[] A, int[] B) {
        // write code here
        int [] res = new int[2];
        Arrays.sort(A);
        Arrays.sort(B);
        int sumA = 0;
        int sumB = 0;
        for(int i = 0 ; i < A.length; i++){
            sumA += A[i];
        }

        for(int i = 0 ; i < B.length; i++){
            sumB += B[i];
        }

        int k = Math.abs(sumA - sumB)/2;
        int i = 0 ,j = 0;
        for(;i<A.length && j < B.length; ){
            int tmp = Math.abs(A[i] - B[j]);

            if(tmp < k){
                if(A[i] > B[j]){
                    i++;
                }else {
                    j++;
                }
            }else if(tmp > k){
                if(A[i] > B[j]){
                    j++;
                }else {
                   i++;
                }
            }else {
                break;
            }
        }
        res[0] = A[i];
        res[1] = B[j];
        return res;
    }
}
