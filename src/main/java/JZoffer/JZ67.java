package JZoffer;

public class JZ67 {
    public int cutRope(int target) {

        int max = 0;
        if(target == 1){
            return target;
        }

        for(int m =2; m < target; m++){
            int tmpMax = 1;
            int tmp = target / m;
            int remain = target %m;
            if(remain != 0){
                if(tmp >1){
                    for(int i = 1; i<= remain; i++){
                        tmpMax *= (tmp+1);
                    }

                    for(int i = 1; i<= m - remain; i++){
                        tmpMax *= tmp;
                    }
                }else {
                    tmpMax = m *(remain);
                }

            }else{
                for(int i =0; i<m; i++){
                    tmpMax *= tmp;
                }
            }

            if(max<tmpMax){
                max = tmpMax;
            }
        }

        return max;
    }
}
