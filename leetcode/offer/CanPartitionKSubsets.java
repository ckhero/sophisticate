package offer;

import java.util.Arrays;

public class CanPartitionKSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        boolean[] used = new boolean[nums.length];
        return help(nums, k, sum / k, 0, 0 ,used);
    }

    public boolean help(int[] nums, int k, int target, int curr, int start, boolean[] used) {
        if (k == 0) {
            return true;
        }
        if (curr == target) {
            return help(nums, k - 1, target, 0, 0, used);
        }
        for (int i = start; i < nums.length; i++) {
            if ( !used[i] && curr + nums[i] <= target) {
                used[i] = true;
                if (help(nums, k, target, curr + nums[i], i + 1, used)) {
                    return true;
                }
                used[i] = false;

            }
        }
        return false;
    }
}
