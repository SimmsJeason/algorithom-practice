package WrittenExamination.Tongcheng58;

import java.util.ArrayList;

public class Main3 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayA = new ArrayList<Integer>(){{add(-5);add(0);add(6);add(8);add(9);add(10);}};
        ArrayList<Integer> arrayB = new ArrayList<Integer>(){{add(0);add(8);add(9);add(11);add(15);}};
        Main3 test = new Main3();
        ArrayList<Integer> res = test.mergerArrays(arrayA, arrayB);
        for(Integer i:res){
            System.out.print(i + " ");
        }
    }
    public ArrayList<Integer> mergerArrays (ArrayList<Integer> arrayA, ArrayList<Integer> arrayB) {
        // write code here
        ArrayList<Integer > res = new ArrayList<>();
        int lenA = arrayA.size();
        int lenB = arrayB.size();
        if( lenA == 0 || lenB == 0){
            return res;
        }
        int l = 0;
        int r = 0;
        for(; l < lenA && r < lenB; ){
            if(arrayA.get(l) == arrayB.get(r)){
                res.add(arrayA.get(l));
                l++;
                r++;
            }else if(arrayA.get(l) < arrayB.get(r)){
                l++;
            }else {
                r++;
            }
        }
        return res;
    }
}
