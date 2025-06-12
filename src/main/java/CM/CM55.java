package CM;

public class CM55 {
    public int findString(String[] str, int n, String x) {
        // write code her
        int left = 0;
        int right = n-1;
        int mid = 0;

        while(left <= right){

            mid = (left + right)/2;

            if(str[mid] == ""){
                while(mid <= right){
                    if(str[mid] == ""){
                        mid ++;
                    }else {
                        break;
                    }
                }

                if(mid > right){
                    mid = (left + right)/2;

                    while(mid >= left){
                        if(str[mid] == ""){
                            mid --;
                        }else {
                            break;
                        }
                    }
                }

            }

            if(str[mid] == x){
                return mid;
            } else if(str[mid].compareTo(x) >0){
                right = mid - 1;
            }else {
                left = mid + 1;
            }

        }

        return  -1;
    }

    public int findString1(String[] str, int n, String x) {
        if(str==null||str.length==0) return -1;
        int start =0;
        int end=n-1;
        while(str[start]==""){
            start++;
            if(start==n) return -1;
        }//先找到左右两边都不是空格的端点
        while(str[end]==""){
            end--;
        }
        while(start<=end){
            int mid =(start+end)/2;
            while(str[mid]=="") mid--;
            if(str[mid].compareTo(x)==0) return mid;
            else if(str[mid].compareTo(x)>0){
                end =mid-1;
                while(str[end]=="") end--;
            }
            else {
                start=mid+1;
                while(str[start]=="") start++;
            }
        }
        return -1;
    }
}
