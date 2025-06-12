package CM;

import java.util.LinkedList;

public class CM52 {
    public int getResult(int n) {
        // write code here
        if(n <1){
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<>();

        //第一轮只放奇数
        for(int i = 1; i<= n; i++){
            if(i%2 != 0){
                list.add(i);
            }
        }

        int round = 3;
        while(list.size() > 1){
            int last = list.removeLast();
            list.addFirst(last);//最后一个前移
            int len = list.size();
            //每次删除，list长度都会变
            int k = 0;//记录删除的个数
            for(int j = 1; j<= len; j++){
                if(j % round !=1){
                    list.remove(j-1-k);
                    k++;
                }
            }
            round ++;
        }
        return list.pop();
    }
}
