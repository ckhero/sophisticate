package ptr;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * 通过次数86,347提交次数198,379
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
//        int[] nums = new int[]{-1,2,1,-4};
        int[] nums = new int[]{1,1,-1,-1,3};
        System.out.println((new ThreeSumClosest()).threeSumClosest(nums, -1));
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int len = nums.length;
        if (len < 3)  {
            return 0;
        }
        for (int i = 0; i < len - 2; i++) {
            if (min - target == 0) {
                break;
            }
            int curr = nums[i];
            //去重
            if (i > 0 && curr == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = len -  1;
            while (left < right) {
                if (left > i  + 1 && nums[left] == nums[left - 1]) {
                    continue;
                }

                int sum = curr + nums[left] + nums[right];
                min = min == Integer.MAX_VALUE || Math.abs(min - target) > Math.abs(sum - target) ? sum : min;
                if (sum == target) {
                    left++;
                    right--;
                    break;
                }

                if (sum > target) {
                    while (left < right && nums[right] == nums[--right]){}
                }
                if (sum < target) {
                    while (left < right && nums[left] == nums[++left]){}
                }
            }
        }
        return min;
    }
}
