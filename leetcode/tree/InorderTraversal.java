

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历
 */
public class InorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;
        System.out.println(inorderTraversal(root));

    }
    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }
            TreeNode node = stack.pop();
            ans.add(node.val);
            curr = node.right;
        }
        return ans;
    }


//    private static List<Integer> inorderTraversal2(TreeNode root) {
//        if ( root == null) {
//            return res;
//        }
//        inorderTraversal(root.left);
//        res.add(root.val);
//        inorderTraversal(root.right);
//
//        return res;
//    }
//    List<Integer> ans = new ArrayList<>();

}
