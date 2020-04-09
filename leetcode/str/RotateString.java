/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/9
 * Time: 11:38 AM
 */

/**
 * https://leetcode-cn.com/problems/rotate-string/
 *
 * 796. 旋转字符串
 * 给定两个字符串, A 和 B。
 *
 * A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True。
 *
 * 示例 1:
 * 输入: A = 'abcde', B = 'cdeab'
 * 输出: true
 *
 * 示例 2:
 * 输入: A = 'abcde', B = 'abced'
 * 输出: false
 */
public class RotateString {
    public static void main(String[] args) {

        System.out.println((new RotateString()).rotateString("aa", "a"));
        System.out.println();
    }
    /**
     * kmp 算法
     * @param A
     * @param B
     * @return
     */
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.length() == 0 && B.length() == 0) {
            return true;
        }
        return kmp(A + A, B);
    }
    public boolean kmp(String A, String B) {
        int m = A.length();
        int n = A.length();
        int[] next = next(B);
        int k = 0;
        for (int i = 0; i < m; i++) {
            while (k > 0 && A.charAt(i) != B.charAt(k)) {
                k = next[k - 1];
            }
            if (A.charAt(i) == B.charAt(k)) {
                k++;
            }
            if (k == B.length()) {
                return true;
            }
        }
        return false;
    }

    public int[] next(String str) {
        int len = str.length();
        int[] next = new int[len];
        int k = 0;
        next[0] = k;
        for (int i = 1; i < len; i++) {
            while (k > 0 && str.charAt(k) == str.charAt(i)) {
                k = next[k - 1];
            }
            if (str.charAt(k) == str.charAt(i)) {
                k++;
            }
            next[i] = k;
        }
        return next;
    }
}
