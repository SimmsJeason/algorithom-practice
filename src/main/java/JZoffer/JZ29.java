package JZoffer;

import java.util.ArrayList;

public class JZ29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        if(k > input.length){
            return result;
        }

        quickSort(input, 0, input.length-1);
        for(int i =0; i<k; i++){
            result.add(input[i]);
        }
        return result;
    }

    public void quickSort(int[] array, int left, int right){
        if(left < right){
            int l = left;
            int r = right;
            int pivot = array[l];
            while (l < r){
                while (l<r && array[r] >= pivot){
                    r--;
                }

                if(l < r){
                    array[l] = array[r];
                    l++;
                }

                while (l < r && array[l] < pivot){
                    l++;
                }

                if(l<r){
                    array[r] = array[l];
                    r--;
                }

            }
            array[l] = pivot;
            quickSort(array, left, l-1);
            quickSort(array, l+1, right);
        }
    }
}
