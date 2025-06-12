package CM;

public class CM56 {
    public int[] findElement(int[][] mat, int n, int m, int x) {
        // write code here
        int [] result = new int[2];

        for(int i = 0 ; i < n; i++){
           if(mat[i][0] <= x && mat[i][m-1]>=x){
               for(int j = 0; j<m; j++){
                   if(mat[i][j] == x){
                       result[0] = i;
                       result[1] = j;
                   }
               }
           }
        }
        return result;
    }
}
