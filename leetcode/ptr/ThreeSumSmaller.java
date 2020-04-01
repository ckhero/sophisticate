package ptr;

import java.util.Arrays;

/**
 * 259. 较小的三数之和
 * 给定一个长度为 n 的整数数组和一个目标值 target，寻找能够使条件 nums[i] + nums[j] + nums[k] < target 成立的三元组  i, j, k 个数（0 <= i < j < k < n）。
 *
 * 示例：
 *
 * 输入: nums = [-2,0,1,3], target = 2
 * 输出: 2
 * 解释: 因为一共有两个三元组满足累加和小于 2:
 *      [-2,0,1]
 *      [-2,0,3]
 * 进阶：是否能在 O(n2) 的时间复杂度内解决？
 *
 * 通过次数2,081提交次数3,734
 */
public class ThreeSumSmaller {
    public static void main(String[] args) {
//        int[] nums = new int[]{-2,1,-1,2};
//        int[] nums = new int[]{3,1,0,-2};
        int[] nums = new int[]{2,0,0,2,-2};
        System.out.println((new ThreeSumSmaller()).threeSumSmaller(nums, 2));
    }
    public int threeSumSmaller(int[] nums, int target) {
        //允许重复
        Arrays.sort(nums);
        int ans = 0;
        int len = nums.length;
        if (len < 3) {
            return 0;
        }

        for (int i = 0; i < len; i++) {
            int left = i + 1;
            int right = len - 1;
            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];
                if (sum < target) {
                    ans += right - left;
                    left++;
                    continue;
                } else {
                    right --;
                }
            }
        }
        return ans;
    }
}
