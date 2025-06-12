package WrittenExamination.Liantong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
/*        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        String [] strs = str.split(" ");
        int [] array = new int[strs.length];

        for(int i = 0; i< strs.length; i++){
            array[i] = Integer.valueOf(strs[i]);
        }

        System.out.println(Arrays.toString(array));*/
        int [] tmp = {0,1,1,2,2};
        Main test = new Main();
        int [] res = test.solve(tmp);
        System.out.println(Arrays.toString(res));
    }

    public int[] solve(int [] array){
        Arrays.sort(array);
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i< array.length;i++ ){
          if(!res.contains(array[i])){
              res.add(array[i]);
          }
        }

        System.out.println(res);
        int [] resArray = new int[res.size()];
        for(int i = 0; i <res.size(); i++){
            resArray[i] = res.get(i);
        }
        return resArray;
    }
}
