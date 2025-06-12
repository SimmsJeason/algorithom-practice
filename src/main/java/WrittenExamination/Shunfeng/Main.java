package WrittenExamination.Shunfeng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 一个递增序列 {a1, a2 , ... ,an};
 * 从{a2, ... , an-1}删除一个元素，求最大间隔数的最小值
 * 间隔数 num =  a(n) - a(n-1)
 * 例{1,2,3,7,8}
 * 删除2 {1,3,7,8} 最大间隔数 4
 * 删除3 {1,2,7,8} 最大间隔数 5
 * 删除7 {1,2,3,8} 最大间隔数 5
 *
 * 所以结果为： 4
 */
public class Main {
    public static void main(String[] args) {
        Main test = new Main();
        int [] array = {1,2,3,7,8};
        System.out.println(test.findMaxInterval(array));
    }


    public int solve(int [] array){
        int n = array.length;

        int minMax = Integer.MAX_VALUE;

        for(int i = 1; i < n-1; i++){
            int max = 0;
            for( int j = 0; j<n-1; j++){
                int res = 0;
                if(j == i){
                    continue;
                } else if(j == i-1){
                    res = array[j+2] - array[j];
                }else {
                    res = array[j+1] - array[j];
                }
               max = Math.max(max, res);

            }
            minMax = Math.min(minMax, max);
        }

        return minMax;
    }

    static int findMaxInterval(int[] arr) {
        if (arr.length==1||arr.length==2){
            return 0;
        }
        int[] db=new int[arr.length];
        for (int i=1;i<arr.length;i++){
            db[i]=arr[i]-arr[i-1];
        }
//        相邻两数之和最小
        int min=Integer.MAX_VALUE;

        for (int i=1;i<arr.length-1;i++){
            List<Integer> list=new ArrayList<>();
            for (int j=1;j<i;j++){
                list.add(db[j]);
            }

            list.add(db[i]+db[i+1]);
            for (int j=i+2;j<arr.length;j++){
                list.add(db[j]);
            }

            Collections.sort(list);
            min=Math.min(min,list.get(list.size()-1));

        }
        return min;

    }

}
