package JZoffer;

import java.util.HashMap;
import java.util.Map;

public class JZ28 {
    public int MoreThanHalfNum_Solution(int [] array) {
        int num = 0;
        Map<Integer, Integer> time = new HashMap<>();
        for(Integer i: array){
            if(time.containsKey(i)){
                time.put(i, time.get(i) + 1);
            }else {
                time.put(i, 1);
            }
        }
       for(Integer i : time.keySet()){
           if(time.get(i) > array.length / 2){
               num = i;
           }
       }
       return num;
    }
}
