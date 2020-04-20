/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/20
 * Time: 4:40 PM
 */

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
 *
 * 解释： 最近的叶节点是根结点自身。
 *
 *
 * 示例 3：
 *
 * 输入：
 * root = [1,2,3,4,null,null,null,5,null,6], k = 2
 * 二叉树图示：
 *              1
 *             / \
 *            2   3
 *           /
 *          4
 *         /
 *        5
 *       /
 *      6
 *
 * 输出：3
 * 解释： 值为 3（而不是值为 6）的叶节点是距离结点 2 的最近结点。
 *
 *
 * 注：
 *
 * root 表示的二叉树最少有 1 个结点且最多有 1000 个结点。
 * 每个结点都有一个唯一的 node.val ，范围为 [1, 1000]。
 * 给定的二叉树中有某个结点使得 node.val == k。
 *
 */
public class FindClosestLeaf {
    /**
     * 广度优先
     * @param root
     * @param k
     * @return
     */
    public int findClosestLeaf(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ans = -1;
        boolean start = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.val == k) {
                    start = true;
                    queue = new LinkedList<>();
                    i = size;
                }
                if (start && curr.left == null && curr.right == null) {
                    ans = curr.val;
                    break;
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
        return ans;
    }
}
