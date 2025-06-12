package CM;

import java.util.ArrayList;
import java.util.Stack;

public class CM16 {
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
        ArrayList<Integer> result = new ArrayList<>();

        if(numbers.length == 0){
            return result;
        }


        Stack<Integer> tmp = new Stack<>();
        Stack<Integer> help = new Stack<>();

        for (int i = 0; i< numbers .length; i++){
            tmp.push(numbers[i]);
        }


        while(tmp.size() != 0){

            int num = tmp.pop();

            if (help.size() == 0 || help.peek() <= num){
                help.push(num);
            }else {
                tmp.push(help.pop());
                tmp.push(num);//复原
            }
        }

        while(help.size() != 0){
            result.add(help.pop());
        }
        return result;
    }
}
