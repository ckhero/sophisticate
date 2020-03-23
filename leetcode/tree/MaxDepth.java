package tree;

public class MaxDepth {

      public static class TreeNode {
           int val;
           TreeNode left;
           TreeNode right;
           TreeNode(int x) { val = x; }
       }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode l1 = new TreeNode(-1);
        TreeNode l2 = new TreeNode(3);
        root.left = l1;
//        root.right = l2;
        System.out.println(isValidBST(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    private static boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        boolean left = isValidBST(root.left);
        boolean right = isValidBST(root.right);
        if (left && right) {
            return true;
        }
        return false;
    }
}
