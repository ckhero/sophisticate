/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/3
 * Time: 4:17 PM
 */
/*
79. 单词搜索
给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。



示例:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false
 */
public class ExistWords {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        boolean res = (new ExistWords()).exist(board, "ABCB");
        System.out.println(res);

    }
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        int rows = board.length;
        int cols = board[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                boolean res = backtrack(board, used, word, 0, row, col);
                if (res) {
                    return res;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, boolean[][] used, String word, int idx, int row, int col) {
        if (idx == word.length()) {
            return true;
        }
        int rows = board.length;
        int cols = board[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols ||  used[row][col] || board[row][col] != word.charAt(idx)) {
            return false;
        }
        used[row][col] = true;
        boolean res = backtrack(board, used, word, idx + 1, row, col - 1) ||
                backtrack(board, used, word, idx + 1, row, col + 1) ||
                backtrack(board, used, word, idx + 1, row + 1, col) ||
                backtrack(board, used, word, idx + 1, row - 1, col);
        used[row][col] = false;
        return res;
    }
}
