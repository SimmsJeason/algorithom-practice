package CM;

import java.util.ArrayList;

public class CM14 {


    public ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {

        ArrayList<ArrayList<Integer>> setOfStack = new ArrayList<>();

        if(size == 0 || ope == null|| ope.length == 0 || ope[0].length == 9){
            return setOfStack;
        }

        for(int i = 0; i< ope.length; i++){
            if(ope[i][0] == 2){
                if(setOfStack.size() == 0 || setOfStack.get(0).size() == 0){
                    return setOfStack;
                }
                int last = setOfStack.size() - 1;
                //去掉尾元素
                setOfStack.get(last).remove(setOfStack.get(last).size()-1);
            }else if(ope[i][0] == 1){
                if(setOfStack.size() == 0 ||setOfStack.get(setOfStack.size() -1).size() == size){
                    ArrayList<Integer> increase = new ArrayList<>();
                    increase.add(ope[i][1]);
                    setOfStack.add(increase);
                }else {
                    setOfStack.get(setOfStack.size() -1).add(ope[i][1]);
                }
            }else {
                return setOfStack;
            }
        }

        return setOfStack;
    }


    public ArrayList<ArrayList<Integer>> setOfStacks2(int[][] ope, int size) {
        // write code here
        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> curArray=new ArrayList<Integer>(size);// 先创建出来
        list.add(curArray);
        for(int i=0;i<ope.length;i++){
            switch(ope[i][0]){
                //1:push
                case 1:
                    //当前数组未满
                    if(curArray.size()!=size){
                        curArray.add(ope[i][1]);
                    }
                    else{
                        curArray=new ArrayList<Integer>(size);
                        list.add(curArray);
                        curArray.add(ope[i][1]);
                    }
                    break;
                //2:pop
                case 2:
                    //当前数组不为空
                    if(curArray.size()!=0){
                        curArray.remove(curArray.size()-1);
                    }
                    else{
                        list.remove(list.size()-1);
                        curArray=list.get(list.size()-1);
                        curArray.remove(curArray.size()-1);
                    }
                    break;
            }
        }
        return list;
    }
}
