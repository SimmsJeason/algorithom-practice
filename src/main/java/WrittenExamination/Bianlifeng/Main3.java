package WrittenExamination.Bianlifeng;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String tmp = in.nextLine();
        String arrayS = in.nextLine();
        String [] strs = arrayS.split(",");
        int [] array = new int[strs.length];

        for(int i = 0; i < strs.length; i++){
            array[i] = Integer.valueOf(strs[i]);
        }
        /*int n = 5;
        int [] array = {1,2,5};*/
        Main3 test = new Main3();
        int ans= test.solve(n,array);
        System.out.println(ans);
    }

    public int solve(int amount, int[] coins) {
        if (coins == null) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
   /* public int solve(int n, int [] array){
        if(array == null || array.length ==0 || n == 0){
            return 0;
        }

        List<List<Integer>>res = new ArrayList<>();
        backTracking(n, array, new ArrayList<>(), res);
        int ans = 0;

        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.size() - o2.size();
            }
        });

        for(int i = 0; i < res.size() -1; i++){
            List<Integer> l1 = res.get(i);
            List<Integer> l2 = res.get(i+1);
            if(l1.size() != l2.size()){
                ans ++;
            }else {
                for(int j = 0 ; j < l1.size(); j++){
                    if(l1.get(j) == l2.get(j)){
                        continue;
                    }else {
                        System.out.println("*******");
                        ans ++;
                        break;
                    }
                }
            }
        }

        return ++ans;
    }

    public void backTracking(int n, int [] array, List<Integer> cur, List<List<Integer>> res){
        if(n < 0){
            return;
        }

        //if(n == 0 && !length.contains(cur.size())){
        if(n == 0 ){
            Collections.sort(cur);
            res.add(new ArrayList<>(cur));
        *//*    for(int in: cur){
                System.out.print( in + " ");
            }
*//*
            return;
        }

        for(int i = 0; i < array.length; i++){
            cur.add(array[i]);
            backTracking(n-array[i], array, cur, res);
            cur.remove(cur.size()-1);
        }
    }*/
}
