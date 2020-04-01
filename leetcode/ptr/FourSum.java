package ptr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 * 通过次数65,859提交次数176,307
 */
public class FourSum {
    public static void main(String[] args) {
        int[] nums = new  int[]{1, 0, -1, 0, -2, 2};
        System.out.println((new FourSum()).fourSum(nums, 0));

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i +  1; j < len - 2; j++) {
                if (j > i +  1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    if (left > j + 1 && nums[left] == nums[left -  1]) {
                        left++;
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> tmp = Arrays.asList(nums[i], nums[j], nums[left++], nums[right--]);
                        ans.add(tmp);
                    } else if (sum < target) {
                        while (left < right && nums[left] == nums[++left]) {}
                    } else if (sum > target) {
                        while (left < right && nums[right] == nums[--right]) {}
                    }
                }
            }
        }
        return ans;
    }
}
