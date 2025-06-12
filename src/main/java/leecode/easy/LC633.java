package leecode.easy;

public class LC633 {
    public static void main(String[] args) {

        LC633 lc633 = new LC633();

        System.out.println(lc633.judgeSquareSum(1000000));
    }

    public boolean judgeSquareSum(int c) {

        int h = (int) Math.sqrt(c);
        int l = 0;
        while(l <= h){
            int sum = l * l + h * h;
            if(sum == c){
                System.out.println("l = " + l + " h = " + h);
                return true;
            }else if(sum >c){
                h--;
            }else {
                l++;
            }
        }
        return false;
    }


}
