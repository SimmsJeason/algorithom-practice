package Review;

import java.util.HashMap;

public class Array_287 extends ClassLoader{

    public int findDuplicate(int[] nums) {
        int l = 1; // 从 1 开始的
        int h = nums.length -1;

        HashMap<String, Integer> map = new HashMap<>();
        while(l <= h){
            int mid = l + (h-l) /2;
            int cnt = 0;

            for(int i = 0; i < nums.length; i++){
                if(nums[i] <= mid){
                    cnt ++;
                }
            }
            if(cnt <= mid){
                l = mid + 1;
            }else {
                h = mid - 1;
            }
        }


        return l;
    }
}
