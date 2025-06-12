package WrittenExamination.VipKid;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main test = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n == 0){
            return;
        }

        String [] strings = new String[n];
        String tmp = in.nextLine();

        for(int i = 0; i < n ;i++){
            strings[i] = in.nextLine();
        }

        int [][] input = new int[n][2];

        for(int i = 0; i < strings.length; i++){
            String [] cur = strings[i].split(" ");
            for(int j = 0 ; j < cur.length; j++){
                input[i][j] = Integer.valueOf(cur[j]);
            }
        }

        test.solve(input);
    }

    public void solve(int [] [] input){

        int [] nums = {1,2,3,4,5,6,7,8,9};

        for(int i = 0; i< input.length; i++){
            List<List<Integer>> res = new ArrayList<>();
            backTracking(input[i][0], input[i][1], new ArrayList<>(), res,nums, 0);

            System.out.print("[");
            for(int k = 0; k < res.size(); k++){
                List<Integer> one = res.get(k);
                System.out.print("[");
                for(int j = 0; j < one.size(); j++){
                    if(j != one.size() -1){
                        System.out.print(one.get(j) + ",");
                    }else {
                        System.out.print(one.get(j));
                    }

                }

                if(k != res.size()-1){
                    System.out.print("],");
                }else {
                    System.out.print("]");
                }

            }
            System.out.println("]");

        }
    }

    public void backTracking(int n, int sum, List<Integer> cur, List<List<Integer>> res, int [] nums, int start){

        if( n < 0 || sum < 0 ) {
            return;
        }

        if(n == 0 && sum == 0){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i = start; i < nums.length; i ++){
            cur.add(nums[i]);
            backTracking(n-1, sum - nums[i], cur, res, nums, i+1);
            cur.remove(cur.size() -1 );
        }
    }
}
