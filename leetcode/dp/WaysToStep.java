package dp;

public class WaysToStep {
    public static void main(String[] args) {
        System.out.println((new WaysToStep()).waysToStep(3));
    }
    /**
     * (x+y) % p = (x%p + y%p)%p
     * (x+y + z) % p = ((x%p + y%p)%p + z %p)%p
     * @param n
     * @return
     */
    public int waysToStep(int n) {
        if (n <= 2) {
            return n;
        }
        // dp[i] 为取余后的结果
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for (int i = 3; i < n ; i++) {
            dp[i] = ((dp[i - 3] + dp[i - 2]) % 1000000007 + dp[i - 1]) % 1000000007;
        }
        return dp[n - 1];
    }
}
