package JZoffer;

public class JZ37 {
    public int GetNumberOfK(int [] array , int k) {
        int left = 0;
        int right = array.length-1;

        int set = -1;
        int count = 0;

        while (left <= right){
            int mid = (left + right)/2;
            int midVal = array[mid];

            if(k < midVal){
                right = mid - 1;
            }else if(k > midVal){
                left = mid + 1;
            }else{
                set = mid;
                break;
            }
        }

        if(set == -1){
            return 0;
        }

        //向左找
        for(int i = set-1; i>=0;i--){
            if(array[i] == k){
                count ++;
            }else {
                break;
            }
        }

        //向右找
        for(int i = set;i < array.length ;i++){
            if(array[i] == k){
                count ++;
            }else {
                break;
            }
        }

        return count;
    }
}
