package dp;

/**
 * 63. 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 *
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class UniquePathsWithObstacles {

    public static void main(String[] args) {
//        int[][] obstac = new  int[][]{{0,0,0},{0,1,0},{0,0,0}};
        int[][] obstac = new  int[][]{{0, 0}};
        System.out.println((new UniquePathsWithObstacles()).uniquePathsWithObstacles(obstac));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows =  obstacleGrid.length;
        int cols =  obstacleGrid[0].length;
        int[][] dp  = initDp(obstacleGrid);
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (obstacleGrid[row][col] == 1) {
                    dp[row][col] = 0;
                    continue;
                }
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }
        return dp[rows - 1][cols - 1];
    }

    public int[][] initDp(int[][] obstacleGrid){
        int rows =  obstacleGrid.length;
        int cols =  obstacleGrid[0].length;
        int[][] dp  = new int[rows][cols];
        boolean isTrap = false;
        for (int row = 0; row < rows; row++) {
            if (isTrap) {
                dp[row][0] = 0;
                continue;
            }
            if (obstacleGrid[row][0] == 1) {
                dp[row][0] = 0;
                isTrap = true;
                continue;
            }
            dp[row][0] = 1;
        }
        isTrap = false;

        for (int col = 0; col < cols; col++) {
            if (isTrap) {
                dp[0][col] = 0;
                continue;
            }
            if (obstacleGrid[0][col] == 1) {
                dp[0][col] = 0;
                isTrap = true;
                continue;
            }
            dp[0][col] = 1;
        }
        return dp;
    }
}
