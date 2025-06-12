package JZoffer;

import java.util.Arrays;

public class JZ45 {
    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length == 0){
            return false;
        }
        if(numbers.length == 1){
            return true;
        }

        boolean flag = false;

        for(int i = numbers.length -1; i>0; i--){
            for(int j = 1; j<= i; j++){
                if(numbers[j-1] > numbers[j]){
                    int tmp = numbers[j];
                    numbers[j] = numbers[j-1];
                    numbers[j-1] = tmp;
                    flag = true;
                }
            }

            if(!flag){
                break;
            }

            flag = false;
        }

        int zero = 0;//记录大小王的个数
        for(int i = 0; i< numbers.length-1; i++){
            if(numbers[i] == 0){
                zero++;
            }else {
                if(numbers[i+1] - numbers[i] == 1){
                    continue;
                }else if(numbers[i+1] - numbers[i] == 0){
                    return false;
                } else{
                    int space = numbers[i+1] - numbers[i] -1;//求间隔
                    zero -=space;
                    if(zero <0){
                        return false;
                    }
                }
            }

        }

        return true;
    }
}
