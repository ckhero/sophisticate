/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/16
 * Time: 11:21 AM
 */

/**
 *
 */
public class TreeTest {

    class TreeNode//节点结构
    {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }

    }
    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
    }

}
