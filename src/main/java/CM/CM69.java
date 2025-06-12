package CM;

import java.util.Arrays;
import java.util.HashMap;

public class CM69 {
    public int getFrequency(String[] article, int n, String word) {
        // write code here
        HashMap<String, Integer> map = new HashMap<>();
        for(String str :article){
            if(map.containsKey(str)){
                map.put(str, map.get(str) +1);
            }else {
                map.put(str, 1);
            }
        }
        if(map.get(word) == null){
            return 0;
        }else {
            return map.get(word);
        }

    }
}
