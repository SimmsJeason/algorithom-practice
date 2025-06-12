package WrittenExamination.Laohu;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Main test = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String tmp = in.nextLine();
        String str = in.nextLine();
        String [] strings = str.split(" ");
        int [] array = new int[strings.length];

        for(int i = 0; i < strings.length; i ++){
            array[i] = Integer.valueOf(strings[i]);
        }
        //int [] array = {1,2,3,4,5,6};

        int [] res = test.solve(array);
        for(int i = 0; i< res.length; i++){
            System.out.print(res[i] + " ");
        }
    }
    public int [] solve(int [] array){
        Arrays.sort(array);
        int len = array.length;
        for(int i = 1; i < len-1; i += 2){
            int tmp = array[i+1];
            array[i+1] = array [i];
            array[i] = tmp;
        }

        return array;
    }
}
