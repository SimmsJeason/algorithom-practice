package TypicalAlgorithm.Sort.HeapSort;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 *
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 *
 * 输入:
 * "cccaaa"
 *
 * 输出:
 * "cccaaa"
 *
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 *
 * 输入:
 * "Aabb"
 *
 * 输出:
 * "bbAa"
 *
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC451 {

    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i< s.length(); i++){
            int times = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), times + 1);
        }

        Queue<Character> queue = new PriorityQueue<>((o1, o2)-> (map.get(o2) - map.get(o1)));
        for(Character c : map.keySet()){
            queue.add(c);
        }
        StringBuffer sb = new StringBuffer();

        while(!queue.isEmpty()){
            char tmp = queue.poll();
            for(int i =0; i < map.get(tmp); i++){
                sb.append(tmp);
            }
        }

        return sb.toString();
    }
}
