/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/16
 * Time: 2:04 PM
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class PreorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        root1.right = root2;
        root2.left = root3;
        (new PreorderTraversal()).preorderTraversal(root1);
        System.out.println();
    }
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        if (null == root) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            ans.add(curr.val);
            if (curr.right != null) {
                stack.add(curr.right);
            }
            if (curr.left != null) {
                stack.add(curr.left);
            }
        }
        return ans;
    }
    //递归
    List<Integer> ans = new ArrayList<>();
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        helper(root.left);
        helper(root.right);
    }
}
