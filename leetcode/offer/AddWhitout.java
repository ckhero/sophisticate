package offer;

/**
 * https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 * 面试题65. 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 *
 *
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 *
 *
 * 提示：
 *
 * a, b 均可能是负数或 0
 */
public class AddWhitout {
    public int add(int a, int b) {
        while (b != 0) {
            int tmp = a ^ b;
            int tmp2 = (a & b) << 1;
            a = tmp;
            b = tmp2;
        }
        return a;
    }
}
