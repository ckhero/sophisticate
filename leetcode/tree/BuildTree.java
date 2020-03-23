package tree;

import java.util.HashMap;

/**
 *
 * 面试题07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 */
public class BuildTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {3,9,20,15,7};
        int[] nums2 = new int[] {9,3,15,20,7};
//        System.out.println((8&7));
//        TreeNode  tree = (new BuildTree()).buildTree(nums1, nums2);
        System.out.println((new BuildTree()).exchange(new int[]{1,2,3,4}));
    }

    /**
     * 1.00000
     * -2147483648
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        long curr = n;
        if (curr == 0) {
            return 1;
        }
        if (curr < 0) {
            x = 1/x;
            curr = -curr;
        }
        int ans = 1;
        while (curr != 0) {
            long a = curr / 2;
            long b = curr % 2;

        }
        return ans;
    }
    /**
     * 记下 中序遍历的 索引为位置
     * 找到根结点。然后用找到跟节点在 中序遍历的位置，然后就可以确定左右子树，然后就可以对左右子树进行迭代
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    public TreeNode helper(int[] preorder,
                           int preStart,
                           int preEnd,
                           int[] inorder,
                           int inStart,
                           int inEnd,
                           HashMap<Integer, Integer> map) {
        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = map.get(rootVal);
        // 左子树是 位置是preStart + 1；end 是prestart + 左子树的长度，中序 start 是中序start，结尾是 rootindex - 1
        root.left = helper(preorder, preStart + 1, preStart + rootIndex - inStart, inorder, inStart, rootIndex - 1, map);
        /// 柚子树起点是 start + 左子树的长度 + 1
        root.right = helper(preorder, preStart + rootIndex - inStart + 1, preEnd, inorder, rootIndex + 1, inEnd, map);
        return root;
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //从右上角开始找
        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            int curr = matrix[row][col];
            if (curr == target) {
                return true;
            }
            if (curr > target) {
                col --;
            } else {
                row ++;
            }
        }
        return false;
    }

    /**
     * 面试题21. 调整数组顺序使奇数位于偶数前面
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     *
     *
     *
     * 示例：
     *
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,2,4]
     * 注：[3,1,2,4] 也是正确的答案之一。
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 50000
     * 1 <= nums[i] <= 10000
     * @param nums
     * @return
     */

    public int[] exchange(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        while ( left <= right) {
            int lVal = nums[left];
            int rVal = nums[right];
            int lTmp = lVal & 1;
            int rTmp = rVal & 1;
            if ((lTmp == 0 && rTmp == 1)) {
                nums[right] = lVal;
                nums[left] = rVal;
                left++;
                right--;
                continue;
            }

            if ((lTmp == 1 && rTmp == 0)) {
                left++;
                right--;
                continue;
            }
            if (lTmp == 0 ) {
                right--;
            } else {
                left++;
            }
        }
        return nums;
    }
}
