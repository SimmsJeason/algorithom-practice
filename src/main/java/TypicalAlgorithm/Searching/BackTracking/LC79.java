package TypicalAlgorithm.Searching.BackTracking;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *  
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LC79 {
    private int m,n;
    private int [][] direction = {{1,0},{-1,0}, {0,1},{0,-1}};

    public boolean exist(char[][] board, String word) {

        if(board == null || board.length == 0) return false;
        if(word == null || word.length() == 0) return true;

        m = board.length;
        n = board[0].length;

       boolean [][] visited = new boolean[m][n];

        for(int r = 0; r< m; r++){
            for(int c =0; c< n; c++){
                //boolean [][] visited = new boolean[m][n];
                if(check(board, r,c,word,0,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(final char[][] board, int r, int c, final String word, int index, boolean[][] visited){
        if(index == word.length()) return true;

        if(r<0 || r >= m || c <0 || c>=n
                || board[r][c] != word.charAt(index) || visited[r][c]) return false;


        visited[r][c] = true;

        for(int [] d : direction){
            if(check(board, r+ d[0], c + d[1], word, index + 1, visited)) {
                return true;
            }
        }
        visited[r][c] = false;//还原

        return false;
    }
}
