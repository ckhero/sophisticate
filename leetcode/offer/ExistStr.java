package offer;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/submissions/
 */
public class ExistStr {

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        char[] words = word.toCharArray();
        for (int row = 0; row < rows ; row++) {
            for (int col = 0; col < cols; col++) {
                if (dfs(board, words, row, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] words, int row, int col, int k) {
        int rows = board.length;
        int cols = board[0].length;
        if (row >= rows || col >= cols || row < 0 || col < 0 || board[row][col] != words[k]) {
            return false;
        }
        if (words.length - 1 == k) {
            return true;
        }
        char tmp = board[row][col];
        board[row][col] = '/';
        boolean res = dfs(board, words, row - 1, col, k + 1) || dfs(board, words, row , col - 1, k + 1)
                || dfs(board, words, row + 1, col, k + 1) || dfs(board, words, row, col + 1, k + 1);
        board[row][col] = tmp;
        return res;


    }
}
