/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/8
 * Time: 6:25 PM
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/eight-queens-lcci/
 * 面试题 08.12. 八皇后
 * 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
 *
 * 注意：本题相对原题做了扩展
 *
 * 示例:
 *
 *  输入：4
 *  输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 *  解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 通过次数1,311提交次数1,802
 */
public class SolveNQueens {
    public static void main(String[] args) {

        List<List<String>>  aa = (new SolveNQueens()).solveNQueens(4);
        System.out.println();
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        char[][] nums = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(nums[i], '.');
        }
        backtrack(nums,0, ans);
        return ans;
    }

    private void backtrack(char[][] nums, int currRow, List<List<String>> ans) {
        int len = nums.length;
        if (len == currRow) {
            List<String> path2 = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                path2.add(String.valueOf(nums[i]));
            }
            ans.add(path2);
            return;
        }

        for (int col = 0; col < len; col++) {
            //判断这个位置是否合适
            boolean isok = true;
            for (int row = 0; row < currRow; row++) {
                //竖的有Q
                if (nums[row][col] == 'Q') {
                    isok = false;
                    break;
                }
                //判断对角线
                if (col + (currRow - row) < len && nums[row][col + (currRow - row)] == 'Q') {
                    isok = false;
                    break;
                }
                if (col - (currRow - row) >= 0 && nums[row][col - (currRow - row)] == 'Q') {
                    isok = false;
                    break;
                }
            }
            if (!isok) {
                continue;
            }
            //满足条件
            nums[currRow][col] = 'Q';
            backtrack(nums, currRow + 1, ans);
            nums[currRow][col] = '.';
        }
    }
}
