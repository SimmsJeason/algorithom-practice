package WrittenExamination.WeiLaiXing;


/**
 * 和为 0 的最长子串长度
 */
public class Main2 {
    int maxLen;
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        int [] array = {3,5,-1,-6,2,1,0};

        Main2 test = new Main2();
        System.out.println(test.findTargetLen2(array));
    }

    public int solve (int [] array){

        findTargetLen1(array, 0, 0, 0);
        return maxLen;
    }


    //非连续子串长度
    public void findTargetLen1(int[] array, int sum, int len, int start){
        if(start == array.length){
            return;
        }

        if(sum == 0){
            maxLen = Math.max(len, maxLen);
        }

        for(int i = start; i <  array.length; i ++){
            findTargetLen1(array, sum - array[i], len + 1,  start +1);//减掉这个数
            findTargetLen1(array, sum, len, start + 1);//不减这个数
        }

    }

    //连续最长子串
    int findTargetLen2(int[] nums)
    {

        int res = 0;
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] == 0 || nums[i - 1] == 0) res = 1;
            nums[i] = nums[i] + nums[i - 1];
        }

        for (int i=nums.length-1;i>0;i--)
            for (int j = i - 1; j >= 0; j--)
                if (nums[j] == nums[i])res = Math.max(res, i - j);///说明 i 到 j之间的和为 0
        return res;
    }

}
