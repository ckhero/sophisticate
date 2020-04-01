package dp.bag;

public class Bag01 {
    public static void main(String[] args) {
        System.out.println((new Bag01()).solution2(new int[]{6,3,5,4,6},
                new int[]{2,2,6,5,4}
        , 10));
    }

    public int solution1(int[] vals, int[] weights, int cap) {
        int len = vals.length;
        int[][] dp = new int[len + 1][cap + 1];

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= cap; j++) {
                if (j - weights[i - 1] >=0 ) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + vals[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len][cap];
    }

    public int solution2(int[] vals, int[] weights, int cap) {
        int len = vals.length;
        int[] dp = new int[cap + 1];

        for (int i = 1; i <= len; i++) {
            for (int j = cap; j >= 1; j--) {
                if (j - weights[i - 1] >=0 ) {
                    dp[j] = Math.max(dp[j], dp[j - weights[i - 1]] + vals[i - 1]);
                }
            }
        }
        return dp[cap];
    }
}
