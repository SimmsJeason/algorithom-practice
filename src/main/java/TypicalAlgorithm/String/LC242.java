package TypicalAlgorithm.String;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC242 {

    public boolean isAnagram(String s, String t) {
        int [] sTime = new int[26];
        int [] tTime = new int[26];
        if(s.length() != t.length()) return false;

        for(int i = 0; i< s.length() ; i++){
            char curS = s.charAt(i);
            char curT = t.charAt(i);
            sTime[curS-'a'] += 1;
            tTime[curT-'a'] += 1;
        }

        for(int i = 0 ; i < 26; i++){
            if(sTime[i] != tTime[i]){
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram2(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        if(s.length() != t.length()) return false;

        for(int i = 0 ; i< s.length(); i++){
            char curS = s.charAt(i);
            char curT = t.charAt(i);
            mapS.put(curS, mapS.getOrDefault(curS, 0) +1 );
            mapT.put(curT, mapT.getOrDefault(curT, 0) +1 );
        }

        for(Character cur : mapS.keySet()){
            if(!mapT.containsKey(cur)){
                return false;
            }else {
                if(mapS.get(cur) != mapT.get(cur)){
                    return false;
                }
            }
        }

        return true;
    }
}
