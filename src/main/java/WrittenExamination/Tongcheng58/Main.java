package WrittenExamination.Tongcheng58;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Main test = new Main();
        String str = "1 5";
        System.out.println(test.calculate(str));
    }
    public int calculate (String input) {
        // write code here

        input = input.replaceAll(" ","");
        char[] chars = input.trim().toCharArray();
        int len = chars.length;


        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        int i = 0;
        while(i < len){
            if(chars[i] == ' ') {
                i++;
                continue;
            }
            char cur = chars[i];
            if(cur == '+' || cur == '-' || cur == '*' || cur == '/'){
                i++;
                while(i < len && chars[i] == ' ') {
                    i++;
                }
            }
            int num = 0;
            while( i < len && Character.isDigit(chars[i])){
                num = num *10 + chars[i] -'0';
                i++;
            }

            switch(cur) {
                case '-':
                    num = -num;
                    break;
                case '*':
                    num = stack.pop() * num;
                    break;
                case '/':
                    num = stack.pop() / num;
                    break;
                default:
                    break;
            }
            stack.push(num);
        }

        while(!stack.empty()){
            ans += stack.pop();
        }
            return ans;
    }


}
