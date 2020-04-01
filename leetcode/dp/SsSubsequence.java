package dp;

public class SsSubsequence {
    public static void main(String[] args) {
        System.out.println((new SsSubsequence()).isSubsequence("abc", "ahbgdc"));
    }
    /**
     * 392. 判断子序列
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     *
     * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
     *
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     *
     * 示例 1:
     * s = "abc", t = "ahbgdc"
     *
     * 返回 true.
     *
     * 示例 2:
     * s = "axc", t = "ahbgdc"
     *
     * 返回 false.
     *
     * 后续挑战 :
     *
     * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
     *
     * 致谢:
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int sx = 0;
        int tx = 0;
        while (sx < len1 && tx < len2) {
            char curs = s.charAt(sx);
            char curt = t.charAt(tx);
            if (curs == curt) {
                sx ++;
                tx ++;
                continue;
            }
            tx++;
        }
        return sx == len1;
    }

//    public boolean isSubsequence(String s, String t) {
//        char[] words = t.toCharArray();
//        int len = words.length;
//        int start = 0;
//        for (int i = 0; i < s.length(); i++) {
//            boolean flag = false;
//            for (int j = start; j < len; j++) {
//                start++;
//                if (words[j] == s.charAt(i)) {
//                    flag = true;
//                    break;
//                }
//            }
//            if (start >= len && !flag) {
//                return false;
//            }
//        }
//        return true;
//    }

}
