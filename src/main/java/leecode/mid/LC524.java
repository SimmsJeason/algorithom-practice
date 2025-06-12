package leecode.mid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LC524 {
    public static void main(String[] args) {
        LC524 lc524 = new LC524();
        List <String> strings = new ArrayList<String>(){{add("ale");add("apple");add("money");add("plea");}};
        String str = lc524.findLongestWord("abpcplea", strings);
        System.out.println(str);
    }

    public String findLongestWord(String s, List<String> d) {

        int maxLength = 0;
        String ans = "";

        Collections.sort(d, new Comparator<String>() {
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }else {
                    return o2.length() - o1.length();
                }
            }
        });

        for(String str: d){
            int len = str.length();
            //剪枝
            if(len <= maxLength){
                break;
            }

            int h1 = len -1;
            int h2 = s.length() -1;
            while (h1>= 0 && h2 >=0){
                while(h2 >=0 && s.charAt(h2) != str.charAt(h1)){
                    h2 --;
                }
                if(h2 >= 0){
                    h2--;
                    h1--;
                }
            }

            if(h1 < 0 && maxLength < str.length()){
                maxLength = str.length();
                ans = str;
            }
        }

        return ans;
    }
}
