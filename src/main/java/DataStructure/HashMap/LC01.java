package DataStructure.HashMap;

import java.util.HashMap;

/**
 * 两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *  
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC01 {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> index4num = new HashMap<>();
        for(int i = 0; i< nums.length; i ++){
            if(index4num.containsKey(target - nums[i])){
                return new int[]{index4num.get(target - nums[i]), i};
            }
            index4num.put(nums[i], i);
        }
        return null;
    }
}