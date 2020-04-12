package offer;

/**
 * 面试题05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class ReplaceSpace {

    public String replaceSpace(String s) {
        char[] ss = s.toCharArray();
        StringBuilder str = new StringBuilder();
        for (char c : ss) {
            if (c == ' ') {
                str.append("%20");
            } else {
                str.append(c);
            }
        }
        return str.toString();
    }
}
