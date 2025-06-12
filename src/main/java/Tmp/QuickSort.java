package Tmp;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int [] nums = {3,5,2,7,6,9};
        QuickSort quickSort = new QuickSort();
        quickSort.solve(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void solve (int [] nums ) {
        quickSort(nums, 0, nums.length-1);
    }

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



    private void swap ( int []  nums, int l, int h){
        int tmp = nums[l];
        nums[l] = nums[h];
        nums[h] = tmp;
    }
}
