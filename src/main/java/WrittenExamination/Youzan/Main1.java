package WrittenExamination.Youzan;

import java.util.ArrayList;
import java.util.List;

public class Main1 {

    public static void main(String[] args) {
        Main1 test = new Main1();

        ArrayList<Integer> digits = new ArrayList<Integer>(){{add(8);add(6);add(7);add(1);add(0);}};
        System.out.println(test.largestMultipleOfThree(digits));
    }

    public String largestMultipleOfThree (ArrayList<Integer> digits) {
        // write code here
        List<List<Integer>> res = new ArrayList<>();

        boolean [] visited = new boolean[digits.size()];
        for(int i = digits.size(); i >=1 ; i --){
            all(res, new ArrayList<>(), digits, visited,  i);
        }
        int max = Integer.MIN_VALUE;
        for(List<Integer> cur : res){
            int tmp = buildNum(cur);
            max = Math.max(tmp, max);
        }

        if(max == Integer.MIN_VALUE){
            return "";
        }else {
            return Integer.toString(max);
        }

    }

    private void all(List<List<Integer>> res, List<Integer> cur, List<Integer> digits, boolean[] visited, int size){
        if(cur.size() == size){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i = 0; i < digits.size(); i ++){
            if(visited[i]){
                continue;
            }
            cur.add(digits.get(i));
            visited[i] = true;
            all(res, cur, digits, visited, size);
            cur.remove(cur.size() -1);
            visited[i] = false;
        }
    }

    private Integer buildNum ( List<Integer> nums){
        if(nums.get(0) == 0){
            return Integer.MIN_VALUE;
        }
        int res = 0;
        for(int i = 0; i < nums.size(); i++){
            res = res * 10 + nums.get(i);
        }
        if(res %3 == 0){
            return res;
        }else {
            return Integer.MIN_VALUE;
        }
    }


}
