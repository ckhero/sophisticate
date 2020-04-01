package dp;

import java.util.Arrays;

/**
 * 1262. 可被三整除的最大和
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 * 示例 2：
 *
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 * 示例 3：
 *
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 */
public class MaxSumDivThree {

    public static void main(String[] args) {
        int[] nums = new int[]{3,6,5,1,8};
//        int[] nums = new int[]{1,2,3,4,4};
        System.out.println((new MaxSumDivThree()).maxSumDivThree(nums));
    }

    /**
     * dp[i][0]  i个数 余0的最大值
     * dp[i][1] i个数 余1的最大值
     * dp[i][2] i个数 余2的最大值
     * @param nums
     * @return
     */
    public int maxSumDivThree(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len + 1][3];
        //很关键 初始化
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;
        for (int i = 1; i <= len ; i++) {
            int carry = nums[i - 1] % 3;
            if (carry == 0) {
                dp[i][0] = dp[i - 1][0] + nums[i -1];
                dp[i][1] = dp[i - 1][1] + nums[i - 1];
                dp[i][2] = dp[i - 1][2] + nums[i - 1];
            } else if (carry == 1) {
                dp[i][0] = Math.max(dp[i - 1][2] + nums[i - 1], dp[i - 1][0]);
                dp[i][1] = Math.max(dp[i - 1][0] + nums[i - 1], dp[i - 1][1]);
                dp[i][2] = Math.max(dp[i - 1][1] + nums[i - 1], dp[i - 1][2]);
            } else if (carry == 2) {
                dp[i][0] = Math.max(dp[i - 1][1] + nums[i - 1], dp[i - 1][0]);
                dp[i][1] = Math.max(dp[i - 1][2] + nums[i- 1], dp[i - 1][1]);
                dp[i][2] = Math.max(dp[i - 1][0] + nums[i - 1], dp[i - 1][2]);
            }
        }
        return dp[len][0];
    }
}
