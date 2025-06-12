package WrittenExamination.Jinshanyun;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //int n = 5;
        Main test = new Main();
        test.solve(n);
    }

    public void solve(int n){
        if(n <= 1){
            System.out.print(1);
            return;
        }

        System.out.println("1");

        for(int i = 1 ; i < n ;i++){

            int len = 1 + 2 * i;
            int mid = len /2;

            int [] array = new int[len];
            Arrays.fill(array,1);

              for(int j = 2; j <= mid;j++){
                array[j] = array[j-1]+array[j-2];
              }
              for(int j = mid +1; j < len -2; j++){
                  array[j] = array[mid-(j-mid)];
              }

              for(int num : array){
                  System.out.print(num + " ");
              }
            System.out.println();

        }

    }
}
