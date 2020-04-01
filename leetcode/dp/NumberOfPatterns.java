package dp;

/**
 * 先来了解下什么是一个有效的安卓解锁手势:
 *
 * 每一个解锁手势必须至少经过 m 个点、最多经过 n 个点。
 * 解锁手势里不能设置经过重复的点。
 * 假如手势中有两个点是顺序经过的，那么这两个点的手势轨迹之间是绝对不能跨过任何未被经过的点。
 * 经过点的顺序不同则表示为不同的解锁手势。
 *  
 *
 *
 *  
 *
 * 解释:
 *
 * | 1 | 2 | 3 |
 * | 4 | 5 | 6 |
 * | 7 | 8 | 9 |
 * 无效手势：4 - 1 - 3 - 6
 * 连接点 1 和点 3 时经过了未被连接过的 2 号点。
 *
 * 无效手势：4 - 1 - 9 - 2
 * 连接点 1 和点 9 时经过了未被连接过的 5 号点。
 *
 * 有效手势：2 - 4 - 1 - 3 - 6
 * 连接点 1 和点 3 是有效的，因为虽然它经过了点 2 ，但是点 2 在该手势中之前已经被连过了。
 *
 * 有效手势：6 - 5 - 4 - 1 - 9 - 2
 * 连接点 1 和点 9 是有效的，因为虽然它经过了按键 5 ，但是点 5 在该手势中之前已经被连过了。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/android-unlock-patterns
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberOfPatterns {
    public static void main(String[] args) {

        System.out.println((new NumberOfPatterns()).numberOfPatterns(1,2));
    }
    public int numberOfPatterns(int m, int n) {
        boolean[][] used = new boolean[3][3];
        int  ans  = 0;
        for (int i = m; i <= n; i++) {
            ans += dfs(0, 0, used, i, false);
        }
        return ans;
    }

    public int dfs(int row, int col, boolean[][] used, int k, boolean isNext) {
        int len = used.length;
        if (row >= len || row < 0 || col >= len || col < 0) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (used[i][j]) continue;
                if ((Math.abs(row - i) == 2 || Math.abs(col - j) == 2) && isNext) {
                    int tmpRow = row  + i;
                    int tmpCol = col  + j;
                    if (tmpCol % 2 == 0 && tmpRow % 2 ==  0 && !used[tmpRow / 2][tmpCol / 2]) {
                        continue;
                    }
                }
                used[i][j] = true;
                ans += dfs(i, j, used, k - 1, true);
                used[i][j] = false;
            }
        }
        return ans;
    }
}
