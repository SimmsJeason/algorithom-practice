package WrittenExamination;

import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int i = 0;
        int [] array = new int[n];
        while(i < n){
            array[i] = in.nextInt();
            i++;
        }
    }
}
