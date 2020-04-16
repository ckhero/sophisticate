/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/16
 * Time: 5:36 PM
 */

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

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        List<Integer> tmp = new ArrayList<>();
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                tmp.add(curr.val);
                sum -= curr.val;
                if (sum == 0) {
                    ans.add(new ArrayList<>(tmp));
                    if (!stack.isEmpty()) {
                        curr = stack.pop().right;
                        tmp.remove(tmp.size() - 1);
                    } else {
                        curr = null;
                        break;
                    }
                } else if (sum > 0){
                    curr = curr.left;
                } else if (sum < 0) {
                    if (!stack.isEmpty()) {
                        curr = stack.pop().right;
                        tmp.remove(tmp.size() - 1);
                    } else {
                        curr = null;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
