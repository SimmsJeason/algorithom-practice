package TypicalAlgorithm.BinarySearch;

/**
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 *
 * 在比较时，字母是依序循环出现的。举个例子：
 *
 * 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 *  
 *
 * 示例：
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "a"
 * 输出: "c"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "c"
 * 输出: "f"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "d"
 * 输出: "f"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "g"
 * 输出: "j"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "j"
 * 输出: "c"
 *
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "k"
 * 输出: "c"
 *  
 *
 * 提示：
 *
 * letters长度范围在[2, 10000]区间内。
 * letters 仅由小写字母组成，最少包含两个不同的字母。
 * 目标字母target 是一个小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC744 {

    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int l = 0, h = n - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (letters[m] <= target) {//注意是小于等于
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l < n ? letters[l] : letters[0];
    }


    public char nextGreatestLetter2(char[] letters, char target) {

        int l = 0;
        int h = letters.length-1;
        int mid = 0;
        int index = -1;
        while (l<=h){
            mid = l + (h-l)/2;
            if(letters[mid] > target){
                h = mid -1;
            }else if(letters[mid] < target){
                l = mid +1;
            }else if(letters[mid] == target){
                index = mid;
                while(index < letters.length && letters[index] == target){
                    index ++;
                }
                index --;
                break;
            }
        }

        //循环结束时， l > h 我们取较大值 l
        if(index != -1){
            return letters[(index+1) % letters.length];
        }else{
            if(l >= letters.length) {
                return letters[0];
            }else {
                return letters[l];//取较大值
            }
        }
    }
}
