package CM;

public class CM7 {
    public int[][] clearZero(int[][] mat, int n) {
        boolean [][] isZero = new boolean[n][n];
        for(int i =0; i<n; i++){
            for(int j = 0;j<n; j++){
                if(mat[i][j] == 0){
                    for(int k = 0; k<n; k++){
                        isZero[i][k] = true;
                        isZero[k][j] = true;
                    }
                }
            }
        }

        for(int i =0; i<n; i++){
            for(int j = 0;j<n; j++){
                if(isZero[i][j]){
                  mat[i][j] = 0;
                }
            }
        }

        return mat;
    }
}
