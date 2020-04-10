/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/10
 * Time: 6:13 PM
 */

/**
 * https://leetcode-cn.com/problems/minimum-window-substring/
 * 76. 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * 通过次数32,862提交次数92,240
 * 在真实的面试中遇到过这道题？
 *
 * 是
 *
 * 否
 */
public class MinWindow {
    public static void main(String[] args) {

        System.out.println((new MinWindow()).minWindow("ADOBECODEBANC", "ABC"));
        System.out.println();
    }
    public String minWindow(String s, String t) {
        if (s.isEmpty() || t.length() > s.length()) {
            return "";
        }
        int len = s.length();
        int[] needs = new int[128];
        for (int i = 0; i < t.length(); i++) {
            needs[t.charAt(i)] += 1;
        }
        int[] windows = new int[128];
        int left = 0;
        int right = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int match = 0;

        while (right < len) {
            int curr = s.charAt(right);
            //如果是需要的 做如下处理
            windows[curr] += 1;
            // 如果是需要的字符串并且 需要的字符数量小于窗口中的数量的时候
            if (needs[curr] > 0 && needs[curr] >= windows[curr]) {
                match++;
            }
            //满足最小串 开始缩小
            while (match == t.length()) {
                int currLeft = s.charAt(left);
                if (needs[currLeft] > 0 && needs[currLeft] >= windows[currLeft]) {
                    match--;
                }
                if (right - left + 1 < minLen) {
                    start = left;
                    minLen = right - left + 1;
                }
                windows[currLeft]--;
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "": s.substring(start, start + minLen);
    }
}
