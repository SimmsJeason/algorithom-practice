package CM;

import java.util.Stack;

public class CM46 {
    public boolean chkParenthesis(String A, int n) {
        // write code here
        char[] chars = A.toCharArray();
        Stack<Character> p = new Stack<>();
        for(int i = 0; i< n ; i++){
            if(chars[i] == '('){
                p.push(chars[i]);
            }else {
                if(chars[i] == ')' && !p.empty()){
                    p.pop();
                }else if(chars[i] == ')' && p.empty()){
                    return false;
                }

            }
        }

        if(p.empty()){
            return true;
        }else {
            return false;
        }
    }
}
