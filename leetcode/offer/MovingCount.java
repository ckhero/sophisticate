/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/14
 * Time: 5:19 PM
 */

/**
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * 面试题13. 机器人的运动范围
 */
public class MovingCount {
    public static void main(String[] args) {

//        int ans = (new MovingCount()).movingCount(2, 3 ,1);
        int ans = (new MovingCount()).movingCount(16, 8 ,4);
        System.out.println(ans);
    }
    public int movingCount(int m, int n, int k) {
        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (i > 0 && !valid(i - 1, 0, k)) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (valid(i, j, k)) {
                    ans++;
                } else {
                    break;
                }
            }

        }
        return ans;
    }
    private boolean valid(int row, int col, int k) {
        while (row != 0) {
            k = k - row % 10;
            row /= 10;
        }
        while (col != 0) {
            k = k - col % 10;
            col /= 10;
        }
        return k >= 0;
    }
}
