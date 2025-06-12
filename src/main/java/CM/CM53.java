package CM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class CM53 {
    public ArrayList<String> sortStrings(String[] str, int n) {
        // write code here
        ArrayList<String> result = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();//key是字母序的， value是单词

        for(int i = 0; i< str.length; i++){
            char[] chars = str[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(map.get(key) != null){
                String in = map.get(key);
                if(in.compareTo(str[i]) > 0){//字典序小的入
                    map.put(key, str[i]);
                }
            }else {
                map.put(key, str[i]);
            }
        }

      for(String s : map.values()){
          result.add(s);
      }

        Collections.sort(result);
        return result;
    }
}
