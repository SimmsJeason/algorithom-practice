package CM;

public class CM73 {
   /* public int countNumberOf2s(int n) {
        // write code here

        int [] dp = new int[n];

        dp[0] = 0;
        for(int i = 2; i <= n; i++){
            if(check(i)){
                dp[i-1] = dp[i-2] + 1;
            }else {
                dp[i-1] = dp[i-2];
            }
        }
        return dp[n-1];
    }

    public boolean check (int n){
        if(n == 0){
            return false;
        }

        if(n % 10 == 2){
            return true;
        }else {
            return check(n/10);
        }
    }
*/

    public int countNumberOf2s(int n) {
        // write code here
        int count = 0 ;
        if(n <= 1){
            return 0;
        }

        for (int i = 1; i <= n; i *= 10) {
            int a = n / i, b = n % i;
            //之所以补7，是因为当百位为0，则a/10==(a+8)/10，
            //当百位>=3，补7会产生进位，效果等同于(a/10+1)
            count += (a + 7) / 10 * i + ((a % 10 == 2) ? b + 1 : 0);
        }
        return count;
    }


}
