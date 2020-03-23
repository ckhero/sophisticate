package tree;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class IsValidBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {
//        HashMap
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer lower, Integer high) {
        if (root == null) return true;
        int val = root.val;
        if (lower != null && val <= lower) return false;
        if (high != null && val >= high) return false;
        if (!helper(root.left, lower, val)) return false;
        if (!helper(root.right, val, high)) return false;
        return true;
    }
}
