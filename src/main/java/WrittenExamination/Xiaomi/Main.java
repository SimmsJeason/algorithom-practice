package WrittenExamination.Xiaomi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    int m;
    int n;
    int [][] directions = {{1,0},{-1,0}, {0,1},{0,-1}};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> stringList = new ArrayList<>();
        while (true){
            String str = in.nextLine();
            stringList.add(str);
            if(!str.contains(",")){
                break;
            }
        }

        //char [][] matrix = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String str = "ABCCEDC";
        Main test = new Main();
        System.out.println(test.solute(stringList, str));
    }

    public boolean solute(List<String> strings, String str){
        //处理
        n = strings.get(0).length();
        m = strings.size()-1;
        String [] [] matrix = new String[m][n];

        char[][] chars = new char[m][n];
        m = matrix.length;
        n = matrix[0].length;


        boolean [][] visited = new boolean[m][n];

        boolean flag = false;
        for(int i = 0 ; i< m ; i++){
            for(int j = 0; j < n; j++){
                //flag = flag || dfs(matrix, visited, i, j, chars, 0);
            }
            if(flag){
                return true;
            }
        }
        return flag;
    }

    public boolean dfs(char [][] matrix, boolean [][]visited, int r, int c, char [] chars, int cur){
        if( cur >= chars.length){
            return true;
        }


        if( visited[r][c] || matrix[r][c] != chars[cur]){
            return false;
        }


        boolean flag = false;
        for(int []direction: directions){
            int nextR = r + direction[0];
            int nextC = c + direction[1];
            if(nextR >=0 && nextR < m && nextC >= 0 && nextC < n){
                visited[r][c] = true;
                flag = flag || dfs(matrix, visited, nextR, nextC, chars, cur +1);

                visited[r][c] = false;
            }
        }
        return flag;
    }
}
