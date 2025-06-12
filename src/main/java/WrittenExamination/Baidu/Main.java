package WrittenExamination.Baidu;

import java.util.Arrays;

public class Main {
    int cnt = 0;
    public static void main(String[] args) {
        Main main = new Main();

  /*      Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        int [] ns = new int [T];
        int [] ms = new int[T];
        String [] qiwangS = new String[T];
        String [] restS = new String[T];

        for(int i = 0; i< T; i ++){

            ns[i] = in.nextInt();
            ms[i] = in.nextInt();
            in.nextLine();
            qiwangS[i] = in.nextLine();
            restS[i] = in.nextLine();

        }

        for(int i = 0; i < T; i++){
            main.solute(ns[i], ms[i], qiwangS[i], restS[i]);
        }*/

        int n = 3;
        int m = 6;
        int [] qiwang = {33,66,99};
        int [] rest = {3,6,9,30,60,90};

        main.solute2(qiwang, rest);

    }

    public void solute (int n, int m, String qiwangStr , String restStr){
        String [] qiwangStrA = qiwangStr.split(" ");
        String [] restStrA = restStr.split(" ");

        int [] qiwang = new int[qiwangStrA.length];
        int [] rest = new int[restStrA.length];
        for(int i = 0; i< qiwangStrA.length; i++){
            qiwang[i] = Integer.valueOf(qiwangStrA[i]);
        }

        for(int i = 0; i< restStrA.length; i++){
            rest[i] = Integer.valueOf(restStrA[i]);
        }

        Arrays.sort(rest);

        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = m-1; j>= 0; j--){
                if(qiwang[i] <= rest[j]){
                    count ++;
                }else {
                    break;
                }
            }
            System.out.print(count + " ");
        }
        System.out.println();
    }

    public void solute2(int [] expect, int [] rest){

        for(int i = 0; i < expect.length; i++){
            System.out.println(quickSort(rest,expect[i]));
        }

    }

    public int quickSort (int [] array, int aim){
        int l = 0;
        int h = array.length-1;

      return partition2(array, l, h ,aim);
    }

    private int partition(int [] array, int l , int h, int num){
        int i = l-1;
        int j = h +1;
        int v = num;

        while(true){
            while(less(array[++i], v) && i != h);
            while(less(v, array[--j]) && j != l);
            if(i >= j){
                break;
            }
            swap(array, i, j);
        }
        System.out.println(i + " " + j);
        swap(array, l, j);
        return j;
    }

    private int partition2(int [] array, int l , int h, int num){
        int i = l;
        int j = h;
        int v = num;

        while(i<j){
            /**
             * 先从尾部找 大于 value的位置，再从头部找 小于 value的位置，最后 i == j的位置是
             * value要插入位置的 前 一个位置
             *
             * 先从头部找 小于 value的位置，再从尾部找 大于 value的位置，最后 i == j的位置是
             * value要插入位置的 后 一个位置
             */

            while(i < j && less(v, array[j]) ){
                j--;
            }
            while(i < j && less(array[i], v)){
                i++;
            }
            if(i >= j){
                break;
            }
            swap(array, i, j);
        }

        return j;
    }

    private boolean less(int i, int j){

        return i < j;
    }

    private void swap ( int [] array , int i , int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
