package CM;

public class CM42 {
    public boolean findMagicIndex(int[] A, int n) {
        // write code here
        int head = 0;
        int tail = n-1;

        while(head <= tail){
            int mid = (head + tail)/2;
            if(A[mid] > mid){
                tail = mid-1;
            }else if(A[mid] < mid){
                head = mid + 1;
            }else {
                return true;
            }
        }

        return false;
    }
}
