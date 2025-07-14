package TypicalAlgorithm.Sort.BubbleSort;

import TypicalAlgorithm.Sort.SortInt;

import java.util.Arrays;

/**
 * 从左到右不断交换相邻逆序的元素，在一轮的循环之后，可以让未排序的最大元素上浮到右侧。
 * 在一轮循环中，如果没有发生交换，那么说明数组已经是有序的，此时可以直接退出。
 */
public class BubbleSort extends SortInt {

    // 20250714
    public void sort2(int[] nums) {
        int n = nums.length;
        boolean isSorted = false;
        for (int i = n-1; i >=0 && !isSorted; i --) {
            isSorted = true;
            for (int j =0 ; j < i; j++) {
                if (less(nums[j+1], nums[j])) {
                    swap(nums, j, j+1);
                    isSorted = false;
                }
            }
        }
    }

    public void sort(int[] nums) {
        int n = nums.length;
        boolean isSorted = false;

        for(int i = n-1; i > 0 && !isSorted; i--) {
            isSorted = true; // 先假设这次冒泡是排好序的
            for (int j = 0; j < i ; j++) {
                if (less(nums[j+1], nums[j])) { // 后边的数比前边的小，就往后换
                    swap(nums, j, j+1);
                    isSorted = false; //一旦出现交换就说明有排序动作
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int [] nums = {3,4,2,9,6,7,1};
        bubbleSort.sort(nums);
        System.out.println(Arrays.toString(nums));
     }
}
