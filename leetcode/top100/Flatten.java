/**
 * 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * 通过次数34,191提交次数50,094
 */

public class Flatten {

  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(5);
        TreeNode root5 = new TreeNode(6);
        root.right = root4;
        root4.right = root5;
        root.left = root1;
        root1.left = root2;
        root1.right = root3;
        (new Flatten()).flatten(root);
        System.out.println();
    }
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        flatten(left);
        TreeNode right = root.right;
        flatten(right);
        root.right = left;
        root.left = null;
        TreeNode end = left;
        while (end != null && end.right != null) {
            end = end.right;
        }
        if (end != null) {
            end.right = right;
        } else {
            root.right = right;
        }
    }
}
