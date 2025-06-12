package JZoffer;

public class JZ49 {
    public int StrToInt(String str) {

        boolean isFu = false;

        if(str == null || str.length() == 0){
            return 0;
        }

        if(str.charAt(0)  == '+'){
            str = str.substring(1);
        }else if(str.charAt(0)  == '-'){
            str = str.substring(1);
            isFu = true;
        }else if(str.charAt(0) < 48 || str.charAt(0)>57){
            return 0;
        }

        int k = 1;
        int result = 0;
        for(int i = str.length()-1; i>=0; i--){
            if(str.charAt(i) >= 65 && str.charAt(i)<= 122){
                return 0;
            }else {
                result +=(str.charAt(i)-48) *k;
                k *= 10;
            }
        }

        if(isFu){
            result = 0 - result;
        }
        return result;
    }


    public int StrToInt2(String str) {
        if (str == null)
            return 0;
        int result = 0;
        boolean negative = false;//是否负数
        int i = 0, len = str.length();
        /**
         * limit 默认初始化为 负的 最大正整数 ，假如字符串表示的是正数
         * 那么result(在返回之前一直是负数形式)就必须和这个最大正数的负数来比较，
         * 判断是否溢出
         */
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;

        if (len > 0) {
            char firstChar = str.charAt(0);//首先看第一位
            if (firstChar < '0') { // Possible leading "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;//在负号的情况下，判断溢出的值就变成了 整数的 最小负数了
                } else if (firstChar != '+')//第一位不是数字和-只能是+
                    return 0;
                if (len == 1) // Cannot have lone "+" or "-"
                    return 0;
                i++;
            }

            multmin = limit / 10;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = str.charAt(i++)-'0';//char转int
                if (digit < 0 || digit > 9)//0到9以外的数字
                    return 0;

                //判断溢出
                if (result < multmin) {
                    return 0;
                }
                result *= 10;
                if (result < limit + digit) {
                    return 0;
                }

                result -= digit;
            }
        } else {
            return 0;
        }

        //如果是正数就返回-result（result一直是负数）
        return negative ? result : -result;
    }
}
