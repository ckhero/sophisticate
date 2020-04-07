/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/7
 * Time: 2:03 PM
 */

/**
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * 32. 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * dp[i]  为 以i结尾的最长有效括号的长度
 */
public class LongestValidParentheses {
    public static void main(String[] args) {

//        System.out.println((new LongestValidParentheses()).longestValidParentheses("()"));
        System.out.println((new LongestValidParentheses()).longestValidParentheses("()(()"));
        System.out.println((new LongestValidParentheses()).longestValidParentheses(")()())"));
//        System.out.println((new LongestValidParentheses()).longestValidParentheses("(()"));
        System.out.println();
    }
    public int longestValidParentheses(String s) {
        int len = s.length();
        if (len <= 1) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = 0;
        int ans = 0;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(' ) {
                    int pre = i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0;
                    dp[i] = dp[i - 1] + pre + 2;
                }
            }

            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
