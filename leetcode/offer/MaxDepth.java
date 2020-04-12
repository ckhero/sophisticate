package offer;

public class MaxDepth {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int maxDepth(TreeNode root) {
        return getH(root);
    }

    private  int getH(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getH(root.left), getH(root.right)) + 1;
    }
}
