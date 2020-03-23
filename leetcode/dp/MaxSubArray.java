package dp;

/**
 * f(k) = max(num[i], f(k-1) + num[i])
 */
public class MaxSubArray {
    public static void main(String[] args) {

    }

    private static int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > 0)  nums[i] += nums[i-1];
            max =  Math.max(nums[i], max);
        }
        return max;
    }
}
