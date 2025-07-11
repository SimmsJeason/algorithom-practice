package JZoffer;

public class JZ65 {
    /*public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix.length == 0 || str.length == 0 || matrix.length != rows * cols){
            return false;
        }



        for(int i = 0; i< rows; i++){
            for(int j =0; j<cols; j++){
                if(matrix[i*cols + j] == str[0]&& j == 3){
                    boolean[] flag = new boolean[matrix.length];
                    if(check(matrix, i, j, str, 0, rows, cols, flag)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    //i, j 索引的横纵坐标   k 为str里的第几个字符
    public boolean check(char[] matrix, int i, int j, char[] str, int k, int row, int cols, boolean[] flag){
        if(k == str.length){
            return true;
        }else {
            int aid = i*cols + j;

            boolean result = false;

            if(matrix[aid] == str[k] && flag[aid] == false){
                flag[aid] = true;
                k++;
                result = check(matrix, i, j, str, k, row, cols, flag);
            }else {
                if(j - 1 >= 0 && matrix[aid -1] == str[k] && flag[aid-1] == false){
                    result =  check(matrix, i, j-1, str, k, row, cols, flag);
                }
                if(j+1 < cols && matrix[aid +1] == str[k]&& flag[aid+1] == false){
                    result = check(matrix, i, j+1, str, k, row, cols, flag);
                }

                if(i-1>= 0 && matrix[aid-cols] == str[k]&& flag[aid-cols] == false){
                    result = check(matrix, i-1, j, str, k, row, cols, flag);
                }

                if(i+1< row && matrix[aid+cols] == str[k]&& flag[aid+cols] == false){
                    result = check(matrix, i+1, j, str, k, row, cols, flag);
                }
            }
            return result;
        }
    }*/

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        //标志位，初始化为false
        boolean[] flag = new boolean[matrix.length];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                //循环遍历二维数组，找到起点等于str第一个元素的值，再递归判断四周是否有符合条件的----回溯法
                if(judge(matrix,i,j,rows,cols,flag,str,0)){
                    return true;
                }
            }
        }
        return false;
    }

    //judge(初始矩阵，索引行坐标i，索引纵坐标j，矩阵行数，矩阵列数，待判断的字符串，字符串索引初始为0即先判断字符串的第一位)
    private boolean judge(char[] matrix,int i,int j,int rows,int cols,boolean[] flag,char[] str,int k){
        //先根据i和j计算匹配的第一个元素转为一维数组的位置
        int index = i*cols+j;
        //递归终止条件
        if(i<0 || j<0 || i>=rows || j>=cols || matrix[index] != str[k] || flag[index] == true)
            return false;
        //若k已经到达str末尾了，说明之前的都已经匹配成功了，直接返回true即可
        if(k == str.length-1)
            return true;
        //要走的第一个位置置为true，表示已经走过了
        flag[index] = true;

        //回溯，递归寻找，每次找到了就给k加一，找不到，还原
        if(judge(matrix,i-1,j,rows,cols,flag,str,k+1) ||
                judge(matrix,i+1,j,rows,cols,flag,str,k+1) ||
                judge(matrix,i,j-1,rows,cols,flag,str,k+1) ||
                judge(matrix,i,j+1,rows,cols,flag,str,k+1)  )
        {
            return true;
        }
        //走到这，说明这一条路不通，还原，再试其他的路径
        flag[index] = false;
        return false;
    }

}
