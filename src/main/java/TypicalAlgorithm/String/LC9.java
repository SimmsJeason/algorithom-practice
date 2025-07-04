package TypicalAlgorithm.String;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LC9 {
    //将整数分成左右两部分，右边那部分需要转置，然后判断这两部分是否相等。

    public boolean isPalindrome(int x) {

        if(x == 0) return true;

        //负数和整十数一定不是回文数
        if(x < 0 || x %10 == 0) return false;

        int right = 0;
        while (x > right){
            right  = x % 10 + right * 10;
            x = x/10;
        }

        //x为偶数位，   x 为奇数位
        return x ==right || x == right/10;

    }
}
