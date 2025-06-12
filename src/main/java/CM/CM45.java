package CM;

import java.util.ArrayList;
import java.util.Collections;

public class CM45 {
    public ArrayList<String> getPermutation(String A) {
        // write code here

        ArrayList<String> result = new ArrayList<>();
        if(A.length() == 0){
            return result;
        }

        char[] chars = A.toCharArray();

        perm(chars, 0, result);

        Collections.sort(result);
        Collections.reverse(result);
        return result;
    }

    public void perm(char[] chars, int cur, ArrayList<String> result){
        if(cur == chars.length-1){
            result.add(new String(chars));
            return;
        }

        for(int i = cur; i< chars.length; i++){
            swap(chars, i, cur);
            perm(chars, cur + 1, result);
            swap(chars, i,cur);
        }
    }

    public void swap(char[] array, int i, int j) {
        if(i != j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
