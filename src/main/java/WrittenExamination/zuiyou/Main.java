package WrittenExamination.zuiyou;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Main test = new Main();
        String str = "220";
        test.solute(str);
    }

    public void solute(String str){
        char[]chars = str.toCharArray();
        int n = chars.length;
        Arrays.sort(chars);
        boolean [] visited = new boolean[n];
        List<String> res = new ArrayList<>();

        //for(int i = 0 ; i< n ;i++){
            backTracking(new StringBuffer(), res, chars, visited, n);
        //}

        Collections.sort(res, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for(String ss : res){
            System.out.println(ss + " ");
        }
    }

    public void backTracking(StringBuffer cur, List<String> res, char[] chars,boolean [] visited,  int size){

        if(cur.length() == size){
            res.add(new String(cur));
            return;
        }
        for(int i = 0; i < size; i ++){
            //有重复就要加上这一段
            if(i != 0 && chars[i] == chars[i-1] && !visited[i-1]){
                continue;
            }
            if(visited[i]){
                continue;
            }
            cur.append(chars[i]);
            visited[i] = true;
            backTracking(cur, res, chars, visited, size);

            visited[i] = false;
            cur.deleteCharAt(cur.length() -1);
        }
    }
}
