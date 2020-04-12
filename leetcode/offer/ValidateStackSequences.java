package offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/validate-stack-sequences/
 * 946. 验证栈序列
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 */
public class ValidateStackSequences {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        int[] nums2 = new int[]{5,4,3,2,1};
//        int[] nums = new int[]{2,1,0};
//        int[] nums2 = new int[]{1,2,0};
        System.out.println((new ValidateStackSequences()).validateStackSequences(nums, nums2));
    }
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int lenp = pushed.length;
        int len2 = pushed.length;
        if (len2 != lenp) {
            return false;
        }
        if (len2 == 0) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        int idPush = 0;
        int idPop = 0;
        while (idPush < lenp) {
            int curr = pushed[idPush];
            stack.add(curr);
            idPush++;

            while (!stack.isEmpty() && popped[idPop] == stack.peek()) {
                stack.pop();
                idPop ++;
            }
        }

        return stack.isEmpty();
    }
}
