package dp;

import java.util.Arrays;

/**
 * 221. 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 * 通过次数27,198提交次数69,101
 * f(n) = f(n - 1) + 四周 1
 */
public class MaximalSquare {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1','0','1','0', '0'},
                {'1','0','1','1', '1'},
                {'1','1','1','1', '1'},
                {'1','0','0','1', '0'},

        };
        System.out.println((new MaximalSquare()).maximalSquare(matrix));
    }
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0 ) {
            return 0;
        }
        int max = 0;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            max = Math.max(max, dp[i][0]);
        }
        for (int i = 0; i < cols; i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            max = Math.max(max, dp[0][i]);

        }
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (matrix[row][col] == '1') {
                    dp[row][col] = Math.min(Math.min(dp[row - 1][col - 1], dp[row][col - 1]), dp[row - 1][col]) + 1;
                    max = Math.max(dp[row][col], max);
                }
            }
        }
        return max * max;
    }
}
