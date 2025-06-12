package CM;

public class CM39 {
    public int countWays(int n) {
        // write code here
       int[] a = new int[10000];
       a[0] = 0;
       a[1] = 1;
       a[2] = 2;
       a[3] = 4;
       for(int i = 4; i<= n; i++){
           a[i] =( (a[i-1] + a[i-2]) %1000000007 + a[i-3]) % 1000000007;
       }

       return a[n];
    }

/*    public int count(int n ){
        if(n <= 0){
            return 0;
        }

        if(n == 1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(n == 3){
            return 4;
        }

        return count(n-1) + count(n-2) + count(n-3);
    }*/
}
