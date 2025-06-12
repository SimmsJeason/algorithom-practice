package leecode.easy;

public class LC88 {
    public static void main(String[] args) {
        int [] nums1 = {1,3,5,0,0,0};
        int [] nums2 = {2,4,6};
        LC88 lc88 = new LC88();
        lc88.merge(nums1, 3, nums2, 3);
        for(int i : nums1){
            System.out.print(i + " ");
        }
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //为降低时间复杂度，采用从大到小插入的方法,尾插法的优势

        int l1 = m-1;
        int l2 = n-1;
        int merge = m + n -1;
        if(n == 0 )return;

        while(l1 >= 0 && l2 >= 0){
            if(nums1[l1] >= nums2[l2]){
                nums1[merge--] = nums1[l1--];
            }else {
                nums1[merge--] = nums2[l2--];
            }
        }

        if(l2 >=0){
            while(l2>= 0){
                nums1[merge--] = nums2[l2--];
            }
        }

        if(l1 >= 0){
            nums1[merge--] = nums1[l1--];
        }
    }
}
