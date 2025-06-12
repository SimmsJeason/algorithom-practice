package WrittenExamination.JingDong;

/**
 * [ S , -, -]
 * [#,  #, - ]
 * [K, -, -]
 *
 */
public class Main {
    int m ;
    int n ;
    int [][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    int res;

    public static void main(String[] args) {
        char[][] map = {{'S','-','-'},{'#','#','-'},{'K','-','-'}};
        Main test = new Main();
        System.out.println(test.solve(map));
    }

    public  boolean solve(char [][] map){
        m = map.length;
        n = map[0].length;
        boolean [][] visited = new boolean[m][n];
        int cnt = 0;
        int r = 0;
        int c = 0;

        //找到公主的位置
        for(int i = 0 ; i < m ;i++){
            for(int j = 0 ; j< n; j++){
                if(map[i][j] == 'S'){
                    r= i;
                    c = j;
                }
            }
        }

        cnt = dfs(map,r, c, visited);
        return cnt != 0;
    }

    public int dfs (char[] [] map, int r, int c, boolean[][] visited ){
        if( r >= m || r <0 || c >= n || c < 0 || map[r][c] == '#' ||visited[r][c]){
            return 0;
        }
        if(map[r][c] == 'K'){
            return 1;
        }

        for(int [] direction : directions){
            visited[r][c] = true;
            res += dfs(map, r+ direction[0], c + direction[1], visited);
            visited[r][c] = false;
        }

        return res;
    }
}
