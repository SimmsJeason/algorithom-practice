package WrittenExamination.meituan;

import java.util.Scanner;

public class Main {
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
        //System.out.println(m+ " "+ n + " " + k+ " " + Arrays.toString(array));
/*        int m = 2;
        int n = 8;
        int k = 5;
        int [] array = {5 ,5 ,5 ,4 ,5 ,5 ,5 ,5};*/
        Main test = new Main();

        System.out.println(test.solute(m,n, k, array));
    }

    public int solute(int m, int n, int k, int [] array){
        int count = 0;
        if(array == null || array.length == 0){
            return 0;
        }

        if(m >= n){
            return 1;
        }

        int start = 0;
        int end = 0;

        for(int i = 0; i < n; i++){
        /*    if(i == 3){
                System.out.println("oooooo");
            }*/
            if(array[i]>=k){
                if(end -start == 0){
                    end++;
                    continue;
                } else if(end-start + 1 == m){
                    end++;
                    start++;
                    count ++;
                }else {
                    continue;
                }
            }else {
                end ++;
                if(end >= n){
                    break;
                }else {
                    start = end;
                }
            }
        }
        return count;
    }

}
