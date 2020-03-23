package dp;

public class LengthOfLIS {

    public static void main(String[] args) {

    }

    private static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLen = 0;
        for (int i = 1; i < nums.length; i++) {

            int maxTmp = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxTmp = Math.max(maxTmp, dp[j]);
                }
                dp[i] = maxTmp + 1;
            }
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
    }
}
