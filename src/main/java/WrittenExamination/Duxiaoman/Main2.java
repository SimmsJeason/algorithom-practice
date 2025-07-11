package WrittenExamination.Duxiaoman;

import java.util.*;

public class Main2 {

    public static int least = Integer.MAX_VALUE;
    public static int[] dir1 = {-1,0,1,0};
    public static int[] dir2 = {0,1,0,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        for(int o = 0; o < cnt; o++) {
            least = Integer.MAX_VALUE;
            int row = sc.nextInt();
            int col = sc.nextInt();
            sc.nextLine();
            int[][] chsLeast = new int[row][col];
            for(int[] temp : chsLeast) {
                Arrays.fill(temp, Integer.MAX_VALUE);
            }
            char[][] chs = new char[row][col];
            for(int i = 0; i < row; i++) {
                chs[i] = sc.nextLine().toCharArray();

            }
            minUse(chs, chsLeast);
            if(least == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(least);
            }
        }
    }

    public static int minUse(char[][] chs, int[][] chsLeast) {
        int row = chs.length;
        int col = chs[0].length;
        boolean[][] visit = new boolean[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(chs[i][j] == '@') {
                    dfs(chs, visit, i, j, 0, chsLeast);
                    break;
                }
            }
        }
        return least;
    }

    public static void dfs(char[][] chs, boolean[][] visit, int i, int j, int timeUsed, int[][] chsLeast) {
        if(i < 0 || i >= chs.length || j < 0 || j >= chs[0].length) {
            least = Math.min(timeUsed, least);
            return;
        }

        if(visit[i][j] || chs[i][j] == '#') return;

        //之前被记录过，进行剪枝
        if(timeUsed >= chsLeast[i][j]) {
            return;
        } else {
            chsLeast[i][j] = timeUsed;
        }

        visit[i][j] = true;

        if(chs[i][j] == '*') timeUsed++;

        for(int a = 0; a < 4; a++) {
            dfs(chs, visit, i + dir1[a], j + dir2[a], timeUsed, chsLeast);
        }

        visit[i][j] = false;
    }

}
