package CM;

public class CM65 {
    public int getFactorSuffixZero(int n) {
        // write code here
        /**
         *
         * 1、把n! 分解成若干个素数相乘，只有 2*5 才可能产生尾随零，而2 的数量多于5，所以问题转化为计算有多少个5.
         *
         * 2、先数一数1到n之间有几个5的倍数（数量为n/5），然后数有几个25的倍数（数量为n/25），依次类推。
         */
        int count = count(n, 5);

        return count;
    }

    public int count ( int n , int five){

        if(n < five){
            return 0;
        }

        int tmp = n/five;

        return tmp + count(n, five*5);
    }
}
