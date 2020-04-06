/**
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * 416. 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 */
public class CanPartition {
    public static void main(String[] args) {
//        int[] nums = new int[]{1, 5, 11, 5};
        int[] nums = new int[]{1, 2, 3, 5};
        System.out.println((new CanPartition()).canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int len = nums.length;
        if (total % 2 != 0 || len <= 1) {
            return false;
        }
        int target = total / 2;
        int[][] dp = new int[len + 1][target + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= target ; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len][target] == target;
    }
}
