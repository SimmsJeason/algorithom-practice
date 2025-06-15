package JZoffer;

public class JZ6 {

    public int minNumberInRotateArray(int [] array) {

        if(array.length == 0){
            return 0;
        }else if (array.length == 1) {
            return array[0];
        }else if(array.length == 2) {
           return array[1];
        }else {
                int min = 0;
                for(int i = 0; i< array.length-2; i++){
                    if(array[i] > array[i+1]){
                        min = array[i+1];
                        break;
                    }
                }
                return min;
            }
    }
}
