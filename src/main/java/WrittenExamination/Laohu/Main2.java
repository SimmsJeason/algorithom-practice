package WrittenExamination.Laohu;

import java.util.Arrays;
import java.util.Comparator;

/**
 * N项目 数， W 启动资金 ， 最多可以做 K个项目
 *
 * 例：
 * 4 3 2
 * 5 4 1 2
 * 3 5 3 2
 *
 * 先做2号项目 后的资金加利润为 ： 3+3 = 6
 * 在做1号项目 后 资金 加利润 6+5 = 11
 *
 */
public class Main2 {
    public static void main(String[] args) {

        Main2 test = new Main2();
/*
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int W = in.nextInt();
        int K = in.nextInt();
        String tmp = in.nextLine();
        String costStr = in.nextLine();
        String profitStr = in.nextLine();
        String[] costArray = costStr.split(" ");
        String[] profitArray = profitStr.split(" ");
        Project [] projects = new Project[N];
        for(int i = 0 ; i < N; i++){
            int cost = Integer.valueOf(costArray[i]);
            int profit = Integer.valueOf(profitArray[i]);

            Project cur = new Project(cost, profit);
            projects[i] = cur;
        }
*/

        int N = 4;
        int W = 3;
        int K = 0;
        Project [] projects = new Project[N];
        int [] cost = {5,4,1,2};
        int [] profit = {3,5,3,2};
        for(int i = 0; i < N ;i++){
            Project cur = new Project(cost[i], profit[i]);
            projects[i] = cur;
        }

        System.out.println(test.solve(N,W,K,projects));
    }

    public int solve(int N, int W, int K ,Project[] projects){

        if(N == 0 || W== 0|| K == 0){
            return 0;
        }

        Arrays.sort(projects, new Comparator<Project>() {
            @Override
            public int compare(Project o1, Project o2) {
                return o1.cost - o2.cost;
            }
        });

        int money = W;

        for(int k = 0; k < K; k ++){
            int max = 0;

            for(int i = 0; i< N; i++){
                Project cur = projects[i];
                if(cur.cost <= money){
                    max = Math.max(max, cur.profit);
                }
            }

            money += max;
        }
       return money;
    }

}

class Project{
    public int cost;
    public int profit;

    public Project(int cost, int profit) {
        this.cost = cost;
        this.profit = profit;
    }

    public Project() {
    }
}
