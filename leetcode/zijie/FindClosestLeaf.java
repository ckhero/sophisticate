package zijie;

import offer.FindNumberOfLIS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/closest-leaf-in-a-binary-tree/
 * 742. 二叉树最近的叶节点
 * 给定一个 每个结点的值互不相同 的二叉树，和一个目标值 k，找出树中与目标值 k 最近的叶结点。
 *
 * 这里，与叶结点 最近 表示在二叉树中到达该叶节点需要行进的边数与到达其它叶结点相比最少。而且，当一个结点没有孩子结点时称其为叶结点。
 *
 * 在下面的例子中，输入的树以逐行的平铺形式表示。实际上的有根树 root 将以TreeNode对象的形式给出。
 *
 * 示例 1：
 *
 * 输入：
 * root = [1, 3, 2], k = 1
 * 二叉树图示：
 *           1
 *          / \
 *         3   2
 *
 * 输出： 2 (或 3)
 *
 * 解释： 2 和 3 都是距离目标 1 最近的叶节点。
 *
 *
 * 示例 2：
 *
 * 输入：
 * root = [1], k = 1
 * 输出：1
 */
public class FindClosestLeaf {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a6 = new TreeNode(6);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a4.right = a6;
        System.out.println((new FindClosestLeaf()).findClosestLeaf(a1, 2));
    }
    public int findClosestLeaf(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        boolean mark = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();

                if (currNode.val == k) {
                    mark = true;
                }
                if (mark && currNode.left == null && currNode.right == null) {
                    return currNode.val;
                }
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
        }
        return  -1;
    }
}
