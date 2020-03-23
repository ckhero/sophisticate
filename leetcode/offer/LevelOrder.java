package offer;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.*;

public class LevelOrder {
      public static  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(4);
        TreeNode a4 = new TreeNode(5);
        a.left = a1;
        a.right = a2;
        a1.left = a3;
        a1.right = a4;
        System.out.println(Arrays.toString((new LevelOrder()).levelOrder(a)));
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }


    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = -1;
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                ans= nums[i];
                break;
            }
        }
        return ans;
    }
}
