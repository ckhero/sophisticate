import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */
public class IsValidKuoHao {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (!stack.isEmpty()) {
                if ( curr == ']' && stack.peek() == '[') {
                    stack.pop();
                    continue;
                }
                if ( curr == '}' && stack.peek() == '{') {
                    stack.pop();
                    continue;
                }
                if ( curr == ')' && stack.peek() == '(') {
                    stack.pop();
                    continue;
                }
            }
            stack.push(curr);

        }
        return stack.isEmpty();
    }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);

    }
}
