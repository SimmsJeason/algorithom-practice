package CM;

public class CM38 {
    public int findKth(int k) {
        // write code here
        int count =0, result = 0;
        for(int i = 3;; i++){
            if(is(i)){
                count++;
            }
            if(count == k){
                result = i;
                break;
            }
        }
        return result;
    }

    public boolean is(int num){
        if(num == 3 || num == 5|| num ==7){
            return true;
        }

        if(num %3 == 0){
            return is(num/3);
        }

        if(num %5 == 0){
            return is(num / 5);
        }
        if(num % 7 == 0){
            return is(num /7);
        }
        return false;
    }
}
