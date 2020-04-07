/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/7
 * Time: 11:43 AM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 22. 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParenthesis {
    public static void main(String[] args) {

        List<String> ans = (new GenerateParenthesis()).generateParenthesis(3);
        System.out.println();
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String curr, int open, int close, int max) {
        if (curr.length() == max * 2) {
            ans.add(curr);
            return;
        }
        if (open < max) {
            backtrack(ans, curr + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(ans, curr + ")", open, close + 1, max);
        }
    }
}
