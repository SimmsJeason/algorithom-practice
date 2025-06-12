package CM;

public class CM72 {
    /**
     位的异或运算跟求'和'的结果一致：
     异或 1^1=0 1^0=1 0^0=0
     求和 1+1=0 1+0=1 0+0=0
     位的与运算跟求'进位‘的结果一致：
     位与 1&1=1 1&0=0 0&0=0
     进位 1+1=1 1+0=0 0+0=0
     */
    public int addAB(int A, int B) {
        // write code here
        int add, tem;
        while(B!=0){
            tem = (A & B)<<1;
            add = A ^ B;
            A = add;
            B = tem;
        }
        return A;
    }
}
