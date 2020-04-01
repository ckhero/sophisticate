package str;

import java.util.*;

/**
 * 267. 回文排列 II
 * 给定一个字符串 s ，返回其通过重新排列组合后所有可能的回文字符串，并去除重复的组合。
 *
 * 如不能形成任何回文排列时，则返回一个空列表。
 *
 * 示例 1：
 *
 * 输入: "aabb"
 * 输出: ["abba", "baab"]
 * 示例 2：
 *
 * 输入: "abc"
 * 输出: []
 */
public class GeneratePalindromes {
    public static void main(String[] args) {
        System.out.println((new GeneratePalindromes()).generatePalindromes("aabb"));
    }
    public List<String> generatePalindromes(String s) {
        List<String> ans = new ArrayList<>();
        if (s.isEmpty()) {
            return ans;
        }
        //对字符串里面的字母出现次数进行统计
        HashMap<Character, Integer> count = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            int tmp = count.getOrDefault(curr, 0);
            tmp += 1;
            count.put(curr, tmp);
            if (tmp % 2 != 0) {
                set.add(curr);
            } else {
                set.remove(curr);
            }
        }
        //校验 是否是回文子串
        if (set.size() > 1) {
            return ans;
        }
        String curr = set.iterator().hasNext() ? String.valueOf(set.iterator().next()) : "";
        backtracing(count, curr, ans);
        return  ans;
    }

    public void backtracing(HashMap<Character, Integer> count, String curr, List<String> ans) {
        if (count.size() == 0) {
            ans.add(curr);
            return;
        }
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            Map.Entry<Character, Integer> tmp = entry;
            curr = String.valueOf(entry.getValue()) + curr + String.valueOf(entry.getValue());
            count.remove(tmp.getKey());
            backtracing(count, curr, ans);
            count.put(tmp.getKey(), tmp.getValue());
        }
    }
}
