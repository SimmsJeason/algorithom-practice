package CM;

import java.util.Arrays;
import java.util.Comparator;

public class CM58 {
    //参考前面一题的方法（求解最长递增子序列），这里的二维数组可以简化为一维的问题。
    // 因为身高是递增顺序的情况下，求出的最大体重递增子序列其身高一定也是递增的序列。

    public int getHeight(int[][] actors, int n) {
        // write code here
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0] < b[0]){
                    return -1;
                }else if(a[0] > b[0]){
                    return 1;
                }else {
                    if(a[1] < b[1]){
                        return -1;
                    }else if(a[1] > b[1]){
                        return 1;
                    }else {
                        return 0;
                    }
                }
            }
        };

        Arrays.sort(actors, comparator);

        if(n < 1){
            return 0;
        }
        int [] dp = new int[n];
        dp[0] = 1;

        int result = 0;

        //dp[i] = 0 -> m[i-1] 中 小于 m[i] 元素的值对应的dp最大值加1
        for(int i = 1; i < n ;i++){
            int j =0 ;
            int max = 0;
            while(j < i){
                if(actors[j][1] < actors[i][1]){
                    max = Math.max(max, dp[j]);
                }
                j++;
            }

            dp[i] = max +1;
            if(result < dp[i]){
                result = dp[i];
            }
        }

        return result;
    }
}
