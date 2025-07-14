package TypicalAlgorithm.Sort.MergeSort;

public class BottomUpMergeSort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int n = arr.length;
        int[] aux = new int[n]; // 辅助数组

        // 子数组大小从1开始，每次翻倍：1 → 2 → 4 → 8 → ...
        for (int sz = 1; sz < n; sz = sz + sz) {
            // 遍历所有需要合并的子数组对
            for (int low = 0; low < n - sz; low += sz + sz) {
                int mid = low + sz - 1; // 左子数组的末尾索引
                int high = Math.min(low + sz + sz - 1, n - 1); // 右子数组的末尾索引
                merge(arr, aux, low, mid, high);
            }
        }
    }

    // 合并逻辑与自顶向下版本相同
    private static void merge(int[] arr, int[] aux, int low, int mid, int high) {
        System.arraycopy(arr, low, aux, low, high - low + 1);

        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) arr[k] = aux[j++];
            else if (j > high) arr[k] = aux[i++];
            else if (aux[j] < aux[i]) arr[k] = aux[j++];
            else arr[k] = aux[i++];
        }
    }

    // 测试示例
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2, 7, 1, 6};
        sort(arr);
        System.out.println(java.util.Arrays.toString(arr)); // 输出：[1, 2, 3, 4, 5, 6, 7, 8]
    }
}
