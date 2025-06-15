package typicalAlgorithom.Sort;

public class HeapSort<T extends Comparable<T>> extends Sort<T> {
    /**
     * 数组第 0 个位置不能有元素
     */
    @Override
    public void sort(T[] nums) {
        int N = nums.length - 1;
        for (int k = N / 2; k >= 1; k--)
            sink(nums, k, N);

        while (N > 1) {
            swap(nums, 1, N--);
            sink(nums, 1, N);
        }
    }

    //对 k 位置的数进行下沉
    private void sink(T[] nums, int k, int N) {

        while (2 * k <= N) {
            int j = 2 * k;// k 的左孩子节点

            //找较大值
            if (j < N && less(nums, j, j + 1))
                j++;
            //如果当前 k 位置的数比 找到的下沉位置小，则不用下沉
            if (!less(nums, k, j))
                break;
            //交换下沉
            swap(nums, k, j);
            k = j;
        }
    }

    private boolean less(T[] nums, int i, int j) {
        return nums[i].compareTo(nums[j]) < 0;
    }
}
