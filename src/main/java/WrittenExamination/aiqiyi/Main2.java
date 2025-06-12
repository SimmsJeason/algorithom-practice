package WrittenExamination.aiqiyi;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        String [] strs = str.split(" ");
        int [] array = new int[strs.length];
        for(int i = 0; i< strs.length; i++){
            array[i] = Integer.valueOf(strs[i]);
        }

        Main2 test = new Main2();

        System.out.println(test.solute(array));
    }

    public int solute(int [] array){
        Arrays.sort(array);
        int mid = array.length /2;
        return array[mid];
    }
}
