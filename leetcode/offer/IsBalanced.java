package offer;

/**
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 * 面试题55 - II. 平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 *
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return !notBalnce;
    }
    boolean notBalnce = false;
    public int getHeight(TreeNode root) {
        if (notBalnce) {
            return 0;
        }
        if (null == root) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (!notBalnce) {
            notBalnce = Math.abs(right - left) > 1;
        }
        return Math.max(left, right) + 1;
    }
}
