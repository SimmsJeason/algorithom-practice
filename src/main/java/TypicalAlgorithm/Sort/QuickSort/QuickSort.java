package TypicalAlgorithm.Sort.QuickSort;

import TypicalAlgorithm.Sort.SortInt;

import java.util.Arrays;

/**
 * 快速排序的核心是分治法：将一个复杂的大问题分解为多个相似的小问题，解决小问题后，大问题的解自然得到。具体到排序中：
 * 分解：选择一个 “基准元素”（pivot），将数组分为两部分 —— 左部分元素均小于等于基准，右部分元素均大于等于基准（分区操作）；
 * 解决：递归地对左右两部分子数组执行快速排序；
 * 合并：由于子数组在排序过程中已原地处理，无需额外合并操作，整个数组自然有序。
 */
public class QuickSort extends SortInt {

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
        int v = nums[l]; // 基准值，将区间第一个作为基准值

        while (true) {
            while (less(nums[++i], v) && i != h) ; //小于基准值的跳过，保证左边的都小于基准值
            while (less(v, nums[--j]) && j != l) ; //大于基准值的跳过，保证右边的都大于基准值
            if (i >= j)
                break;
            swap(nums, i, j); //交换
        }

        swap(nums, l, j); //找到基准值正确的位置，然后交换

        return j; //返回基准值分隔区间的下边，即本次排序，基准值的位置是完全正确的，后续的排序不会影响到这个位置的值
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
