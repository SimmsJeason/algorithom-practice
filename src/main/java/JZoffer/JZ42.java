package JZoffer;

import java.util.ArrayList;

public class JZ42 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();

        int last = -1;
        for(int i = array.length-1; i>0; i--){
            if(array[i] > sum){
                continue;
            }else {
                last = i;
                break;
            }
        }

        for (int i = 0; i< array.length; i++){
            for(int j = last; j>i;j--){
                if(array[i] + array[j] == sum){
                    result.add(array[i]);
                    result.add(array[j]);
                    return result;
                }
            }
        }
        return result;
    }
}
