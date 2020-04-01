package dp;

import java.util.Arrays;

/**
 * 85. 最大矩形
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * 输出: 6
 */
public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println((new MaximalRectangle()).maximalRectangle(matrix));

    }

    /**
     * 寻找某一个点 最高高度 和左界 右界
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        int cols = matrix[0].length;
        int max = 0;

        int[] height = new int[cols];
        int[] left = new int[cols];
        int[] right = new int[cols];
        Arrays.fill(right, cols);

        for (int row = 0; row < rows; row++) {
            int currLeft = 0;
            int currRight = cols;

            //更新高度
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '1') {
                    height[col] += 1;
                } else {
                    height[col] = 0;
                }
            }

            //更新 left 左界
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '1') {
                    left[col] = Math.max(currLeft, left[col]);
                } else {
                    left[col] = 0;
                    currLeft = col + 1;
                }
            }

            //更新右界 从右边开始找
            for (int col = cols - 1; col >= 0; col--) {
                if (matrix[row][col] == '1') {
                    right[col] = Math.min(currRight, right[col]);
                } else {
                    //付成初始值
                    right[col] = cols;
                    currRight = col;
                }
            }

            for (int col = 0; col < cols; col++) {
                max = Math.max(height[col] * (right[col] - left[col]), max);
            }
        }
        return max;
    }

    public int maximalRectangl2e(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[] left = new int[n]; // initialize left as the leftmost boundary possible
        int[] right = new int[n];
        int[] height = new int[n];

        Arrays.fill(right, n); // initialize right as the rightmost boundary possible

        int maxarea = 0;
        for (int i = 0; i < m; i++) {
            int cur_left = 0, cur_right = n;
            // update height
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            // update left
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') left[j] = Math.max(left[j], cur_left);
                else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            // update right
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') right[j] = Math.min(right[j], cur_right);
                else {
                    right[j] = n;
                    cur_right = j;
                }
            }
            // update area
            for (int j = 0; j < n; j++) {
                maxarea = Math.max(maxarea, (right[j] - left[j]) * height[j]);
            }
        }
        return maxarea;

    }
}
