package zijie;

/**
 * 给定一个正整数 n，你可以做如下操作：
 *
 * 1. 如果 n 是偶数，则用 n / 2替换 n。
 * 2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。
 * n 变为 1 所需的最小替换次数是多少？
 *
 * 示例 1:
 *
 * 输入:
 * 8
 *
 * 输出:
 * 3
 *
 * 解释:
 * 8 -> 4 -> 2 -> 1
 * 示例 2:
 *
 * 输入:
 * 7
 *
 * 输出:
 * 4
 *
 * 解释:
 * 7 -> 8 -> 4 -> 2 -> 1
 * 或
 * 7 -> 6 -> 3 -> 2 -> 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntegerReplacement {
    public static void main(String[] args) {
        System.out.println((new IntegerReplacement()).integerReplacement(2147483647));
        System.out.println((new IntegerReplacement()).integerReplacement2(2147483647));
    }

    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if ((n & 1) == 0) {
            return integerReplacement(n >>> 1) + 1;
        } else {
            return Math.min(integerReplacement(n - 1), integerReplacement(n + 1)) + 1;
        }
    }

    public int integerReplacement2(int n) {
        int step = 0;
        while (n != 1) {
            step++;
            if ((n & 1) == 0) {
                n >>>= 1;
            } else {
                n = (n & 2) == 0 || n == 3 ? n -1: n + 1;
            }
        }
        return step;
    }
}
