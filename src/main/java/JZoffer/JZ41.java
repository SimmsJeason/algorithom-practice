package JZoffer;

import java.util.ArrayList;

public class JZ41 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i = 1; i< sum; i++){
            ArrayList<Integer> queue = new ArrayList<>();
            int tmp = 0;
            for(int j = i; j< sum; j++){
                tmp +=j;
                if(tmp< sum){
                    queue.add(j);
                }else if(tmp == sum){
                    queue.add(j);
                    result.add(queue);
                    break;
                }else {
                    break;
                }
            }
        }

        return result;
    }
}
