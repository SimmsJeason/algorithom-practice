package WrittenExamination.Wanmeishijie;


import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String str = in.nextLine();

        Main2 test  = new Main2();

        System.out.println(test.solve(str));
    }
    public String solve (String str){
        StringBuilder sb = new StringBuilder();
        int [] visited = new int[26];

        //char[] chars = {'a','b','c','d','e'}
        for(int i = 0 ; i < str.length() ; i ++){
            char cur = str.charAt(i);
            visited[cur - 'a'] += 1;
        }

        Character aC = new Character('a');
        int aHash = aC.hashCode();
        for(int i = 0; i < 26; i ++){

            if(visited[i]==1){
                char cur = (char)(aHash + i);
                sb.append(cur);
            }
        }
        return sb.toString();
    }
}
