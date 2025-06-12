package JZoffer;

public class JZ50 {
    public boolean duplicate(int numbers[],int length,int [] duplication) {

        if(numbers == null || numbers.length == 0){
            return false;
        }

        int[] times = new int[length];

        for(int i = 0; i<length; i++){
            times[numbers[i]] ++;
            if(times[numbers[i]] >=2){
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }
}
