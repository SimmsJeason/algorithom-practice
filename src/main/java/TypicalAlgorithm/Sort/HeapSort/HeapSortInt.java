package TypicalAlgorithm.Sort.HeapSort;

import TypicalAlgorithm.Sort.SortInt;

public class HeapSortInt extends SortInt {

    public void sort(int [] nums){
        int N = nums.length - 1;

        //构筑大顶堆
        for (int k = N / 2; k >= 1; k--)
            sink(nums, k, N);

        //每次把最大的数放到后边
        while (N > 1) {
            swap(nums, 1, N--);
            sink(nums, 1, N);
        }
    }

    // 下沉
    private void sink (int [] nums , int k, int N){

        while(2 * k <= N){
            int j = k *2;//左孩子节点

            //求左右孩子中 较大孩子的节点
            if(j < N && less(nums, j, j + 1)){
                j++;
            }

            //如果当前 k 位置的数比 较大孩子还要大，则不用下沉
            if (!less(nums, k, j))
                break;

            //交换下沉
            swap(nums, k, j);
            k = j;
        }

    }

    //上浮
    private void swim(int[] nums, int k) {
        while (k > 1 && less(nums, k / 2, k)) {
            swap(nums, k / 2, k);
            k = k / 2;
        }
    }
}
