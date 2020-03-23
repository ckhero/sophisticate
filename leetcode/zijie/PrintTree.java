package zijie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class PrintTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        (new PrintTree()).printTree(root);
    }

    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        List<List<String>> ans = new ArrayList<>();
        String[][] res = new String[height][ (int) Math.pow(2, height) - 1];
        for (int i = 0; i < height; i++) {
            Arrays.fill(res[i], "");
        }
        fill(res, root, 0, 0, res[0].length);
        for (int i = 0; i < height; i++) {
            ans.add(Arrays.asList(res[i]));
        }
        return ans;
    }

    public void fill(String[][] res, TreeNode root, int height, int left, int right) {
        if (root == null) {
            return;
        }
        int mid = (left + right) / 2;
        res[height][mid] = String.valueOf(root.val);
        fill(res, root.right, height + 1, (left + right + 1) / 2, right);
        fill(res, root.left, height + 1, left, (left + right) / 2);
    }
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
