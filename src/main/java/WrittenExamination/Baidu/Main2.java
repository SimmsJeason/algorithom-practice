package WrittenExamination.Baidu;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {

    }

    public void solute(boolean isQ, List<List<Integer>> queue, int from, int to){
        if(!isQ){
            List<Integer> fromList = queue.get(from);
            List<Integer> toList = queue.get(to);
            if(toList == null){
                toList = new ArrayList<>();
            }
            for(int i = 0; i< fromList.size(); i++){
                toList.add(fromList.get(i));
            }
        }else {

        }
    }
}
