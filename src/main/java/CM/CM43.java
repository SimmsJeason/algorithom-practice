package CM;

public class CM43 {
    public boolean findMagicIndex(int[] A, int n) {
        // write code here
        int head = 0;
        int tail = n-1;

        return check(A, head, tail);
    }

    public boolean check(int [] A , int left, int right){
        if(left > right){
            return false;
        }

        int mid = (left + right) /2;
        int start = mid ;
        int end = mid ;

        while(mid != 0 && A[mid] == A[start-1]){
            start--;
        }

        while(mid != A.length-1 && A[mid] == A[end+1]){
            end++;
        }

        if(start <= A[mid] && A[mid] <= end && start != end){
            return true;
        }

        return check(A, left, start-1) || check(A, end + 1, right);
    }

}
