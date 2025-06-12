package CM;

public class CM50 {

    //经典的有向无环图模型的DP问题
//选择某个起点使之有向无环图的最大路径长度
    public int getHeight(int[] w, int[] l, int[] h, int n) {
        boolean[][] graph = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(w[i]>w[j]&&l[i]>l[j])//使底部的箱子长宽大于上面的，若有箱子长宽小，则有到其的有向边
                    graph[i][j] = true;
            }
        }

        int[] dp = new int[n];
        int ans = 0;
        for(int i=0;i<n;i++){//选择起点
            int tmp = dfs(i,graph,h,dp);
            ans = Math.max(ans,tmp);
        }
        return ans;
    }

    //
    public int dfs(int bottom,boolean[][] graph,int[] h,int[] dp){
        if(dp[bottom] > 0) return dp[bottom];

        int n = graph.length;
        int top = 0;
        for(int i=0;i<n;i++){
            if(graph[bottom][i])
                top=Math.max(top, dfs(i,graph,h,dp));
        }
        return dp[bottom] = top+h[bottom];//缓存当前结点的最大路径长度
    }
}
