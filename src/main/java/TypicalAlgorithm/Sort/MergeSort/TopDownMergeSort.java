package TypicalAlgorithm.Sort.MergeSort;

public class TopDownMergeSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int[] aux = new int[arr.length]; // 辅助数组，避免递归中重复分配内存
        sort(arr, aux, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int[] aux, int low, int high) {
        if (high <= low) return; // 基线条件：子数组长度为1时停止分解
        int mid = low + (high - low) / 2; // 计算中间索引
        sort(arr, aux, low, mid); // 递归排序左半部分
        sort(arr, aux, mid + 1, high); // 递归排序右半部分
        merge(arr, aux, low, mid, high); // 合并已排序的两部分
    }

    private static void merge(int[] arr, int[] aux, int low, int mid, int high) {
        // 复制原数组到辅助数组
        System.arraycopy(arr, low, aux, low, high - low + 1);

        int i = low; // 左半部分指针
        int j = mid + 1; // 右半部分指针
        for (int k = low; k <= high; k++) {
            if (i > mid) arr[k] = aux[j++]; // 左半部分用尽，取右半部分元素
            else if (j > high) arr[k] = aux[i++]; // 右半部分用尽，取左半部分元素
            else if (aux[j] < aux[i]) arr[k] = aux[j++]; // 右半部分当前元素更小
            else arr[k] = aux[i++]; // 左半部分当前元素更小（保证稳定性）
        }
    }

    // 测试示例
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2, 7, 1, 6};
        sort(arr);
        System.out.println(java.util.Arrays.toString(arr)); // 输出：[1, 2, 3, 4, 5, 6, 7, 8]
    }
}