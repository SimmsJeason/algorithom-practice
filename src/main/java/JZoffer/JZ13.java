package JZoffer;

public class JZ13 {
    public void reOrderArray(int [] array) {
        int [] tmp = new int[array.length];

        int j = 0;

        for(Integer i: array){
            if(i %2 ==1){
                tmp[j] = i;
                j++;
            }
        }

        for(int i = 0; i< array.length; i++){
            if(array[i] %2 == 0){
                tmp[j] = array[i];
                j++;
            }
        }

        for(int i  = 0; i< tmp.length; i++){
            array[i] = tmp[i];
        }
    }
}
