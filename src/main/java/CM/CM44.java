package CM;

import java.util.ArrayList;
import java.util.Arrays;

public class CM44 {

    public ArrayList<ArrayList<Integer>> getSubsets(int[] A, int n) {
        if(A==null||A.length==0)
            return new ArrayList<>();
        Arrays.sort(A);// 数组A从小到大排序
        return getSubsetsCore(A,n);
    }

    public ArrayList<ArrayList<Integer>> getSubsetsCore(int[] A,int n){
        ArrayList<ArrayList<Integer>> outter = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> inner;
        if(n==1){// 循环终止条件
            inner = new ArrayList<Integer>();
            inner.add(A[0]);
            outter.add(inner);
            return outter;
        }

        ArrayList<ArrayList<Integer>> tmp = getSubsetsCore(A, n-1);
        int i,j;
        for (i = 0; i < tmp.size(); i++) {// 1. 在sets(n-1)的所有子集前边插入当前元素A[n-1]。
            inner = new ArrayList<Integer>();
            inner.add(A[n-1]);
            for (j = 0; j < tmp.get(i).size(); j++) {
                inner.add(tmp.get(i).get(j));
            }
            outter.add(inner);
        }
        inner = new ArrayList<Integer>();
        inner.add(A[n-1]);
        outter.add(inner);// 2. A[n-1]单独作为一个子集[A[n-1]]。
        outter.addAll(tmp);// 3. sets(n-1)同时也应包含到sets(n)中。
        return outter;
    }
}
