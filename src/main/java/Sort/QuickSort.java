package Sort;

import java.util.Arrays;

public class QuickSort extends SortInt{

    static  int  count = 0;
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int [] nums = {3,4,2,9,6,7,1};
        //int [] nums = {5,7,6,9};
        quickSort.sort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
        System.out.println(count);
    }

    //基于划分的
    public void sort(int[] nums, int l, int h) {
        if (h <= l)
            return;
        int j = partition(nums, l, h);
        sort(nums, l, j - 1);
        sort(nums, j + 1, h);
    }

    private int partition(int [] nums, int l, int h) {
        int i = l, j = h + 1;//为了 --j
        int v = nums[l];

        while (true) {
            while (less(nums[++i], v) && i != h) ;
            while (less(v, nums[--j]) && j != l) ;
            if (i >= j)
                break;
            swap(nums, i, j);
        }

        swap(nums, l, j);

        return j;
    }

    //挖坑，填坑法
    public void quickSort(int [] nums, int l, int h){
        if(h <= l) return;

        int i = l;
        int j = h;
        int val = nums[i];

        while(i < j){
            //在右边一直找找到小于中轴值的数
            while(i < j && nums[j] >= val){
                j --;
            }
            //找到了
            if(i < j){
                nums[i] = nums[j];
                i++;
            }

            //在左边一直找，找到大于中轴值的数
            while(i < j && nums[i] <= val){
                i ++;
            }

            //找到了
            if(i < j ){
                nums[j] = nums[i];
                j--;
            }

        }

        nums[i] = val;
        quickSort(nums, l, i-1);
        quickSort(nums, i+1, h);
    }

   /* private int partition2(int [] array, int l , int h){
        int i = l+1;
        int j = h;
        int v = array[l];

        while(i<j){
            *//**
             * 先从尾部找 大于 value的位置，再从头部找 小于 value的位置，最后 i == j的位置是
             * value要插入位置的 前 一个位置
             *
             * 先从头部找 小于 value的位置，再从尾部找 大于 value的位置，最后 i == j的位置是
             * value要插入位置的 后 一个位置
             *//*

            while(i < j && less(v, array[j]) ){
                j--;
            }

            while(i < j && less(array[i], v)){
                i++;
            }
            if(i >= j){
                break;
            }
            swap(array, l, j);
        }

        return j;
    }

    *//**
     * 快排思想的拓展应用
     * 已知一个数 ，求这个数在一个数组中排第几， 数组无序
     *//*

*//*    public  int position(int [] nums, int l, int h, int num){
        int i = l- 1;//为了后边的 ++ i
        int j = h + 1;//-- h
        while(true){
            while(less(nums[++i], num) && i != h);
            while(less(num, nums[--h]) && j != l);
            if(i >=j){
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }*//*

    public  int position(int [] nums, int l, int h, int num){
        int i = l;//为了后边的 ++ i
        int j = h;//-- h
        while(i < j){
            while(i < j && num <= nums[i]){
                j--;
            }

            while(i < j && num >= nums[i]){
                i++;
            }


            if(i >= j){
                break;
            }
            swap(nums, i, j);
        }

        return j;
    }*/
}
