/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/14
 * Time: 10:54 AM
 */
public class MirrorTree {
     public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode mirrorTree(TreeNode root) {
        swap(root);
        return root;
    }

    private void swap(TreeNode root) {
         if (root == null) {
             return;
         }
        TreeNode left = root.left;
         root.left = root.right;
        root.right = left;
        swap(root.left);
        swap(root.right);
    }
}
