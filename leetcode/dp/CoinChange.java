package dp;

import java.util.Arrays;

/**
 * f(k)
 * f(1) = 1
 * f(2) = 1
 * f(3) =
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] nums = new int[] {2};
        System.out.println(coinChange(nums, 3));
    }

    private static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
