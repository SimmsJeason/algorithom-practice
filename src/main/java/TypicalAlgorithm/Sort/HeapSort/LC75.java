package TypicalAlgorithm.Sort.HeapSort;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC75 {



    /**
     *算法
     *
     * 初始化0的最右边界：p0 = 0。在整个算法执行过程中 nums[idx < p0] = 0.
     *
     * 初始化2的最左边界 ：p2 = n - 1。在整个算法执行过程中 nums[idx > p2] = 2.
     *
     * 初始化当前考虑的元素序号 ：curr = 0.
     *
     * While curr <= p2 :
     *
     * 若 nums[curr] = 0 ：交换第 curr个 和 第p0个 元素，并将指针都向右移。
     *
     * 若 nums[curr] = 2 ：交换第 curr个和第 p2个元素，并将 p2指针左移 。
     *
     * 若 nums[curr] = 1 ：将指针curr右移。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/sort-colors/solution/yan-se-fen-lei-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public void sortColors(int[] nums) {
      int p0 = 0, cur = 0, p2 = nums.length-1;
      while(cur <= p2){
          if(nums[cur] == 0){
              swap(nums, p0++, cur++);
          } else if(nums[cur] == 2){
              swap(nums, cur, p2--);
          }else {
              cur ++;
          }
      }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
