package offer;

/**
 * https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 * 面试题43. 1～n整数中1出现的次数
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：5
 * 示例 2：
 *
 * 输入：n = 13
 * 输出：6
 *
 *
 * 限制：
 *
 * 1 <= n < 2^31
 * 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/
 */
public class CountDigitOne {
    public static void main(String[] args) {
        System.out.println((new CountDigitOne()).countDigitOne(21));;
    }

    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        char[] nums = String.valueOf(n).toCharArray();
        int pow =  (int) Math.pow(10, nums.length - 1);
        int first = nums[0] - '0';
        int last = n - pow * first;
        int tmp = first > 1 ? pow : last;
        return countDigitOne(pow - 1) * first + tmp + countDigitOne(last);
    }
}
