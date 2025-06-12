package Sort;

public class HeapSortInt {

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

    private void swap ( int [] nums , int i, int j){
        int tmp = nums[i];
        nums [i] = nums[j];
        nums[j] = tmp;
    }

    private boolean less (int [] nums , int i, int j){
        if(nums[i] < nums[j]){
            return true;
        }else {
            return false;
        }
    }

}
