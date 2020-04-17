/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/17
 * Time: 5:00 PM
 */

/**
 * https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
 * 面试题44. 数字序列中某一位的数字
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 *
 * 请写一个函数，求任意第n位对应的数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 *
 * 输入：n = 11
 * 输出：0
 *
 *
 * 限制：
 */
public class FindNthDigit {
    public static void main(String[] args) {

        System.out.println((new FindNthDigit()).findNthDigit(10));
//        System.out.println((new FindNthDigit()).findNthDigit(10000));
//        System.out.println((new FindNthDigit()).findNthDigit(11));
//        System.out.println((new FindNthDigit()).findNthDigit(19));
        System.out.println();
    }
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        int i = 1;
        while (n > i * Math.pow(10, i - 1) * 9) {
            n -= i * Math.pow(10, i - 1) * 9;
            i ++;
        }
        char[] ans = String.valueOf((int) Math.pow(10, i - 1) + (n - 1) / i).toCharArray();
        return ans[(n - 1)%i] - '0';
    }
}
