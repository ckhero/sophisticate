/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/2
 * Time: 6:14 PM
 */

/**
 * 461. 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        x ^= y; // 不同的位置标记为1
        //计算1的个数
        //巧用 n&(n-1) 会把最右边的1变为
        int ans = 0;
        while (x != 0) {
            ans++;
            x &= (x - 1);
        }
        return ans;
    }
}
