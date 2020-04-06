public class NumIslands {
    /**
     * 200. 岛屿数量
     * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
     *
     * 示例 1:
     *
     * 输入:
     * 11110
     * 11010
     * 11000
     * 00000
     *
     * 输出: 1
     * 示例 2:
     *
     * 输入:
     * 11000
     * 11000
     * 00100
     * 00011
     *
     * 输出: 3
     * @param args
     */
    public static void main(String[] args) {
    }

    public int numIslands(char[][] grid) {
        int ans = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        if (rows == 0) {
            return 0;
        }
        if (grid[0][0] == '1') {
            ans ++;
        }
        for (int row = 1; row < rows; row++) {
            if (grid[row - 1][0] == '0') {
                ans++;
            }
        }
        for (int col = 1; col < cols; col++) {
            if (grid[0][col - 1] == '0') {
                ans++;
            }
        }

        for (int row = 1; row < rows ; row++) {
            for (int col = 1; col < cols; col++) {
                if (row == rows - 1) {
                    if (grid[row][col - 1] == '0' && grid[row - 1][col] == '0' && grid[row + 1][col] == '0') {
                        ans ++;
                    }
                    continue;
                }
                if (col == cols - 1) {
                    if (grid[row][col - 1] == '0' && grid[row][col + 1] == '0' && grid[row - 1][col] == '0') {
                        ans ++;
                    }
                    continue;
                }
                if (grid[row][col - 1] == '0' &&  grid[row + 1][col] == '0') {
                    ans ++;
                }
            }
        }
        return ans;
    }
}
