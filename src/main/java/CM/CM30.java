package CM;

public class CM30 {
    public int exchangeOddEven(int x) {
        // write code here
        int odd = x & (0x55555555);//二进制： 1010101010101010101010101010101
        int even = x & (0xaaaaaaaa);//二进制  10101010101010101010101010101010
        return (odd << 1) + (even >>> 1);// 无符号右移，高位补0
    }
}
