package str;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 面试题 01.04. 回文排列
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 *
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 *
 * 回文串不一定是字典当中的单词。
 *
 *
 *
 * 示例1：
 *
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 */
public class CanPermutePalindrome {
    public static void main(String[] args) {

        System.out.println((new CanPermutePalindrome()).canPermutePalindrome("tactcoaa"));
    }

    public boolean canPermutePalindrome(String s) {
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
        return set.size() <= 1;
    }
}
