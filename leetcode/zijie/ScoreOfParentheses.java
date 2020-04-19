package zijie;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/score-of-parentheses/
 * 856. 括号的分数
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 *
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 *
 *
 * 示例 1：
 *
 * 输入： "()"
 * 输出： 1
 * 示例 2：
 *
 * 输入： "(())"
 * 输出： 2
 * 示例 3：
 *
 * 输入： "()()"
 * 输出： 2
 * 示例 4：
 *
 * 输入： "(()(()))"
 * 输出： 6
 */
public class ScoreOfParentheses {
    public static void main(String[] args) {
//        System.out.println((new ScoreOfParentheses()).scoreOfParentheses("()"));
//        System.out.println((new ScoreOfParentheses()).scoreOfParentheses("(()(()))"));
        System.out.println((new ScoreOfParentheses()).scoreOfParentheses("(())()"));
    }

    public int scoreOfParentheses(String S) {
        int ans = 0;
        int len = S.length();
        if (len == 0) {
            return 0;
        }
        int k = 0;
        boolean calc = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char curr = S.charAt(i);
            if (curr == '(') {
                calc = true;
                k++;
                stack.add(curr);
                continue;
            }
            if (calc) {
                ans += (int) Math.pow(2, k - 1);
                calc = false;
            }
            stack.pop();
            k--;
        }
        return ans;
    }
}
