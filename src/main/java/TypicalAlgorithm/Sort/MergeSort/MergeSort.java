package TypicalAlgorithm.Sort.MergeSort;

/** 归并方法将数组中两个已经排序的部分归并成一个。
 *
 * 归并排序的过程可以概括为三个步骤：
 * 分解（Divide）：将待排序数组不断拆分为两个长度相等（或相差 1）的子数组，直到每个子数组只包含 1 个元素（此时可视为 “已排序”）。
 * 合并（Merge）：将两个已排序的子数组合并为一个更大的有序数组。
 * 递归（Recursion）：重复上述过程，直到所有子数组合并为原始数组的长度，此时数组完全有序
 */

import TypicalAlgorithm.Sort.SortInt;

public class MergeSort extends SortInt {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        mergeSort(arr);
        System.out.println(java.util.Arrays.toString(arr)); // 输出: [1, 2, 3, 4, 5, 6, 7, 8]
    }

    // 归并排序主方法
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // 基线条件：空数组或长度为1的数组无需排序
        }
        int[] temp = new int[arr.length]; // 创建临时数组
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    // 递归分解数组并排序
    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // 计算中间索引，避免整数溢出
            mergeSort(arr, temp, left, mid); // 递归排序左半部分
            mergeSort(arr, temp, mid + 1, right); // 递归排序右半部分
            merge(arr, temp, left, mid, right); // 合并已排序的两部分
        }
    }

    // 合并两个有序子数组
    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // 复制原数组到临时数组
        System.arraycopy(arr, left, temp, left, right - left + 1);

        int i = left; // 左子数组指针
        int j = mid + 1; // 右子数组指针
        int k = left; // 合并后数组的指针

        // 比较并合并元素
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        // 复制左子数组剩余元素
        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }

        // 右子数组剩余元素无需复制，因为它们已经在正确的位置
    }
}
