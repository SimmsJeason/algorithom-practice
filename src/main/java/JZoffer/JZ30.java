package JZoffer;

public class JZ30 {
    /**
     *
     使用动态规划
     F（i）：以array[i]为末尾元素的子数组的和的最大值，子数组的元素的相对位置不变
     F（i）=max（F（i-1）+array[i] ， array[i]）
     res：所有子数组的和的最大值
     res=max（res，F（i））
     */
    public int FindGreatestSumOfSubArray(int[] array) {

        int max = array[0];
        int res = array[0];
        for(int i = 1;i< array.length; i++){
            max = Math.max(max + array[i], array[i]);
            res = Math.max(res,max);
        }
        return res;
    }
}
