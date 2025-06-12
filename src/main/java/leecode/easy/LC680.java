package leecode.easy;

public class LC680 {
    public static void main(String[] args) {
        LC680 lc680 = new LC680();
        String str = "abc";

        System.out.println(lc680.validPalindrome(str));
    }

    public boolean validPalindrome(String s) {

        int l = 0;
        int h = s.length()-1;
        boolean res = false;
        //查找到不同的点
        while (l<= h){
            if(s.charAt(l) == s.charAt(h)){
                l ++;
                h--;
                continue;
            }else {
                break;
            }
        }

        //匹对结束
        if(l == h) {
            return true;
        }else {
            boolean tmp1 = true, tmp2 = true;

            //低位先走
            int l1 = l +1;
            int h1 = h;
            while(l1 <= h1){
                if(s.charAt(l1) == s.charAt(h1)){
                    l1 ++;
                    h1--;
                }else {
                    tmp1 = false;
                    break;
                }
            }

            l1 = l;
            h1 = h -1;
            while(l1 <= h1){
                if(s.charAt(l1) == s.charAt(h1)){
                    l1 ++;
                    h1 --;
                }else {
                    tmp2 = false;
                    break;
                }
            }

            res = res || tmp1 || tmp2;
        }

        return res;
    }

}
