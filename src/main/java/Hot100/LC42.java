package Hot100;

/**
 * 接雨水
 */
public class LC42 {
    /**
     * 动态规划
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int maxLeft = 0;
        int maxRight = 0;
        for (int i = 0; i < n; i ++) {
            maxLeft = Math.max(maxLeft, height[i]);
            leftMax[i] = maxLeft;
        }

        for (int i = n - 1; i >= 0; i--) {
            maxRight = Math.max(maxRight, height[i]);
            rightMax[i] = maxRight;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }


    /**
     * 超时
     * 一层一层计算
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int max = 0;
        for(int num : height) {
            max = Math.max(max, num);
        }
        int res = 0;
        for (int i = 1; i <= max ; i++) {
            int fast = -1;
            int slow = -1;
            int[] level = new int[height.length];
            for (int j = 0; j < height.length; j++) {
                if (height[j] >=i) {
                    level[j] = 1;
                } else {
                    level[j] = 0;
                }
            }

            for (int j = 0; j < level.length; j ++) {
                if (j > 0 && level[j] == 0 && level[j-1] == 1) {
                    slow = j;
                }

                if (j > 0 && level[j] == 1 && level[j-1] == 0 && j > slow) {
                    fast = j;
                }
                if (fast > slow && fast * slow > 0) {
                    res += fast - slow;
                    slow = -1;
                    fast = -1;
                }
            }

        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        LC42 lc42 = new LC42();
        System.out.println(lc42.trap(nums));
    }
}
