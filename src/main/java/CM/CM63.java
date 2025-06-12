package CM;

public class CM63 {
    public int getMax(int a, int b) {
        // write code here

        /**
         * 有符号”右移位操作符（>>）则按照操作符右侧指定的位数将操作符左边的操作数向右移。
         * “有符号”右移位操作符使用“符号扩展”；
         * 若符号位正，则在高位插入0；若符号位负。则在高位插入1
         */
        b = a-b;//此时b>>31为1则b小于0即a<b,若b>>31为0 则a>b
        a -= b&(b>>31); //若a<b a=a-(a-b),若a>b a=a-0
        return a;
    }
}
