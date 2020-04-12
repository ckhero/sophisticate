package str;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * 151. 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 *
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 */
public class ReverseWords {
    public static void main(String[] args) {
//        String ans = (new ReverseWords()).reverseWords("   the    sky is blue   ");
        String ans = (new ReverseWords()).reverseWords(" ");
        System.out.println(ans);
    }
    public String reverseWords(String s) {
        int len = s.length();
        int left = len - 1;
        int right = len - 1;
        String ans = "";
        while (left >= 0) {
            if (s.charAt(left) == ' ' && right - left == 0) {
                right--;
                left--;
                continue;
            }
            if (s.charAt(left) == ' ' && right - left > 0) {
                String tmp = s.substring(left + 1, right + 1);
                ans = ans.isEmpty() ? tmp : ans + " " + tmp;
                left--;
                right = left;
                continue;
            }
            left--;
        }
        if (right - left > 0) {
            String tmp = s.substring(left + 1, right + 1);
            ans = ans.isEmpty() ? tmp : ans + " " + tmp;
        }
        return ans;
    }
}
