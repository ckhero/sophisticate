/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/13
 * Time: 5:46 PM
 */

/**
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * 面试题29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralOrder {
    public static void main(String[] args) {

//        int[][] nums = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
//        int[][] nums = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] nums = new int[][]{{3},{2}};
        int[] ans = (new SpiralOrder()).spiralOrder(nums);
        System.out.println();
    }
    public int[] spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return new int[]{};
        }
        int cols = matrix[0].length;
        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;
        int[] ans = new int[rows * cols];
        int idx =0;
        while (true) {
            //上
            for (int i = left; i <= right; i++) {
                ans[idx++] = matrix[top][i];
            }
            if (++top > bottom) {
                break;
            }
            //右
            for (int i = top; i <= bottom; i++) {
                ans[idx++] = matrix[i][right];
            }
            if (left > --right) {
                break;
            }

            //下
            for (int i = right; i >= left; i--) {
                ans[idx++] = matrix[bottom][i];
            }
            if (top > --bottom) {
                break;
            }
            //左
            for (int i = bottom; i >= top; i--) {
                ans[idx++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return ans;
    }
}
