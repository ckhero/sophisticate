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

    int[] parent;
    int[] rank;
    int count = 0;
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        int cols = grid[0].length;
        init(grid);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    grid[row][col] = 0; //他的周围为1的都已经减了1，反过来找到他的时候不用再减1
                    if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                        union(row * cols + col, (row - 1) * cols + col);
                    }
                    if (row + 1 < rows && grid[row + 1][col] == '1') {
                        union(row * cols + col, (row + 1) * cols + col);
                    }
                    if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                        union(row * cols + col, row * cols + col - 1);
                    }
                    if (col + 1 < cols && grid[row][col + 1] == '1') {
                        union(row * cols + col, row * cols + col + 1);
                    }
                }
            }
        }
        return count;
    }

    private void init(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        parent = new int[rows * cols];
        rank = new int[rows * cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int idx = row * cols + col;
                if (grid[row][col] == '1') {
                    count++;
                    parent[idx] = idx;
                }
                rank[idx] = 0;
            }
        }
    }

    private int find(int son) {
        if (son != parent[son]) {
            parent[son] = find(parent[son]);
        }
        return parent[son];
    }

    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            if (rank[px] > rank[py]) {
                parent[py] = px;
            } else if (rank[px] < rank[py]) {
                parent[px] = py;
            } else {
                parent[py] = px;
                rank[px] += 1;
            }
            count--;
        }
    }
}
