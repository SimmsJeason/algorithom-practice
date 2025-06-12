package CM;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class CM17 {
    public ArrayList<Integer> asylum(int[][] ope) {
        // write code here

        ArrayList<Integer> input = new ArrayList<>();
        ArrayList<Integer> output = new ArrayList<>();

        for(int i = 0; i< ope.length; i++){

            if(ope[i][0] == 1){
               input.add(ope[i][1]);
            }else if(ope[i][0] == 2){

                if(ope[i][1] == 0){
                   for(int j = 0; j< input.size(); j++){
                       if(input.get(j) != 0){
                           output.add(input.get(j));
                           input.set(j, 0);
                           break;
                       }
                   }
                }else if(ope[i][1] == 1){
                   for(int j = 0; j< input.size(); j++){
                       if(input.get(j) > 0){
                           output.add(input.get(j));
                           input.set(j, 0);
                           break;
                       }
                   }
                }else if(ope[i][1] == -1){
                    for(int j = 0; j< input.size(); j++){
                        if(input.get(j) < 0){
                            output.add(input.get(j));
                            input.set(j, 0);
                            break;
                        }
                    }
                }
            }
        }

        return output;
    }
}
