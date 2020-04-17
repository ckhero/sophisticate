/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/16
 * Time: 5:36 PM
 */
package offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 10000
 * 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/
 *
 * 通过次数10,362提交次数18,579
 * 在真实的面试中遇到过这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        TreeNode root2 = new TreeNode(-3);
        root.right = root2;
        (new PathSum()).pathSum(root, - 5);
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (null == root) {
            return ans;
        }
        List<Integer> tmp = new ArrayList<>();
        backtrack(root, sum, tmp, ans);
        return ans;
    }

    public void backtrack(TreeNode root, int sum, List<Integer> path, List<List<Integer>> ans) {
        if (root == null) {

            return;
        }
        sum -= root.val;
        path.add(root.val);
        if (root.right == null && root.left == null && sum == 0) {
            ans.add(new ArrayList<>(path));
        }
        backtrack(root.left, sum, path, ans);
        backtrack(root.right, sum, path, ans);
        path.remove(path.size() - 1);
    }
}
