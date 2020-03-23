package offer;

/**
 * 647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 示例 1:
 *
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 *
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * 注意:
 *
 * dp[i][j] = dp[i+1][j-1] && s.i = s.j
 */
public class CountSubstrings {
    public static void main(String[] args) {
        System.out.println((new CountSubstrings()).countSubstrings("aba"));
    }
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int ans = 0;
        for (int i = len - 2; i >= 0 ; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = (dp[i + 1][j - 1] || j - i < 3) && s.charAt(i) == s.charAt(j);
                if (dp[i][j]) {
                    ans += 1;
                }
            }
        }
        return ans + len;
    }
}
