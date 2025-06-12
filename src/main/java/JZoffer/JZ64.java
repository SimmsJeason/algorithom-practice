package JZoffer;

import java.util.ArrayList;

public class JZ64 {

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {

        ArrayList<Integer> result = new ArrayList<>();
        if(num == null || num.length == 0||size == 0 || size > num.length){
            return result;
        }


        for(int i = 0; i+size <= num.length; i++){
            int max = Integer.MIN_VALUE;
            for(int j = i; j< i + size; j++){
                if(max < num[j]){
                    max = num[j];
                }
            }
            result.add(max);
        }

        return  result;
    }
}
