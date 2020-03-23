package str;

import java.util.Arrays;

/**
 * https://www.jianshu.com/p/dcfa55a773f0
 */
public class StrStr {
    public static void main(String[] args) {
//        System.out.println(strStr("hell", "ll"));
        System.out.println(kmp("abbababbabbbabaaabbaabbabababbbaaaaaaababbabaababaabbbbaaabbbabb", "abbabbbabaa"));
//        System.out.println(strStr("abbababbabbbabaaabbaabbabababbbaaaaaaababbabaababaabbbbaaabbbabb", "abbabbbabaa"));
    }

    private static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        if (needle.length() > haystack.length()) {
            return -1;
        }
        boolean sign = false;

        for (int i = 0; i < (haystack.length() - needle.length() +1); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                sign = true;
                for (int j = 1; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        sign = false;
                        break;
                    }
                }
            }
            if (sign) {
                return i;
            }
        }
        return -1;
    }

    private static int kmp(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] nextArr = next(needle);
        int k = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (k > 0 && needle.charAt(k) != haystack.charAt(i)) {
                k = nextArr[k-1];
            }
            if (needle.charAt(k) == haystack.charAt(i)) {
                k++;
            }
            if (k == needle.length()) {
                return i - k + 1;
            }
        }
        return -1;
    }

    private static int[] next(String needle) {
        int k = 0;
        int[] next = new int[needle.length()];
        next[0] = k;
        for (int i = 1; i < needle.length(); i++) {
            if (k > 0 && needle.charAt(k) != needle.charAt(i)) {
                k = next[k - 1];
            }
            if (needle.charAt(k) == needle.charAt(i)) {
                k++;
            }
            next[i] = k;
        }
        return next;
    }
}
