package Hot100;

/**
 * 盛最多水的容器
 */


public class LC11 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right) {
            int area =  (right - left) * Math.min(height[right], height[left]);
            maxArea = Math.max(area, maxArea);
            if (height[right] < height[left]){
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }


    /**
     * 超时
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int cur = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(cur, maxArea);
            }
        }
        return maxArea;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        LC11 lc11 = new LC11();
        System.out.println(lc11.maxArea(nums));
    }
}
