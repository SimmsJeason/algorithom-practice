package CM;

public class CM54 {

    //画图限制条件就会一目了然，限制条件发生在：两段有序的线段，前一段全部大于后一段
//mid 和 x 分别在两个线段上
    public int findElement(int[] A, int n, int x) {
        // write code here
        int left = 0;
        int right = n-1;
        int mid = 0;
        //由于移位了，但移位之后，中间元素的左右两边必定有一边是升序的

        while(left<=right) {
            mid=(left+right)/2;
            if(A[mid]==x)
                return mid;
            if(A[mid]<x) {
                //A[mid]<A[left] 说明右边是有序的，且x>A[right]说明x在mid左边
                if(A[mid]<A[left]&&x>A[right]) right=mid-1;
                else left=mid+1;
            }
            else {
                //A[mid]>A[left]说明左边是有序的，且x<A[left]，说明x在mid右边
                if(A[mid]>A[left]&&x<A[left]) left=mid+1;
                else right=mid-1;
            }
        }
        return -1;
    }

    public int findElement1(int[] A, int n, int x) {
        // write code here
        int left = 0;
        int right = n-1;
        int mid = 0;
        while(left <= right){
            mid = (left + right)/2;
            if(A[mid] == x)return mid;

            if(A[mid] < x){
                if(A[mid] < A[left] && x > A[right]){
                    right = mid -1;
                }else {
                    left = mid + 1;
                }
            }else{
                if(A[mid] > A[left] && x < A[left]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
