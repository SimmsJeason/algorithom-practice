package TypicalAlgorithm.Searching.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *  
 *
 * 提示：
 *
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步，可进可退。（引用自 百度百科 - 皇后 ）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC51 {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<>();
        List<List<Integer>> resInt = new ArrayList<>();
        int [] visited = new int[n+1];

        if(n == 0) return res;

        backTracking(resInt, new ArrayList<>(), n, 1, visited);
        replace(res, resInt, n);
        return res;
    }

    public void backTracking(List<List<Integer>> res , List<Integer> one, int n, int start,  int [] visited){
        if(start > n){
            res.add(new ArrayList<>(one));
            return;
        }

        for(int i = 1 ; i <= n; i++){
            if(check(visited, start, i)){
                visited[start] = i;
                one.add( i);
                backTracking(res, one, n, start +1, visited);
                visited[start] = 0;
                one.remove(one.size() -1);
            }
        }
    }

    public boolean check(int [] visited, int i, int j){
        for(int k = 1; k< i; k++){
            if(visited[k] == j || Math.abs(i- k) == Math.abs(j - visited[k])){
                return false;
            }
        }
        return true;
    }

    public void replace(List<List<String>> res, List<List<Integer>> resInt, int n ){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i< n; i ++){
            sb.append(".");
        }
        for(List<Integer> list : resInt){
            List<String> one = new ArrayList<>();
            for(int i : list){
               String str1 = new String(sb);
               StringBuffer str = new StringBuffer(str1);
               str.replace(i-1, i, "Q");
               one.add(str.toString());
            }
            res.add(one);
        }
    }
}
