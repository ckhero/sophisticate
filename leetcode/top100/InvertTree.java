/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class InvertTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

        TreeNode b2 = new TreeNode(2);
        TreeNode b1 = new TreeNode(1);
        TreeNode b3 = new TreeNode(3);
        TreeNode b4 = new TreeNode(4);
        TreeNode b7 = new TreeNode(7);
        b2.left = b1;
        b2.right = b3;
        b1.right = b4;
        b3.right = b7;
        TreeNode aa = (new InvertTree()).invertTree(b2);
        System.out.println();
    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(right);
        return root;
    }
}
