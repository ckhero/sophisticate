package zijie;

/**
 * 201. 数字范围按位与
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 *
 * 示例 1:
 *
 * 输入: [5,7]
 * 输出: 4
 * 示例 2:
 *
 * 输入: [0,1]
 * 输出: 0
 */
public class RAngeBitwiseAnd {
    public static void main(String[] args) {
        System.out.println((new RAngeBitwiseAnd()).rangeBitwiseAnd(2147483647,2147483647));
    }

    public int rangeBitwiseAnd(int m, int n) {
        int ans = m;
        if (m == Integer.MAX_VALUE) {
            return m;
        }
        for (int i = m + 1; i <= n ; i++) {
            ans &= m;
            if (ans == 0 || m == Integer.MAX_VALUE) {
                break;
            }
            m++;
        }
        return ans;
    }
}
