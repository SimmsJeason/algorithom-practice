package dailyPractice.hot100;

import java.util.*;

/**
 * 找到字符串中所有字母异位词
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *  示例 2:
 *
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 */
public class LC428 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int sLen = s.length(), pLen = p.length();
        if (pLen > sLen) {
            return new ArrayList<>();
        }
        int [] sCount = new int[26]; // 26个字母
        int [] pCount = new int[26];

        for(int i = 0; i < pLen; i++){
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        if (isEquals(sCount, pCount)) {
            res.add(0);
        }
        for (int i = pLen; i< sLen; i++) {
            sCount[s.charAt(i - pLen) - 'a']--;
            sCount[s.charAt(i) - 'a']++;
            if (isEquals(sCount,pCount)) {
                res.add(i - pLen + 1);
            }
        }

        return res;
    }

    /**
     *  Arrays.equals(sCount, pCount)
     * @param a
     * @param b
     * @return
     */
    public boolean isEquals(int [] a, int [] b){
       if (a.length != b.length) {
           return false;
       }

       for (int i = 0; i < a.length; i++) {
           if (a[i] != b[i]) {
               return false;
           }
       }
       return true;
    }

    public static void main(String[] args) {

        LC428 lc428 = new LC428();
        System.out.println(lc428.findAnagrams("abab", "ab"));
    }

}
