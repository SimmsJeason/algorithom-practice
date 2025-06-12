package WrittenExamination.meituan;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

        Main2 test = new Main2();

       // int [][] matrix = {{1,0,1}};

        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int [][] matrix = new int[m][n];

        for(int i = 0; i< m; i++){
            for(int j = 0; j< n; j++){
                matrix[i][j] = in.nextInt();
            }
        }
        test.solute(m,n,matrix);
    }

    public void solute(int m, int n, int [][] matrix){
        if(m == 1){
            for(int i = 0; i< n; i++){
                System.out.print(matrix[0][i] + " ");
            }
            return;
        }

        int end = m;
        while(end>= 0){
            if(end == 0){
                for(int i = 0; i < n; i++){
                    System.out.print(matrix[0][i] + " ");
                }
                break;
            }

            if(isSuccess(end, n, matrix)){
                end = (end + 1)/2;
            }else {
                for(int i = 0; i < end; i++){
                    for(int j = 0; j< n ;j++){
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
            }
        }
    }

    public boolean isSuccess(int m , int n, int [][] matrix){
        int mid = (m+1)/2;
        for(int i = 0; i < mid; i++){
            for(int j = 0; j< n ; j++){
                if(matrix[mid-i-1][j] != matrix[mid+i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
