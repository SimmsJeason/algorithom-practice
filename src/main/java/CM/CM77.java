package CM;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CM77 {

    public int getLongest(String[] str, int n) {
        if (str == null || str.length == 0) {
            return 0;
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        Map<String, Boolean> map = new HashMap<>();
        for (String key : str) {
            map.put(key,null);
        }
        for (String string : str) {
            if (canBuildWord(string, true, map)) {
                return string.length();
            }
        }
        return 0;
    }

    private boolean canBuildWord(String str, boolean isOriginal, Map<String, Boolean> map) {
        if (map.containsKey(str)&&!isOriginal) {
            return true;
        }
        for (int i = 1; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i);
            if (map.containsKey(left)&&canBuildWord(right, false, map)) {
                return true;
            }
        }
        return false;
    }
}