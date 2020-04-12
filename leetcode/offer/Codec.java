package offer;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
 * 面试题37. 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 示例: 
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Codec {
      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static void main(String[] args) {
//        String str = "[5,2,3,null,null,2,4,3,1]";
        String str = "      【】   ";
        Codec codec = new Codec();
        TreeNode ans = codec.deserialize(str);
        String ans22 = codec.serialize(ans);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
            if (root == null) {
                return null;
            }
          StringBuilder str = new StringBuilder();
          str.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr != null) {
                    str.append(curr.val + ",");
                    queue.add(curr.left);
                    queue.add(curr.right);
                } else {
                    str.append("null,");
                }
            }
        }
        str.deleteCharAt(str.length() - 1);
        str.append("]");
        return str.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.trim();
        if(data.equals("[]")) return null;
        data = data.substring(1, data.length() - 1);
        if (data == null) {
            return null;
        }
        String[] ans = data.split(",");

          Queue<TreeNode> queue = new LinkedList<>();
          TreeNode root = new TreeNode(Integer.parseInt(ans[0]));
          queue.add(root);
          int i = 1;
          while (i < ans.length) {
              TreeNode currNode = queue.poll();
              if (!ans[i].trim().equals("null")) {
                  currNode.left = new TreeNode(Integer.parseInt(ans[i].trim()));
                  queue.add(currNode.left);
              }
              i++;
              if (!ans[i].trim().equals("null")) {
                  currNode.right = new TreeNode(Integer.parseInt(ans[i].trim()));
                  queue.add(currNode.right);
              }
              i++;
          }
          return root;
    }

}
