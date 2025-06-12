package WrittenExamination.qushikeji;

import java.util.*;

/**
 * 输入String "12464647"
 * 输入 N = 3
 * 求 去掉3个数字后的最小值
 * 结果为： 12444
 */
public class TheMinNum {
    public static void main(String[] args) {
        String str= "12734745756657";
        int n = 3;
        TheMinNum theMinNum = new TheMinNum();

        System.out.println(theMinNum.solute(str, n));
    }

    public String solute(String str, int n){
        char [] chars = str.toCharArray();
        Queue<Character> queue = new PriorityQueue<Character>((c1, c2)-> c2 -c1);

        ArrayList<Character> characters = new ArrayList<>();

        for(int i = 0; i < str.length() ;i++){
            queue.add(chars[i]);
        }

        for(int i = 0; i < n ; i++){
           characters.add(queue.poll());
        }

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i< chars.length; i++){
            if(characters.contains(chars[i])){
                characters.remove(characters.indexOf(chars[i]));
                continue;
            }
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
