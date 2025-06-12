package dailyPractice.day0611.Leecode;


import java.util.ArrayList;
import java.util.Stack;

public class LC2 {
    public int evalRPN (String[] tokens) {
        // write code here
        if(tokens == null || tokens.length == 0){
            return 0;
        }

        ArrayList<String> sign = new ArrayList<String>(){{
            add("+");
            add("-");
            add("*");
            add("/");
        }};
        Stack<String> stack = new Stack<>();
        for(String ele : tokens){
            if(!sign.contains(ele)){
                stack.push(ele);
            }else {
                int res = 0;
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                if(ele.equals("+")){
                    res = num1 + num2;
                }else if(ele.equals("-")){
                    res = num1 - num2;
                }else if(ele.equals("*")){
                    res = num1 * num2;
                }else if(ele.equals("/")){
                    res = num1 /num2;
                }else {
                    res = 0;
                }
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
