package TypicalAlgorithm.DoublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
        * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
        *
        * 注意：答案中不可以包含重复的三元组。
        *
        *  
        *
        * 示例：
        *
        * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
        *
        * 满足要求的三元组集合为：
        * [
        *   [-1, 0, 1],
        *   [-1, -1, 2]
        * ]
        *
        * 来源：力扣（LeetCode）
        * 链接：https://leetcode-cn.com/problems/3sum
        * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        */
public class LC15 {
    public static void main(String[] args) {
        int [] array = {-1,0,1,2,-1,-4};

        Arrays.sort(array);
        LC15 lc15 = new LC15();
        List<List<Integer>> res = lc15.threeSum(array);
        for(List<Integer> l : res) {
            l.forEach(i -> System.out.print(i + " "));
            System.out.println();
        }

    }

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        if(nums == null || len < 3) return res;

        for(int i = 0; i < len; i++){
            if(nums[i] > 0){
               break;
            }

            if(i > 0 && nums[i] == nums[i-1]) continue;//去重

            int L = i + 1;
            int R = len - 1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];

                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[L],nums[R]));

                    while(L < R && nums[L] == nums[L+1]) L++;//去重
                    while(L < R && nums[R] == nums[R-1]) R--;//去重

                    L ++;
                    R--;

                }else if(sum < 0){
                    L++;
                }else if(sum > 0) {
                    R--;
                }
            }

        }

        return res;
    }
}
