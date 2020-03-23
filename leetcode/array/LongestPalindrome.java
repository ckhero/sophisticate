package array;

public class LongestPalindrome {
    public static void main(String[] args) {

        // allocate 4M space
        byte[] b = new byte[4 * 1024 * 1024];
        System.out.println("first allocate");
        // allocate 4M space
        b = new byte[4 * 1024 * 1024];
        System.out.println("second allocate");
        System.out.println(longestPalindrome("aaaa"));
    }

    private static String longestPalindrome(String s) {
        if (s.length() == 0) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int left = 0, right = 0;
        for (int i = s.length() - 2; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < s.length(); j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i+1][j-1]);
                if (dp[i][j] && right - left < j - i) {
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
