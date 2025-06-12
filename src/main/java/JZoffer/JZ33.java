package JZoffer;

public class JZ33 {
    public int GetUglyNumber_Solution(int index) {
        if (index < 7) {
            return index;
        }

        int[] res = new int[index];
        res[0] = 1;
        int t2 = 0, t3 = 0, t5 =0;//可以理解为步数，2，3，5是不同的步长
        for (int i = 1; i< index; i++){
            res[i] = Math.min(res[t2] * 2, Math.min(res[t3] * 3, res[t5] * 5));
            if(res[i] == res[t2] *2){
                t2 ++;
            }
            if(res[i] == res[t3] *3){
                t3 ++;
            }
            if(res[i] == res[t5] *5){
                t5 ++;
            }
        }

        return res[index-1];
    }
/*    public boolean isUgly(int num){
        if(num == 1){
            return true;
        }

        if(num % 2 ==0){
            return isUgly(num/2);
        }else if(num % 3 == 0){
            return isUgly(num/3);
        }else if(num % 5 == 0){
            return isUgly(num/5);
        }else {
            return false;
        }
    }*/
}
