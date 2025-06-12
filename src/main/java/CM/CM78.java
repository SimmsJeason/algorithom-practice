package CM;

public class CM78 {
    public int[] getMiddle(int[] A, int n) {
        // write code here
        int [] tmp = new int[n];
        int [] res = new int[n];
        if(A == null || n == 0){
            return res;
        }

        res[0] = A[0];
        tmp[0] = A[0];
        for(int i =1 ; i< n; i++){
            res[i] = insertSort(tmp, A[i], i + 1);
        }
        return res;
    }

    public int insertSort (int [] array, int insertNum , int length){
        int i = length-1;

        array[i] = insertNum;
        while(i >0 && array[i-1] > array[i]){
            int tmp = array[i];
            array[i] = array[i-1];
            array[i-1] = tmp;
            i--;
        }

        return array[(length-1)/2];
    }


           // 21993, 40359,116289,121674,236312,257841
}
