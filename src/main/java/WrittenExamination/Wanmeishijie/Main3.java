package WrittenExamination.Wanmeishijie;

import java.util.ArrayList;
import java.util.List;

public class Main3 {
    public static void main(String[] args) {
       /* Scanner in  = new Scanner(System.in);
        String str = in.nextLine();*/
       String str = "I have an    apple";
        Main3 test  = new Main3();

        System.out.println(test.swapWords(str));
    }

    public String solve(String str){
        String [] words = str.split("_");
        List<String> wordL = new ArrayList<>();
        for(int i = 0 ; i <words.length; i++){
            if(words[i].length() != 0){
                wordL.add(words[i]);
            }
        }

        StringBuffer sb = new StringBuffer();

        for(int i = 0, j = 0; i < str.length(); i++){
            if(str.charAt(i) == '_'){
                sb.append("_");
            }else {
                if(i+1 <str.length() && str.charAt(i+1) == '_'|| i+1 == str.length()-1){
                    sb.append(reverse(wordL.get(j)));
                    j++;
                }
            }
        }
        return new String(sb);
    }

    public  String swapWords(String s) {
        if (s == null) {
            return null;
        }
        String ret = "";
        if (!s.endsWith(" ")) {
            s += " ";
        }
        char[] charArr = s.toCharArray();
        int begin = 0;

        int i = 0;
        while (i < charArr.length) {
            while (charArr[i] == ' ' && i < charArr.length) {
                i++;
            }
            begin = i; // 获取单词的第一个字母对应的位置
            while (charArr[i] != ' ') { // 找到单词后第一个空格对应的位置
                i++;
            }
            swapStr(charArr, begin, i - 1);
            ++i;//下一个单词开始位置
        }
        ret = new String(charArr);
        return ret;
    }

    public void swapStr(char [] chars, int start, int end){
        System.out.println("start = "+ start + " end = " + end + " len =" + chars.length);
        while(start < end){
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start ++;
            end --;
        }
    }

    private String reverse(String str){
        StringBuffer sb = new StringBuffer(str);
        String res = sb.reverse().toString();
        return res;
    }
}
