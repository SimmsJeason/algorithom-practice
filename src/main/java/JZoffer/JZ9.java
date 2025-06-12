package JZoffer;

public class JZ9 {
    public int JumpFloorII(int target) {

        /**
         * 　　f(n)=f(n-1)+f(n-2)+...+f(1)
         * 　　f(n-1)=f(n-2)+...f(1)
         * 　　得:f(n)=2*f(n-1)
         */
        if(target == 0){
            return 0;
        }else if(target == 1){
            return 1;
        }else {
            return 2* JumpFloorII(target -1);
        }
    }
}
