package Hot100;

/**
 * 283. 移动零
 * 已解答
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * 进阶：你能尽量减少完成的操作次数吗？
 */

public class LC283 {

    /**
     * 快排
     */
    public void moveZeroes(int[] nums) {
        int j = 0;

        //直接把非0的赋值给前边
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] !=0) {
               nums[j++] = nums[i];
            }
        }
        //j之后的都赋值为0
        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    /**
     * 双指针
     * @param nums
     */
    public void moveZeroes2(int[] nums) {

        int current = 0;
        int next = current + 1;
        while (next < nums.length) {
            if (nums[current] == 0) {
                for (; next < nums.length; next++) {
                    if (nums[next] != 0) {
                        int temp = nums[next];
                        nums[next] = nums[current];
                        nums[current] = temp;
                        break;
                    }
                }
            } else {
                current ++;
                next = current + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] num = new int[] {0,1,0,3,12};
        LC283 lc283 = new LC283();
        lc283.moveZeroes(num);
        System.out.println(num);
    }
}
