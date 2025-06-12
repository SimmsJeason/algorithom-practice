package JZoffer;

import java.util.ArrayList;
import java.util.Arrays;

public class JZ21 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {

        if(popA.length == 0){
            return false;
        }

        ArrayList<Integer> pushL = new ArrayList<Integer>();

        for(int i = 0; i < pushA.length; i++){
            pushL.add(pushA[i]);
        }

        for(int i = 0; i< popA.length; i++){
            if(!pushL.contains(popA[i])){
                return false;
            }
        }

        int [] sort = new int[pushA.length];
        for(int i = 0; i< pushA.length; i++){
            sort[i] = pushL.indexOf(popA[i]);//拿到出栈队列 在 入栈队列 的下标
        }


        int upStart = -100;//记录升序的起始位置
        for(int i = 0; i< sort.length-1; i++){
            if(sort[i] < sort[i+1]){
                if(i != upStart + 1){
                    upStart = i;
                }
            }
        }

        //出现了升序位置，并且在入栈队列中，升序位置之前对应的元素要在升序位置元素的后边，就是不满足条件的
        if(upStart - 1 >=0 && sort[upStart-1] > sort[upStart]){
            return false;
        }
        return true;
    }
}
