package TypicalAlgorithm.DP.最长递增子序列;

import java.util.Arrays;

/**
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 *
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 *
 * 给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 *
 * 示例 :
 *
 * 输入: [[1,2], [2,3], [3,4]]
 * 输出: 2
 * 解释: 最长的数对链是 [1,2] -> [3,4]
 * 注意：
 *
 * 给出数对的个数在 [1, 1000] 范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-pair-chain
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LC646 {
    public int findLongestChain(int[][] pairs) {
        if(pairs == null || pairs.length == 0 || pairs[0].length == 0){
            return 0;
        }

        Arrays.sort(pairs, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }else {
                return o1[0] -o2[0];
            }
        });

        int n = pairs.length;
        int [] dp = new int[n];
        dp[0] = 1;
        for(int i = 1 ; i < n ;i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(pairs[j][1] < pairs[i][0]){
                    max = Math.max(max, dp[j]);
                }

                dp[i] = max +1;
            }
        }

        int ans = 0;
        for(int i =0; i< n; i++){
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
