package dailyPractice.hot100;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 *
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */
public class LC49 {
    /**
     * 根据特征归类，就要用散列表
     * 字母排序即可
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> ll = map.getOrDefault(key, new ArrayList<>());
            ll.add(s);
            map.put(key, ll);
        }
        return new ArrayList<>(map.values());
    }


    /**
     * 超时版
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        LinkedHashMap<String, List<String>> resMap = new LinkedHashMap<>();
        int[] visited = new int[strs.length];
        for (int i = 0; i< strs.length; i++) {
            if (visited[i] == 1) {
                continue;
            } else {
                visited[i] = 1;
            }
            List<String> sub;
            if (!resMap.containsKey(strs[i])) {
                int finalI = i;
                sub = new ArrayList<>(){{add(strs[finalI]);}};
            } else {
                sub = resMap.get(strs[i]);
            }

            for (int j = i+1; j < strs.length; j++) {
                if (isChange(strs[i], strs[j])) {
                    visited[j] = 1;
                    sub.add(strs[j]);
                }
            }
            resMap.put(strs[i], sub);
        }
        return new ArrayList<>(resMap.values());
    }


    public boolean isChange(String str1, String str2){
        Map<Character, Integer> letterNum1 = new HashMap<>();
        Map<Character, Integer> letterNum2 = new HashMap<>();
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            int num1 = letterNum1.getOrDefault(str1.charAt(i), 0);
            int num2 = letterNum2.getOrDefault(str2.charAt(i), 0);
            letterNum1.put(str1.charAt(i), num1+1);
            letterNum2.put(str2.charAt(i), num2+1);
        }
        boolean isChange = true;
        for (Map.Entry<Character, Integer> m : letterNum1.entrySet()) {
            if (!letterNum2.containsKey(m.getKey())) {
                isChange = false;
                break;
            }
            if (!letterNum2.get(m.getKey()).equals(m.getValue())) {
                isChange = false;
                break;
            }
        }
       return isChange;
    }

    public static void main(String[] args) {
        LC49 lc49 = new LC49();
        String [] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(lc49.groupAnagrams(strs));
    }
}
