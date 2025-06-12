package WrittenExamination.aiqiyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {

        //int [] array = {-1, 0, 1, 2, -1 ,-4};
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        String [] strs = str.split(" ");
        int [] array = new int[strs.length];
        for(int i = 0; i< strs.length; i++){
            array[i] = Integer.valueOf(strs[i]);
        }

        Main3 main3 = new Main3();

        main3.solute(array);
    }

    public void solute(int [] array) {

        boolean[] visited = new boolean[array.length];
        Arrays.sort(array);

        backTracking(array, 0, new ArrayList<>(), visited);

    }

    public void backTracking(int [] array, int start, List<Integer> cur, boolean[] visited){
        if(cur.size() == 3){
            int sum = 0;
            for(int i = 0; i < 3; i++){
                sum += cur.get(i);
            }

            if(sum == 0){
                for(int i = 0; i < 3; i ++){
                    System.out.print(cur.get(i) + " ");
                }
                System.out.println();
            }
        }

        for(int i = start; i < array.length; i++ ){
            if(i != 0 && array[i] == array[i-1] && !visited[i-1]){
                continue;
            }
            cur.add(array[i]);
            visited[i] = true;
            backTracking(array, i +1, cur, visited);

            cur.remove(cur.size() -1);
            visited[i] = false;
        }
    }
}
