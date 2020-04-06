package top200;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/maximum-size-subarray-sum-equals-k/
 * 325. 和等于 k 的最长子数组长度
 * 给定一个数组 nums 和一个目标值 k，找到和等于 k 的最长子数组长度。如果不存在任意一个符合要求的子数组，则返回 0。
 *
 * 注意:
 *  nums 数组的总和是一定在 32 位有符号整数范围之内的。
 *
 * 示例 1:
 *
 * 输入: nums = [1, -1, 5, -2, 3], k = 3
 * 输出: 4
 * 解释: 子数组 [1, -1, 5, -2] 和等于 3，且长度最长。
 * 示例 2:
 *
 * 输入: nums = [-2, -1, 2, 1], k = 1
 * 输出: 2
 * 解释: 子数组 [-1, 2] 和等于 1，且长度最长。
 * 进阶:
 * 你能使时间复杂度在 O(n) 内完成此题吗?
 */
public class MaxSubArrayLen {
    public static void main(String[] args) {
        int[] nums = new int[]{1,-1,5,-2,3};
//        int[] nums = new int[]{-2,-1,2,1};
        int ans =  (new MaxSubArrayLen()).maxSubArrayLen(nums, 3);
        System.out.println(ans);
    }
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int tmp = sum - k;
            if (map.containsKey(tmp)) {
                ans = Math.max(ans, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)){
                map.put(sum, i);
            }

        }
        return ans;
    }
}
