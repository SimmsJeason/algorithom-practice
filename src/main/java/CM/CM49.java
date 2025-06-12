package CM;

public class CM49 {
    int count = 0;
    public int nQueens(int n) {
        // write code here
        int [] array = new int[n];//用来表示皇后位置

        num(n, 0, array);
        return count;
    }

    public void num(int n ,int cur, int[] array){
        if(cur == n){
            count ++;
            return ;
        }

        for(int i = 0; i < n; i++){
            array[cur] = i;
            if(judge(cur, array)){
                num(n, cur +1, array);
            }
        }
    }

    public boolean judge(int n, int[] array){
        for(int i = 0; i< n; i++){
            if(array[i] == array[n] || Math.abs(i-n) == Math.abs(array[i] - array[n])){
                return false;
            }
        }
        return true;
    }

}
