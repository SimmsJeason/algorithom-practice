package TypicalAlgorithm.String;

/**
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 *
 * 重复出现的子串要计算它们出现的次数。
 *
 * 示例 1 :
 *
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 *
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 *
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * 示例 2 :
 *
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 * 注意：
 *
 * s.length 在1到50,000之间。
 * s 只包含“0”或“1”字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-binary-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC696 {

    //参考LC647 的想法
    private int count = 0;
    public int countBinarySubstrings(String s) {
        for(int i = 1; i < s.length(); i++) {

            if(s.charAt(i-1) != s.charAt(i)) {
                BinarySubstring(s, i-1, i);
            }

        }
        return count;
    }

    public void BinarySubstring(String s, int start, int end) {
        char f = s.charAt(start);
        char e = s.charAt(end);
        while(start >= 0 && end < s.length() && s.charAt(start) == f && s.charAt(end) == e) {
            start--;
            end++;
            count++;
        }
    }

    public int countBinarySubstrings1(String s) {
        int preLen = 0, curLen = 1, count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curLen++;
            } else {
                preLen = curLen;
                curLen = 1;
            }

            if (preLen >= curLen) {
                count++;
            }
        }
        return count;
    }

    int cnt = 0;
    public int countBinarySubstrings2(String s) {
        for(int i = 0; i< s.length(); i++){
            check(i, s);
        }
        return cnt;
    }

    public void check(int start, String s){
        int times = 0;
        char begin = s.charAt(start);

        for(int i = start ; i< s.length() ; i++){
            char cur = s.charAt(i);
            if( begin == cur){
                times ++;
            }else {
                times--;
            }
            if(times == 0){
                cnt ++;
                break;
            }
        }
    }
}
