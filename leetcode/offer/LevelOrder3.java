/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/16
 * Time: 3:12 PM
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 * 面试题32 - III. 从上到下打印二叉树 III
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 *
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 *
 * 提示：
 *
 * 节点总数 <= 1000
 */
public class LevelOrder3 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        Deque<TreeNode> deque = new LinkedList<>();

        deque.add(root);
        while (!stack.isEmpty() || !deque.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            if (!stack.isEmpty()) {
                while (!stack.isEmpty()) {
                    TreeNode curr = stack.pop();
                    tmp.add(curr.val);

                    if (curr.right != null) {
                        deque.add(curr.right);
                    }
                    if (curr.left != null) {
                        deque.add(curr.left);
                    }
                }

            } else  {
                while (!deque.isEmpty()) {
                    TreeNode curr = deque.pollFirst();
                    tmp.add(curr.val);
                    if (curr.left != null) {
                        stack.add(curr.left);
                    }
                    if (curr.right != null) {
                        stack.add(curr.right);
                    }

                }
            }
            ans.add(tmp);
        }
        return ans;
    }
}
