/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/1
 * Time: 3:14 PM
 */

import java.util.Stack;

/**
 * 402. 移掉K位数字
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 */
public class RemoveKdigits {
    public static void main(String[] args) throws Exception {
//        System.out.println((new RemoveKdigits()).removeKdigits("11", 2));
//        System.out.println((new RemoveKdigits()).removeKdigits("10200", 1));
//        System.out.println((new RemoveKdigits()).removeKdigits("112", 1));
//        System.out.println((new RemoveKdigits()).removeKdigits("5337", 2));
//        System.out.println((new RemoveKdigits()).removeKdigits("1432219", 3));
        System.out.println((new RemoveKdigits()).removeKdigits("99641043637881536115347130215819342018286368478941148499497648482711459533461004", 10));
    }

    public String removeKdigits(String num, int k) {
        return num;
    }
}
